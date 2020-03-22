package interview;

public class Employee {
	{
		System.out.println("class block");
	}
	static{
		System.out.println("static block");
	}
	public static void main(String... args){
		Employee e = new Employee();
	}
}
