package interview;

class Class1
{
	Class1()
	{
		System.out.println("Class1 Constructor Called");
	}
	void Method() throws Exception
	{
		System.out.println("Class1 Method Called");
		int a = 10 / 0;
	}
}
class Class2 extends Class1
{
	Class2()
	{
		System.out.println("Class2 Constructor Called");
	}
	void Method() throws ArithmeticException
	{
		System.out.println("Class2 Method Called");
		int a = 10 / 0;
	}
	int Method2()
	{
		try
		{
			System.exit(1);
			int a = 10 / 0;
			return 5;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return 4;
		}
		finally {
			return 0;
		}
	}
}
class Class3 extends Class2
{
	Class3()
	{
		System.out.println("Class3 Constructor Called");
	}
	void Method()
	{
		System.out.println("Class3 Method Called");
		try
		{
			int a = 10 / 0;
		}
		catch(ArithmeticException e)
		{
			
		}
		catch(Exception e)
		{
			
		}
	}
}
public class InheritanceExp 
{
	public static void main(String[] args) throws Exception
	{
		Class1 cls = new Class2();
		cls.Method();
//		System.out.println(cls.Method2());
	}
}