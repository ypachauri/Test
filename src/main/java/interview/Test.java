package interview;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Test {
	
	public static void main(String[] args)
	{
		Map mp = new ConcurrentHashMap<>();
		//mp.get(null);
		Test test = new Test();
//		test.T(10.5);
		test.T(11l);
		test.T('a');
		System.err.println(finallyReturnTest());
	}
	
	static void flatMap()
	{
		Map<String, List<String>> people = new HashMap<>();
    	people.put("John", Arrays.asList("555-1123", "555-3389"));
    	people.put("Mary", Arrays.asList("555-2243", "555-5264"));
    	people.put("Steve", Arrays.asList("555-6654", "555-3242"));
    	 
    	List<String> phones = people.values().stream()
    	  .flatMap(Collection::stream)
    	    .collect(Collectors.toList());
    	System.err.println(phones);
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
	
	static void T(int i)
	{
		System.err.println("Integer "+i);
	}
	
	static void T(float f)
	{
		System.err.println("Float "+f);
	}
}
