package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import mongocrud.User;

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
    
    static void TestGroupBy()
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
    
    static void TestObject()
    {
    	List<User> users = new ArrayList<>();
    	users.add(new User(3, "Yash", "Tester", true));
    	users.add(new User(3, "Yash", "Dev", true));
    	users.add(new User(5, "Deepak", "Java Dev", true));
    	users.add(new User(2, "Kushal", "Coder", true));
    	users.add(new User(4, "Akash", "Programmer", true));
    	users.add(new User(6, "Ankit", "UI dev", true));
    	
    	Map<String, Integer> aggregateResults = users.stream().collect(Collectors.groupingBy(User::getName, Collectors.summingInt(User::getId)));
//    	System.err.println(aggregateResults);
    	
    	List<User> filterResults = users.stream().filter(p -> p.getId() > 3).collect(Collectors.toList());
    	System.err.println(filterResults);
    	
    	Stream<User> distinctResults = users.stream().distinct();
//    	distinctResults.forEach(System.out::println);
    	
//    	Stream<User> sortedResults = users.stream().sorted(Comparator.comparingInt(User::getId));
    	Stream<User> sortedResults = users.stream().sorted(Comparator.comparing(User::getName));
    	sortedResults.forEach(System.out::println);
    }
    
    static void TestList()
    {
    	List<String> list = new ArrayList<>();
    	list.add("Yash");
    	list.add("Yash");
    	list.add("Deepak");
    	list.add("Kushal");
    	list.add("Akash");
    	list.add("Ankit");
    	
    	Map<String, Long> aggregateResults = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    	System.err.println(aggregateResults);
    	
    	Stream<String> distinctResults = list.stream().distinct();
//    	distinctResults.forEach(System.out::println);
    	
//    	Stream<User> sortedResults = users.stream().sorted(Comparator.comparingInt(User::getId));
    	Stream<String> sortedResults = list.stream().sorted(Comparator.comparing(Function.identity()));
//    	list.sort(Comparator.reverseOrder());
    	sortedResults.forEach(System.out::println);
    }
    
    static void Test()
    {
    	List<Integer> list = Arrays.asList(10, 19, 20, 1, 2);
    	list.stream().parallel().forEachOrdered(System.out::println);
    	list.stream().parallel().forEach(System.err::println);
    }
  
    /* program to test above function */
    public static void main(String args[]) 
    { 
//    	TestGroupBy();
    	TestObject();
//    	TestList();
//    	Test();
    }

}
