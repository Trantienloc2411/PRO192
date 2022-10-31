/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nhanvien_object;

public class Tester extends Employee {

	private double bonusRate;
	private String type;

	public double getBonusRate() {
		return bonusRate;
	}

	public void setBonusRate(double bonusRate) {
		this.bonusRate = bonusRate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Tester(String empID, String empName, int baseSal, double bonusRate, String type) {
		super(empID, empName, baseSal);
		this.bonusRate = bonusRate;
		this.type = type;
	}

	@Override
	public double getSalary() {
		return getBaseSal() + getBonusRate() * getBaseSal();
	}

}

