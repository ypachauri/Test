package interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Interview {
	
	static void ReverseArrayInPlace(int nth)
    {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        int j=nth;
        for(int i=0; i<nth/2;i++)
        {
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            j--;
        }
        System.out.println(Arrays.toString(arr));
    }
    
    static void MissingFromArray()
    {
        int[] arr={1,2,3,5,6,7,9,10,11};
        int c=1;
        for(int i=1; i<arr.length;i++)
        {
            if(arr[c-1]!=i){
                System.out.println(i);
                c--;
            }
            c++;
        }
    }
    
    static void DuplicatesFromArray(int n)
    {
        int[] arr={0, 3, 1, 2, 3, 5, 2, 3, 0, 2, 0, 5, 3};
        List<Integer> list = new ArrayList<>();
        int count=0;
        for(int j=0;j<arr.length;j++) {
        	if(!list.contains(arr[j]))
        	{
	        	count=1;
	            for(int k =j+1;k<arr.length;k++) {
	                if(arr[j]==arr[k]) {
	                	list.add(arr[j]);
	                    count++;
	                    //System.out.println(arr[j]+" == "+count);
	                }
	            }
        	}
            if(count>1)
               System.out.println(arr[j]);
            count = 0;
        }
    }
    
    static void LargestSmallestFromArray()
    {
        int[] arr={0, 3, 1, 2, 5, 9, 10, 4};
        int l=arr[0];
        int s=arr[0];
        for(int i=0; i<arr.length;i++)
        {
            if(arr[i]>l)
                l=arr[i];
            if(arr[i]<s)
                s=arr[i];
        }
        System.out.println("Largest===> "+l+" Smallest===> "+s);
    }
    
    static void DuplicatesInArrayOnth()
    {
        int[] arr={1, 2, 3, 1, 3, 6, 6};
        for(int i=0; i<arr.length;i++)
        {
            if(arr[Math.abs(arr[i])]>=0)
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            else
                System.out.println(Math.abs(arr[i]));
        }
    }
    
    static void RemoveDuplicatesFromArray()
    {
        int[] arr={1, 2, 2, 3, 4, 4, 4, 5, 5, 6, 3, 5};
        int[] arr2=new int[arr.length];
        arr2[0]=arr[0];
        int c=1;
        boolean chk=false;
        for(int i=0; i<arr.length;i++)
        {
            for(int j=0; j<i; j++)
            {
                
                if(arr[i]==arr[j])
                {
                    chk=false;
                    break;
                }
                else
                {
                    chk=true;
                }
            }
            if(chk){arr2[c]=arr[i];c++;}
        }
        System.out.println(Arrays.toString(arr2));
    }
    
    static void BubbleSort()
    {
        int[] arr={99, 88, 55, 77, 1, 66};
        int n = arr.length;
        for (int i = 0; i < n-1; i++) 
        {
            for (int j = 0; j < n-i-1; j++) 
            {
                if (arr[j] > arr[j+1]) 
                { 
                    // swap arr[j+1] and arr[j] 
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
    
    static void MapSortByKey()
    {
    	Map<String, Integer> mp = new HashMap<String, Integer>();
		mp.put("Yash", 1);
		mp.put("Akash", 2);
		mp.put("Sonu", 3);
		mp.put("Kushal", 4);
		mp.put("Deepak", 5);
		
		Map<String, Integer> tmp = new TreeMap<String, Integer>(Collections.reverseOrder());
		tmp.putAll(mp);
		System.out.println(tmp);
    }
    
    static void MapSortByValues()
    {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("java", 20);
        map.put("C++", 45);
        map.put("Java2Novice", 2);
        map.put("Unix", 67);
        map.put("MAC", 26);
        map.put("Why this kolavari", 93);
        
        Set<Entry<String, Integer>> set = map.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );
        for(Map.Entry<String, Integer> entry:list){
            System.out.println(entry.getKey()+" ==== "+entry.getValue());
        }
    }
    
    static void ReadFileAndCount()
    {
    	File f = new File("D://sample.txt");
		Set<String> set = new HashSet<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line=null;
			while((line = br.readLine()) != null)
			{
				String[] name = line.split(" ");
				for(int i=0; i<name.length;i++)
				{
					set.add(name[i]);
				}
			}
			br.close();
			System.out.println(set);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    static void ElementsCount()
    {
    	List<String> list = Arrays.asList("abc", "xyz", "abc", "type", "rtrtr", "ppp", "xyz", "rtr", "pop", "xyz", "abc", "xyz", "abc", "xyz");
    	Map<String, Integer> map = new HashMap<>();
    	for (int i=0; i<list.size(); i++) {
			if (map.containsKey(list.get(i))) {
				int count = map.get(list.get(i));
				map.put(list.get(i), count+1);
			}
			else {
				map.put(list.get(i), 1);
			}
		}
		System.out.println(map);
    }
    
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
    
    static void DateSort()
    {
    	List<String> dates = new ArrayList<>();
    	dates.add("03/05/2019");
    	dates.add("05/05/2019");
    	dates.add("01/05/2019");
    	dates.add("02/05/2019");
    	dates.add("04/05/2019");
    	Collections.sort(dates, new Comparator<String>() {
    		public int compare(String o1, String o2) { return o1.compareTo(o2); };
		});
    	System.out.println(dates);
    }
    
    static void FindString()
    {
    	String s1 = "abcNjhgAhGjhfhAljhRkhgRbhjbevfhO";
    	String s2 = "NAGARRO";
    	String s3 = "";
    	int s2count=0,index=0;
    	for(int i=0; i < s1.length(); i++)
    	{
    		if(s2count<s2.length() && s1.charAt(i)==s2.charAt(s2count))
    		{
    			if(s3.length()==0) index=i;
    			s3 += s1.charAt(i);
    			s2count++;
    		}
    	}
    	if(s2.length()==s3.length())
    		System.out.println(s2count+", "+s3+", Found at index "+index);
    }
    
    public static void main(String[] args) 
    {
        int val=14;
        switch (val) {
		case 1:
			ReverseArrayInPlace(6);
			break;
		case 2:
			MissingFromArray();
			break;
		case 3:
			DuplicatesFromArray(2);
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
			MapSortByKey();
			break;
		case 10:
			ReadFileAndCount();
			break;
		case 11:
			ElementsCount();
			break;
		case 12:
			AllSubstrings();
			break;
		case 13:
			DateSort();
			break;
		case 14:
			FindString();
			break;
		default:
			AllSubstrings();
			break;
		}
    }
}
