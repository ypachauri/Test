package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	
    public static void main2( String[] args ) throws IOException
    {
    	String s = "6,1,2,3,4,5,6";
    	List<Integer> list = Stream.of(s.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    	int temp=0;
    	boolean flag=true;
    	for(int i=1;i<list.size();i++)
    	{
    		if(list.get(i)==temp) {
    			System.out.println(temp);
    			flag=false;
    			break;
    		}
    		temp = list.get(i);
    	}
    	if(flag) System.out.println("NONE");
    }
    
    static int getMissingNo(int a[], int n) 
    { 
    	try
    	{
        int i, total = 0, sum = 0; 
//        total = (n + 1) * (n + 2) / 2;
        for (i = 1; i <= n; i++) {
            total += i; 
            if(i < n) sum += a[i-1]; 
        }
        System.out.println("A");
        method();
        System.out.println("B");
        System.out.println(total-sum);
        return total-sum; 
    	} finally{
    		System.out.println("Finally");
    	}
        
    } 
    
    static void method()
    {
    	throw new Error();
    }
  
    /* program to test above function */
    public static void main(String args[]) 
    { 
        int a[] = { 5,1,6,4,2 }; 
        int miss = getMissingNo(a, 6); 
        System.out.println(miss);
//        System.out.println("Yash".substring(2,3));
//    	System.out.println("apple".compareTo("appl"));
    }
}
