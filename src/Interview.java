import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
        		System.out.println(Arrays.toString(arr));
            }
        }
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
    
    static void DuplicatesListWithCount()
    {
    	List<String> list = Arrays.asList("abc", "xyz", "abc", "type", "rtrtr", "ppp", "xyz", "rtr", "pop", "xyz", "abc", "xyz", "abc", "xyz");
    	Map<String, Integer> mp = new HashMap<>();
    	List<String> l = new ArrayList<>();
		int count=0;
		for(int i=0; i < list.size(); i++)
		{
			if(!l.contains(list.get(i)))
        	{
        		count=1;
	        	String temp=list.get(i);
	            for(int j=i+1; j<list.size(); j++)
	            {
	                if(temp.equals(list.get(j)))
	                {
	                	l.add(temp);
	                    count++;
	                    mp.put(list.get(i),count);
	                    System.out.println(temp+" === "+count);
	                }
	            }
        	}
		}
		System.out.println(mp);
    }
    
    static void Test()
    {
    	List<String> list = Arrays.asList("abc", "xyz", "abc", "type", "rtrtr", "ppp", "xyz", "rtr", "pop", "xyz", "abc", "xyz", "abc", "xyz");
    	Map<String, Integer> mp = new HashMap<>();
    	  int count;
    	  for(int a=0; a < list.size(); a++)
    	  {
    	  count=1;
    	  	for(int b=0; b<a;b++)
    	    {
    	    	if(list.get(a).equals(list.get(b)))
    	      { 
    	      
    	        if(mp.containsValue(mp.get(list.get(a))))
    	        	count++;
    	      	mp.put(list.get(a),count);
    	      	System.out.println(list.get(a)+"==="+count);
    	      }
    	    }
    	  }
    	System.out.println(mp);
    }
    
    public static void main(String[] args) 
    {
        int val=10;
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
			DuplicatesListWithCount();
			break;
		case 10:
			Test();
			break;
		default:
			break;
		}
    }
}
