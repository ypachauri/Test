package interview;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
	
	public static void main(String[] args)
	{
		Map mp = new ConcurrentHashMap<>();
//		mp.get(null);
		
		Test test = new Test();
//		test.nullChk(null);
		
//		System.err.println(finallyReturnTest());
	}
	
	static int finallyReturnTest()
	{
		try
			{
				int a = 10/2;
				return 1;
			} 
			catch(Exception e)
			{
				return 2;
			}
			finally {
				return 3;
			}
	}
	
	static void nullChk(String s)
	{
		System.err.println("String");
	}
	static void nullChk(Object o)
	{
		System.err.println("Object");
	}
	static void nullChk(Integer i)
	{
		System.err.println("Integer");
	}
}
