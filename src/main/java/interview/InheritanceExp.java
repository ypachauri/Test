package interview;

class ClassA
{
	public void MethodA()
	{
		System.out.println("MethodA Called");
	}
}
class ClassB extends ClassA
{
	public void MethodA()
	{
		System.out.println("MethodB Called");
	}
}
public class InheritanceExp 
{
	public static void main(String[] args) {
		ClassA a = new ClassB();
		a.MethodA();
	}
}