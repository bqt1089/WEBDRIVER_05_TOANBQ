package javaForTesterOOP;

public class Employee  extends Person{
	private static int salary = 1000000;
	private static int rate = 8;
	
	
	public static void calculateSalary(String name, String age, String address, int salary, int rate) {
		System.out.println("Name : "+name);
		System.out.println("Age : "+age);
		System.out.println("Address : "+address);
		System.out.println("Salary : "+salary);
		System.out.println("Rate : "+rate);
		int totaSalary = salary*rate;
		System.out.println("Total Salary = "+ totaSalary);
	}
	
	public static void main(String args[]) {
		calculateSalary(name, age, address, salary, rate);
	}

}
