
public class Overloading {

	public static void method(int a) {

	}

	public static int method(Integer b) {
		return 0;
	}
	
	public static void main(String[] args) {
		Integer a = 127;
		Integer b = 127;
		System.out.println(a==b);
	}
}
