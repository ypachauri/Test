package interview;

interface I
{
	
}
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
	protected void Method() throws ArithmeticException
	{
		System.out.println("B Method Called");
	}
}
class C extends B implements I
{
	C()
	{
		System.out.println("C Constructor Called");
	}
	public void Method()
	{
		System.out.println("C Method Called");
	}
}
public class Inheritance
{
	public static void main(String[] args) throws Exception
	{
		A a = new C();
//		C c = new A();
		I i = new C();
//		I i = new A();
		a.Method();
//		System.out.println(cls.Method2());
	}
}
