package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Hello world!
 *
 */
public class App 
{
	static void test1()
	{
		List<String> list1 = new ArrayList<String>();
    	list1.add("foo");
    	
    	List<String> list2 = list1;
    	List<String> list3 = new ArrayList<>(list2);
    	
    	list1.clear();
    	list2.add("bar");
    	list3.add("baz");
    	
    	System.out.println(list1);
    	System.out.println(list2);
    	System.out.println(list3);
	}
	
	static void test2()
	{
		ArrayList<Double> dList = new ArrayList<>();
    	ArrayList<Number> numList = new ArrayList<>();
    	addPi(dList);
    	addPi(numList);
    	System.out.println(dList.toString());
    	System.out.println(numList.toString());
	}
	
	private static void addPi(ArrayList<? super Double> list)
	{
		list.add(Math.PI);
	}
	
	static void test3()
	{
		List<Integer> list = new ArrayList<>();
    	list.add(2);
    	list.add(3);
    	list.add(4);
    	list.add(5);
    	List<Integer> tempList = new ArrayList<>();
    	Iterator<Integer> itr = list.iterator();
    	while(itr.hasNext())
    	{
    		Integer element = itr.next();
    		if(element % 2 == 0)
    		{
    			itr.remove();
    		}
    	}
//    	for(Integer element : list)
//    	{
//    		if(element % 2 == 0)
//    		{
//    			list.remove(element);
//    		}
//    	}
//    	list.removeAll(tempList);
    	System.out.println(list);
	}
	
	static void test4()
	{
		Stack<String> stack = new Stack<>();
		Queue<String> queue = new LinkedList<>();
		stack.push("Apple");
		stack.push("Banana");
		stack.push("Cherry");
		queue.add(stack.pop());
		stack.push("Dingleberry");
		stack.push("Eggplant");
		queue.add("Fig");
		stack.push(queue.remove());
		queue.add(stack.pop());
		queue.add(stack.pop());
		
		System.out.println(stack);
		System.out.println(queue);
	}
	
	static void test5() throws IOException
	{
		try
		{
		File file = new File("F://sample.txt");
		Scanner sc = new Scanner(file);
		while(sc.hasNext())
		{
			System.out.println(sc.next());
		}
		FileReader fr = new FileReader("F://sample.txt");
		int i; 
	    while ((i=fr.read()) != -1) 
	      System.out.print((char) i);
		}catch(ArithmeticException e){
			
		}catch(Exception e){
			
		}
	}
	
	static void test6()
	{
		List<String> al = new ArrayList<>();
		int a;
		//a = al.stream().forEach(l -> );
	}
	
    public static void main( String[] args ) throws IOException
    {
    	test6();
    }
}
