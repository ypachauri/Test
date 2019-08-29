/*
 
 * 1. core java basics
 * 2. threading, collection, exception
 * 3. programs
 
 * 4. Spring, hibernate
 * 5. Database
 * 6. Advance java (Jsp Servlets)

 */
package interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import mongocrud.User;

public class Interview {
	
	// Important
	static void ReverseArrayInPlace(int position)
    {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int j = position;
        for(int i = 0; i < position/2; i++)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
        }
        System.out.println(Arrays.toString(arr));
    }
    
    static void MissingFromArray()
    {
        int[] arr = { 1, 2, 3, 5, 6, 7, 9, 10, 11 };
        int count = 1;
        for(int i = 1; i < arr.length; i++)
        {
            if(arr[count-1] != i)
            {
                System.out.println(i);
                count--;
            }
            count++;
        }
    }
    
    static void LargestSmallestFromArray()
    {
        int[] arr = { 0, 3, 1, 2, 5, 9, 10, 4 };
        int largest = arr[0];
        int smallest = arr[0];
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] > largest) largest = arr[i];
            if(arr[i] < smallest) smallest = arr[i];
        }
        System.out.println("Largest := "+largest+"\nSmallest := "+smallest);
    }
    
    static void ShowDuplicatesFromArray()
    {
        int[] arr = { 0, 3, 1, 2, 3, 5, 2, 3, 0, 2, 0, 5, 3 };
        Set<Integer> set = new HashSet();
        for(int i = 0; i < arr.length; i++) set.add(arr[i]);
        System.out.println(set);
        
//        int[] result = new int[arr.length];
//        result[0] = arr[0];
//        int count = 1;
//        boolean flag = false;
//        for(int i = 0; i < arr.length; i++)
//        {
//            for(int j = 0; j < i; j++)
//            {
//                
//                if(arr[i] == arr[j])
//                {
//                	flag = true;
//                    break;
//                }
//                else flag = false;
//            }
//            if(flag)
//            {
//            	result[count] = arr[i];
//            	count++;
//            }
//        }
//        System.out.println(Arrays.toString(result));
    }
    
    static void DuplicatesInArrayOnth()
    {
        int[] arr = { 1, 2, 3, 1, 3, 6, 6 };
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[Math.abs(arr[i])] >= 0) arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            else System.out.println(Math.abs(arr[i]));
        }
    }
    
    static void RemoveDuplicatesFromArray()
    {
        int[] arr = { 1, 2, 2, 3, 4, 4, 4, 5, 5, 6, 3, 5 };
        int[] result = new int[arr.length];
        result[0] = arr[0];
        int count = 1;
        boolean flag = false;
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(arr[i] == arr[j])
                {
                	flag = false;
                    break;
                }
                else flag = true;
            }
            if(flag)
            {
            	result[count] = arr[i];
            	count++;
            }
        }
        System.out.println(Arrays.toString(result));
    }
    
    static void BubbleSort()
    {
    	int[] arr = { 5, 9, 1, 4, 2, 3 };
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr.length; j++)
			{
				if(arr[i] < arr[j])
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
    }
    
    static void MapSortByValues()
    {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("a", 4);
        map.put("b", 2);
        map.put("c", 5);
        map.put("d", 3);
        map.put("e", 1);
        
//        Set<Entry<String, Integer>> set = map.entrySet();
//        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
//        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
//        {
//            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
//            {
//                return (o2.getValue()).compareTo( o1.getValue() );
//            }
//        } );
//        for(Map.Entry<String, Integer> entry:list){
//            System.out.println(entry.getKey()+" ==== "+entry.getValue());
//        }
        LinkedHashMap<String, Integer> collect = map.entrySet().stream().sorted((o1,o2) -> (o1.getValue()-o2.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        collect.entrySet().forEach(System.out::println);
    }
    
    static void ReadFileAndCount()
    {
    	File f = new File("D://sample.txt");
		Set<String> set = new HashSet<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = null;
			while((line = br.readLine()) != null)
			{
				String[] name = line.split(" ");
				for(int i = 0; i < name.length; i++)
				{
					set.add(name[i]);
				}
			}
			br.close();
			set.forEach(System.out::println);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    // Important
    static void ElementsCount()
    {
    	List<String> list = Arrays.asList("abc", "xyz", "abc", "type", "rtrtr", "ppp", "xyz", "rtr", "pop", "xyz", "abc", "xyz", "abc", "xyz");
    	Map<String, Integer> map = new HashMap<>();
    	for (int i = 0; i < list.size(); i++) 
    	{
			if (map.containsKey(list.get(i))) 
			{
				int count = map.get(list.get(i));
				map.put(list.get(i), count+1);
			}
			else map.put(list.get(i), 1);
		}
    	map.entrySet().forEach(System.out::println);
    }
    // Important
    static void AllSubstrings()
    {
    	String s = "yash";
    	for(int i = 0; i < s.length(); i++)
    	{
	    	for(int j = i; j < s.length(); j++)
	    	{
	    		for(int k = i; k <= j; k++)
	    		{
	    			System.out.print(s.charAt(k));
	    		}
	    		System.out.println();
	    	}
    	}
    }
    // Important
    static void FindString()
    {
    	String text = "abcNjhgAhGjhfhAljhRkhgRbhjbevfhO";
    	String name = "NAGARRO";
    	String result = "";
    	int nameCount = 0;
		int index = 0;
    	for(int i=0; i < text.length(); i++)
    	{
    		if(nameCount < name.length() && text.charAt(i) == name.charAt(nameCount))
    		{
    			if(result.length() == 0) index = i;
    			result += text.charAt(i);
    			nameCount++;
    		}
    	}
    	if(name.length() == result.length()) System.out.println("Result := "+result+"\nAt Index := "+index);
    	else System.out.println("String not found");
    }
    // Important
    static void PrintArrayInOneLoop()
	{
		int n = 5, k = 0;
		for(int i = 1; i <= n*2 ; i++)
		{
			if(i <= n)
				System.out.println(i);
			else
			{
				k = k+2;
				System.out.println(((i-k)+1));
			}
		}
	}
    // Important
    static void SwipeWithoutUsingThirdVar()
	{
		int x = 5, y = 10;
		x = x + y;
		y = x - y;
		x = x - y;
		System.out.println("x = "+x+", y = "+y);
	}
    // Important
    static void ReverseInteger()
    {
    	int num = 121, reverse = 0, originalNum = num;
    	while(num != 0)
    	{
    		reverse = reverse * 10;
    		reverse = reverse + num % 10;
    		num = num / 10;
    	}
    	if(originalNum == reverse) System.out.println("Palindrome");
		else System.out.println("Not Palindrome");
    	System.out.println("Reversed Number is := " + reverse);
    }
    
    static void ObjectSorting()
    {
    	List<User> users = new ArrayList<>();
    	users.add(new User(3, "Yash", "Tester", true));
    	users.add(new User(3, "Yash", "Dev", true));
    	users.add(new User(5, "Deepak", "Java Dev", true));
    	users.add(new User(2, "Kushal", "Coder", true));
    	users.add(new User(4, "Akash", "Programmer", true));
    	users.add(new User(6, "Ankit", "UI dev", true));
    	
    	//users.sort((o1,o2) -> o1.getId()-o2.getId());
    	users.sort(Comparator.comparing(User::getId).thenComparing(User::getRole));
    	users.forEach(System.out::println);
    }
    
    static void PrimeNumber()
    {
    	int num = 3;
    	boolean flag = false;
    	for(int i = 2; i <= num/2; i++)
    	{
    		if(num % i == 0)
    		{
    			flag = true;
    			break;
    		}
    	}
    	if(!flag) System.out.println("Prime");
    	else System.out.println("Not Prime");
    }
    
    static void EqualsHashCodeTest()
    {
    	User user = new User(3, "Yash", "Tester", true);
    	User user2 = new User(3, "Yash", "Tester", true);
    	System.out.println("User1 HashCode := "+user.hashCode()+"\nUser2 HashCode := "+user2.hashCode());
    	Map<User, String> map = new HashMap<User, String>(); 
        map.put(user, "CSE"); 
        map.put(user2, "IT");
        map.entrySet().forEach(System.out::println);
    }
    
    static void PrePostIncrement()
    {
    	int i = 1;
    	System.out.println("i \t:= "+i);
    	System.out.println("i++ \t:= "+i++);
    	System.out.println("i \t:= "+i);
    	System.out.println("++i \t:= "+(++i));
    	System.out.println("i \t:= "+i);
    	
//    	++i increments and then uses the variable.
//    	i++ uses and then increments the variable.
    }
    
    static void Fabonacci()
    {
    	int prev = 0, next = 1, sum = 0;
    	for(int i = 0; i < 10; i++)
    	{
    		sum = prev + sum;
    		prev = next;
    		next = sum;
    		System.out.println(sum);
    	}
    }
    
    public static void main(String[] args) 
    {
    	try {
	        String methodName = "Fabonacci";
	        int param = 0;
	        Class c = Class.forName("interview.Interview");
			Method m = c.getDeclaredMethod(methodName, null);
			m.invoke(c, null);
//			Method m = c.getDeclaredMethod(methodName, int.class);
//			m.invoke(c, param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        int val = 0;
        
        switch (val) {
		case 1:
			ReverseArrayInPlace(6);
			break;
		case 2:
			MissingFromArray();
			break;
		case 3:
			ShowDuplicatesFromArray();
			break;
		case 4:
			LargestSmallestFromArray();
			break;
		case 5:
			DuplicatesInArrayOnth();
			break;
		case 6:
			RemoveDuplicatesFromArray();
			break;
		case 7:
			BubbleSort();
			break;
		case 8:
			MapSortByValues();
			break;
		case 9:
			ReadFileAndCount();
			break;
		case 10:
			ElementsCount();
			break;
		case 11:
			AllSubstrings();
			break;
		case 12:
			FindString();
			break;
		case 13:
			PrintArrayInOneLoop();
			break;
		case 14:
			SwipeWithoutUsingThirdVar();
			break;
		case 15:
			ReverseInteger();
			break;
		case 16:
			AllSubstrings();
			break;
		default:
			break;
		}
    }
}
