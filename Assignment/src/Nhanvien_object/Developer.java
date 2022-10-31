package Nhanvien_object;

import java.util.ArrayList;

/**
 * @author PSL3
 *
 */
public class Developer extends Employee {

	private String teamName;

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public ArrayList<String> getProgrammingLanguages() {
		return programmingLanguages;
	}

	public void setProgrammingLanguages(ArrayList<String> programmingLanguages) {
		this.programmingLanguages = programmingLanguages;
	}

	public int getExpYear() {
		return expYear;
	}

	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}

	private ArrayList<String> programmingLanguages;
	private int expYear;

	public Developer(String empID, String empName, int baseSal, String teamName, ArrayList<String> programmingLanguages,
			int expYear) {
		super(empID, empName, baseSal);
		this.teamName = teamName;
		this.programmingLanguages = programmingLanguages;
		this.expYear = expYear;
	}

	@Override
	public double getSalary() {
		if (getExpYear() >= 5) {
			return getBaseSal() + getExpYear() * 2000000;
		} else if (5 > getExpYear() && getExpYear() >= 3) {
			return getBaseSal() + getExpYear() * 1000000;
		} else {
			return getBaseSal();
		}

	}

	@Override
	public String toString() {
		return getEmpID() + "_" + getEmpName() + "_" + getBaseSal() + "_" + getTeamName() + "_"
				+ getProgrammingLanguages() + "_" + getExpYear();
	}

}

