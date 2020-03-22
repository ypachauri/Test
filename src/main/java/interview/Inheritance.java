package interview;

class A
{
	A()
	{
		System.out.println("A Constructor Called");
	}
	void Method() throws Exception
	{
		System.out.println("A Method Called");
	}
}
class B extends A
{
	B()
	{
		System.out.println("B Constructor Called");
	}
	void Method() throws ArithmeticException
	{
		System.out.println("B Method Called");
	}
}
class C extends B
{
	C()
	{
		System.out.println("C Constructor Called");
	}
	void Method()
	{
		System.out.println("C Method Called");
	}
}
public class Inheritance
{
	public static void main(String[] args) throws Exception
	{
		A a = new C();
		a.Method();
//		System.out.println(cls.Method2());
	}
}
