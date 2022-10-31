package Nhanvien_object;
public abstract class Employee {

	private String empID;
	private String empName;
	private int baseSal;

	Employee(String empID, String empName, int baseSal) {
		this.empID = empID;
		this.empName = empName;
		this.baseSal = baseSal;
	}

	public String getEmpID() {
		return empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getBaseSal() {
		return baseSal;
	}

	public void setBaseSal(int baseSal) {
		this.baseSal = baseSal;
	}

	public abstract double getSalary();

	@Override
	public String toString() {
		return getEmpID() + "_" + getEmpName() + "_" + getBaseSal();
	}
}

    

