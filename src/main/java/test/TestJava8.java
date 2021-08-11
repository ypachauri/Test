package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestJava8 {
	
	static void TestRunnable()
    {
//    	ExecutorService executorService = Executors.newCachedThreadPool();
//    	ExecutorService executorService2 = Executors.newFixedThreadPool(5);
//    	ExecutorService executorService3 = Executors.newSingleThreadScheduledExecutor();
    	ExecutorService executorService4 = Executors.newSingleThreadExecutor();
    	Runnable run = () -> {
    		System.err.println("Running...");
    	};
    	executorService4.execute(run);
    	System.err.println(executorService4.submit(run));
    }
    
    static void GroupBy()
    {
    	List<Integer> list = Arrays.asList(2,5,3,6,9,1,7,4,0,8);
    	Object result = list.stream().mapToInt(a -> a).sum();
    	result = list.stream().max(Comparator.comparing(Integer::intValue));
    	result = list.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
    	
    	List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");
    	result = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    	
    	System.err.println(result);
    }
  
    /* program to test above function */
    public static void main(String args[]) 
    { 
    	GroupBy();
//    	Test();
    }

}
