package Nhanvien_object;

import java.util.ArrayList;

public class TeamLeader extends Developer {

	private double bonus_rate;

	/**
	 * @return the bonus_rate
	 */
	public double getBonusRate() {
		return bonus_rate;
	}


	public void setBonusRate(double bonus_rate) {
		this.bonus_rate = bonus_rate;
	}


	public TeamLeader(String empID, String empName, int baseSal, String teamName,
			ArrayList<String> programmingLanguages, int expYear, double bonus_rate) {
		super(empID, empName, baseSal, teamName, programmingLanguages, expYear);
		this.bonus_rate = bonus_rate;
	}

	@Override
	public double getSalary() {
		return super.getSalary() + super.getSalary() * getBonusRate();
	}

}


