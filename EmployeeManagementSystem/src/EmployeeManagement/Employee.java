package EmployeeManagement;

public class Employee {
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	private String firstName;
	private String lastName;
	private int employeeId;
	private int age;
	private String title;
	private String department;
	private float salary;
	public Employee() {
		
	}
}
