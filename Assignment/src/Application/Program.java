package Application;

import CompanyManagement.CompanyManagement;
import Nhanvien_object.Developer;
import Nhanvien_object.Employee;
import Nhanvien_object.Tester;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class Program {
	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		sb.append("\n1.Read all Employees and print to screen");
		sb.append("\n2.Show staff proficient in a Programming Language");
		sb.append("\n3.Show Tester has a height salary");
		sb.append("\n4.Show Employee's highest salary");
		sb.append("\n5.Show Leader of the Team has most Employees");
		sb.append("\n6.Sort Employees as descending salary");
		sb.append("\n7.Write file");
		sb.append("\n8.Exit");
		sb.append("\nYour option from 1 - 8 : ");

		int choice = 0;
		Scanner sc = new Scanner(System.in);
		CompanyManagement cm = new CompanyManagement(System.getProperty("user.dir") + "/src/File/IO/ListOfEmployees.txt",
				System.getProperty("user.dir") + "/src/File/IO/PLInfo.txt");
		ArrayList<Employee> empList;
		while (choice != 8) {
			System.out.println(sb.toString());
			choice = sc.nextInt();
			switch (choice) {

			case 1:
				empList = cm.getEmployeeFromFile(System.getProperty("user.dir") + "/src/File/IO/ListOfEmployees.txt",
						System.getProperty("user.dir") + "/src/File/IO/PLInfo.txt");
				empList.forEach(employee -> {
					System.out.println(employee.toString());
				});

				break;

			case 2:
				System.out.println("Input Programming Language: ");
				ArrayList<Developer> dList = cm.getDeveloperByProgrammingLanguage(sc.next());
				dList.forEach(employee -> {
					System.out.println(employee.toString());
				});
				break;

			case 3:
				System.out.println("Input Salary: ");
				ArrayList<Tester> tList = cm.getTestersHaveSalaryGreaterThan(sc.nextDouble());
				tList.forEach(employee -> {
					System.out.println(employee.toString());
				});
				break;

			case 4:
				System.out.println(cm.getEmployeeWithHighestSalary());
				break;

			case 5:
				System.out.println(cm.getLeaderWithMostEmployees());

				break;

			case 6:
				empList = cm.sorted();
				empList.forEach(employee -> {
					System.out.println(employee.toString());
				});
				break;

			case 7:

				File directory = new File(System.getProperty("user.dir") + "/src/output");
				if (!directory.exists()) {
					directory.mkdir();
				}

				cm.writeFile(System.getProperty("user.dir") + "/src/output/Req2.txt",
						cm.getDeveloperByProgrammingLanguage("C++"));

				cm.writeFile(System.getProperty("user.dir") + "/src/output/Req3.txt",
						cm.getEmployeesHaveSalaryGreaterThan(4700000));
				break;

			default:
				break;

			}
		}
	}

}

