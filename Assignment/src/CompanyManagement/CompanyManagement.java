package CompanyManagement;

import Nhanvien_object.Developer;
import Nhanvien_object.Employee;
import Nhanvien_object.TeamLeader;
import Nhanvien_object.Tester;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CompanyManagement {
	private ArrayList<Employee> empList = new ArrayList();

	public CompanyManagement(String path, String path1) {
		this.empList = getEmployeeFromFile(path, path1);
	}

	public ArrayList<Employee> getEmployeeFromFile(String path, String path1) {
		ArrayList<Employee> eList = new ArrayList();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			BufferedReader br1 = new BufferedReader(new FileReader(path1));

			String line;
			ArrayList<String> programmingLanguages;
			HashMap<String, ArrayList<String>> mp = new HashMap();
			while ((line = br1.readLine()) != null) {
				String[] ls = line.split(",");
				ArrayList<String> list = new ArrayList<String>(Arrays.asList(ls));
				list.remove(0);
				mp.put(ls[0], list);
			}

			while ((line = br.readLine()) != null) {
				String[] ls = line.split(",");
				if (ls[1].startsWith("D")) {
					if (ls[5].compareToIgnoreCase("L") == 0) {
						eList.add(new TeamLeader(ls[1], ls[2], Integer.parseInt(ls[7]), ls[3], mp.get(ls[2]),
								Integer.parseInt(ls[4]), Double.parseDouble(ls[6])));
					} else {
						eList.add(new Developer(ls[1], ls[2], Integer.parseInt(ls[5]), ls[3], mp.get(ls[2]),
								Integer.parseInt(ls[4])));
					}

				} else if (ls[1].startsWith("T")) {
					eList.add(new Tester(ls[1], ls[2], Integer.parseInt(ls[5]), Double.parseDouble(ls[3]), ls[4]));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return eList;
	}

	public ArrayList<Developer> getDeveloperByProgrammingLanguage(String pl) {
		ArrayList<Developer> dList = new ArrayList();
		for (Employee emp : this.empList) {
			if (emp instanceof Developer && ((Developer) emp).getProgrammingLanguages().contains(pl)) {
				dList.add((Developer) emp);
			}
		}
		return dList;
	}

	public ArrayList<Tester> getTestersHaveSalaryGreaterThan(double value) {
		ArrayList<Tester> tList = new ArrayList();
		for (Employee emp : this.empList) {
			if (emp instanceof Tester && ((Tester) emp).getSalary() > value) {
				tList.add((Tester) emp);
			}
		}
		return tList;
	}

	public ArrayList<Employee> getEmployeesHaveSalaryGreaterThan(double value) {
		ArrayList<Employee> tList = new ArrayList();
		for (Employee emp : this.empList) {
			if (emp.getSalary() > value) {
				tList.add(emp);
			}
		}
		return tList;
	}

	public Employee getEmployeeWithHighestSalary() {

		if (empList == null || empList.size() == 0) {
			return null;
		}
		Employee retEmp = empList.get(0);
		for (Employee emp : this.empList) {
			if (retEmp.getSalary() < emp.getSalary())
				retEmp = emp;
		}
		return retEmp;
	}

	public TeamLeader getLeaderWithMostEmployees() {
		Map<String, ArrayList<Employee>> team = new HashMap();
		Map<String, TeamLeader> tLeader = new HashMap();
		ArrayList<Employee> list;
		String teamName = "";
		for (Employee emp : this.empList) {
			if (emp instanceof TeamLeader) {
				teamName = ((TeamLeader) emp).getTeamName();
				tLeader.put(teamName, (TeamLeader) emp);

			} else if (emp instanceof Developer) {
				teamName = ((Developer) emp).getTeamName();
				if (team.containsKey(teamName)) {
					team.get(teamName).add(emp);
				} else {
					list = new ArrayList();
					list.add(emp);
					team.put(teamName, list);
				}
			}
		}
		int cnt = 0;
		for (Map.Entry<String, ArrayList<Employee>> entry : team.entrySet()) {
			if (entry.getValue().size() > cnt) {
				cnt = entry.getValue().size();
				teamName = entry.getKey();
			}
		}
		return tLeader.get(teamName);
	}

	public ArrayList<Employee> sorted() {
		ArrayList<Employee> sortedList = (ArrayList<Employee>) this.empList.clone();

		Collections.sort(sortedList, new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				if (e2.getSalary() - e1.getSalary() > 0)
					return 1;
				else if (e1.getSalary() == e2.getSalary()) {
					String[] e1Name = e1.getEmpName().split(" ");
					String[] e2Name = e2.getEmpName().split(" ");
					return e1Name[e1Name.length].compareTo(e2Name[e2Name.length]);
				} else
					return -1;

			}
		});
		return sortedList;

	}

	public void printEmpList() {
		this.empList.forEach(employee -> {
			System.out.println(employee.toString());
		});

	}

	public void printEmpList(ArrayList<Employee> list) {
		list.forEach(employee -> {
			System.out.println(employee.toString());
		});

	}

	public <E> boolean writeFile(String path, ArrayList<E> list) {
		try {
			File fileObj = new File(path);
			fileObj.createNewFile();
			FileWriter myWriter = new FileWriter(fileObj);
			for (E employee : list) {
				myWriter.write(employee.toString());
			}
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean writeFile(String path, Employee employee) {
		try {
			File fileObj = new File(path);
			fileObj.createNewFile();
			FileWriter myWriter = new FileWriter(fileObj);
			myWriter.write(employee.toString());
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
			return false;
		}
		return true;
	}

}

