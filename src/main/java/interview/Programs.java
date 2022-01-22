/*
 
 * 1. Core Java (Threading, Collection, Exception)
 * 2. Spring Boot, Hibernate
 * 3. Database
 * 4. Programs

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

public class Programs {
	
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
	
	static void getMissingNoFromArray()
    {
    	int[] arr = { 1, 2, 3, 5 };
        int n = arr.length + 1;
        
        int elements_sum = n * (n + 1) / 2;
        int sum = 0;
     
        for(int i = 0; i < n - 1; i++)
            sum += arr[i];
        
        int result = elements_sum - sum;     
        System.out.println(result);;
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
        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i] > largest) largest = arr[i];
            else if(arr[i] < smallest) smallest = arr[i];
        }
        System.out.println("Largest := "+largest+"\nSmallest := "+smallest);
    }
    
    static void ShowDuplicatesFromArray()
    {
        int[] arr = { 0, 3, 1, 2, 3, 5, 2, 3, 0, 2, 0, 5, 3 };
        Set<Integer> set = new HashSet<>();
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
            if(arr[Math.abs(arr[i])] >= 0) {
            	arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            }
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
    static void PrintInOneLoop()
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
		System.out.println("Before : x := "+x+", y := "+y);
		x = x + y;
		y = x - y;
		x = x - y;
		System.out.println("After :  x := "+x+", y := "+y);
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
    	User user = new User(3, "Yash", "Dev", true);
    	User user2 = new User(3, "Yash", "Dev", true);
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
    		prev = next;
    		next = sum;
    		sum = prev + sum;
    		System.out.println(sum);
    	}
    }
    
    static void PascalTriangle()
    {
    	int rows = 10;
    	for(int i = 0; i < rows; i++)
    	{
    		int number = 1;
    		System.out.format("%" + (rows-i) * 2 + "s" , "");
    		for(int j = 0; j <= i; j++)
    		{
    			System.out.format("%4d",number);
    			number = number * (i - j) / (j + 1);
    		}
    		System.out.println();
    	}
    }
    
    static void NumberPyramid()
    {
    	for(int i = 1; i <= 5; i++)
		{
			for(int j = 1; j <= i; j++)
			{
				System.out.print(j*i+" ");
			}
			System.out.println();
		}
    }
    
    static void FabonacciRecursive(int prv, int next, int sum, int num)
	{
		if(prv < num)
		{
//			System.out.println(sum);
			prv = next;
			next = sum;
			sum = next + prv;
			FabonacciRecursive(prv, next, sum, num);
		}
	}
    
    static void PatternPyramid3()
    {
    	int num = 5, k = 0;
    	for(int i = 1; i < num; i++)
    	{
    		int jc = 0;
    		k += i-1;
    		for(int j = 1; j <= i+k; j++)
    		{
    			jc++;
    			System.out.print("*");
    		}
    		System.out.print(" "+jc);
    		System.out.println();
    	}
    }
    
    static int customParseInt(String s)
	{
		int num = 0, n = 0;
		for(int i = 0; i < s.length(); i++)
		{
			Character c = s.charAt(i);
			switch (c) {
			case '1':
				n = 1;
				break;
			case '2':
				n = 2;
				break;
			case '3':
				n = 3;
				break;
			case '4':
				n = 4;
				break;
			case '5':
				n = 5;
				break;
			case '6':
				n = 6;
				break;
			case '7':
				n = 7;
				break;
			case '8':
				n = 8;
				break;
			case '9':
				n = 9;
				break;
			default:
				n = 0;
				break;
			}
			int k = 1;
			for(int j = 1; j < s.length()-i; j++)
			{
				k *= 10;
			}
			num += n*k;
		}
		return num;
	}
	
	static void OutputTest()
	{
		System.out.println("Hello "+10+20);
		System.out.println(10+20+" Hello");
		System.out.println("========");
//		System.out.println("Hello "+10-20);
		System.out.println(10-20+" Hello");
		System.out.println("========");
		System.out.println("Hello "+10*20);
		System.out.println(10*20+" Hello");
	}
	
	static void Pyramids()
	{
		int num = 5;
		for(int i = 0; i < num; i++)
		{
			for(int k = num-1; k > i; k--)
			{
				System.out.print(" ");
			}
			for(int j = 0; j <= i; j++)
			{
				System.out.print("*");
			}
			for(int k = 0; k < i; k++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	static void CountChars()
	{
		String s = "aaahhcccddaah";
		char[] c = s.toCharArray();
		int[] freq = new int[c.length];
		for(int i = 0; i < s.length(); i++)
		{
			freq[i] = 1;
			for(int j = i+1; j < s.length(); j++)
			{
				if(c[i]==c[j])
				{
					freq[i]++;
					c[j] = '0';
				}
			}
		}
//		for(int i = 0; i <s.length(); i++) {  
//            freq[i] = 1;  
//            for(int j = i+1; j <s.length(); j++) {  
//                if(c[i] == c[j]) {  
//                    freq[i]++;  
//                      
//                    //Set string[j] to 0 to avoid printing visited character  
//                    c[j] = '0';  
//                }  
//            }  
//        }
		for(int k = 0; k < freq.length; k++)
		{
			if(c[k] != ' ' && c[k] != '0')
			System.out.print(c[k]+""+freq[k]);
		}
	}
	
	static void permutation(String perm, String word) 
	{
        if (word.isEmpty()) {
            System.err.println(perm + word);

        } else {
            for (int i = 0; i < word.length(); i++) {
                permutation(perm + word.charAt(i), word.substring(0, i) 
                                        + word.substring(i + 1, word.length()));
            }
        }
    }
	
	static String reverseString(String str) 
	{
		if(str.isEmpty()) {
			return str;
		}
		return reverseString(str.substring(1))+str.charAt(0);
	}
	
	static void Factorial(int num) 
	{
		int fact = 1;
		for(int i = 1; i <= num; i++) 
		{
			fact = fact*i;
		}
		System.out.println(fact);
	}
	
	static int factorial(int n)
	{    
		  if (n == 0)    
		    return 1;    
		  else    
		    return(n * factorial(n-1));    
	}
	
	static void DuplicatesChars()
    {
		String[] input = {"book","cook","hook"};
//		String[] output= {"o","k"};
		Set<Character> set = new HashSet<>();
		char[] t = input[0].toCharArray();
		for(char c  : t)
		{
			for(int i = 1; i < input.length; i++)
			{
				String s = input[i];
				if(s.contains(c+""))
				{
					set.add(c);
				}
			}
		}
		System.err.println(set);
    }
	
	static void DuplicatesChars2()
    {
		String[] input = { "book", "hook", "cook" };
		Set<String> output = new HashSet<>();
		char[] input1 = input[0].toCharArray();
		
		for(char c : input1) {
			if(Arrays.asList(input).stream().allMatch(e1 -> e1.contains(Character.toString(c)))) {
				output.add(Character.toString(c));
			}
		}
		System.err.println(output);
    }
	
	static void segregate0and1() {
		int arr[] = {0,1,1,0,1,1,0,0};
        int type0 = 0;
        int type1 = arr.length - 1;
         
        while (type0 < type1) {
            if (arr[type0] == 1) {
                // swap
                arr[type1] = arr[type1]+ arr[type0];
                arr[type0] = arr[type1]-arr[type0];
                arr[type1] = arr[type1]-arr[type0];
                type1--;
            } else {
                type0++;
            }
        }
        System.err.println(Arrays.toString(arr));
    }
	
	static void secondHighestFromArray() {
		 
	    int arr[] = { 14, 46, 47, 86, 92, 52, 48, 36, 66, 85 };
	    int largest = arr[0];
	    int secondLargest = arr[0];
	    
//	    System.out.println("The given array is: "+Arrays.toString(arr));
//	    for (int i = 0; i < arr.length; i++) {
//	      System.out.print(arr[i]+"\t");
//	    }
	    for (int i = 0; i < arr.length; i++) {
	 
	      if (arr[i] > largest) {
	        secondLargest = largest;
	        largest = arr[i];
	 
	      } else if (arr[i] > secondLargest) {
	        secondLargest = arr[i];
	 
	      }
	   }
	 
	    System.out.println("Second largest number is:" + secondLargest);
	 
	}
	
	static void findAllElementsGreaterThanRight()
	{
		int max_so_far = 0;
		int arr[] = {10,4,2,6,3,5}; 

        for (int i = arr.length - 1; i >= 0; i--)
        {
            // if the current element is greater than the maximum so far,
            // print it and update `max_so_far`
            if (arr[i] >= max_so_far)
            {
                max_so_far = arr[i];
                System.out.printf("%d ", arr[i]);
            }
        }
	}
    
	static void checkPalindrome() {  
        String string = "Kayak";  
        boolean flag = true;  
          
        //Converts the given string into lowercase  
        string = string.toLowerCase();  
          
        //Iterate the string forward and backward, compare one character at a time   
        //till middle of the string is reached  
        for(int i = 0; i < string.length()/2; i++){  
            if(string.charAt(i) != string.charAt(string.length()-i-1)){  
                flag = false;  
                break;  
            }  
        }  
        if(flag)  
            System.out.println("Given string is palindrome");  
        else  
            System.out.println("Given string is not a palindrome");  
    } 
	
	static void canFormPalindrome()
    {
		String str = "Yash";
        List<Character> list = new ArrayList<Character>();
 
        for (int i = 0; i < str.length(); i++)
        {
            if (list.contains(str.charAt(i)))
                list.remove((Character)str.charAt(i));
            else
                list.add(str.charAt(i));
        }
 
        // if character length is even
        // list is expected to be empty or
        // if character length is odd list size
        // is expected to be 1
       
       
        // if string length is even
        if (str.length() % 2 == 0 && list.isEmpty() || (str.length() % 2 == 1 && list.size() == 1))
//            return true;
        	System.err.println("TRUE");
       
        // if string length is odd
        else
//            return false;
        	System.err.println("FALSE");
    }
	
    public static void main(String[] args) 
    {
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
			PrintInOneLoop();
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
        
        try {
	        String methodName = "findAllElementsGreaterThanRight";
	        int param = 0;
	        Class c = Class.forName("interview.Programs");
			Method m = c.getDeclaredMethod(methodName, null);
			m.invoke(c, null);
//			Method m = c.getDeclaredMethod(methodName, int.class);
//			m.invoke(c, param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
