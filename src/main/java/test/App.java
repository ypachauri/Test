package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 *string str= "YaSh"
string str2 = "yasH PaChAUri"

string str3 = "YS"

1. whenever we start working with first string it always start from left to right.
2. Wheevenr we start working with second string it always start from right to left.
3. whenever you working with any string any found any charcter in capital case then tick that and store it in 3rd variable after that continue with the same string with next charcter.
4. whever you found any charcter which is in small case in that condition switch the string and starting counting the charcter from where we left.
 */
public class App 
{
	String str = "YaSh";
	String str2 = "yasH PaChAUri";
	static String str3="";
	int strindex1=0;
	int str2index=str2.length()-1;
	
	void string1(int strindex)
	{
		
		for(int i = strindex; i < str.length(); i++) {
			if(Character.isUpperCase(str.charAt(i))) {
				str3+=str.charAt(i);
			} else {
				strindex1=i;
				string2(str2index);
				
			}
		}
		if(strindex == str.length()) {
			string2(str2index);
		}
	}
	
	void string2(int strindex2)
	{
		
		for(int i = strindex2; i >= 0; i--) {
			if(Character.isUpperCase(str2.charAt(i))) {
				str3+=str2.charAt(i);
			} else {
				str2index=i;
				string1(strindex1);
				
			}
		}
		if(strindex2 == str2.length()) {
			string1(strindex1);
		}
	}
	
	static void Test()
    {
		String str1 = "ABCD";
		String str2 = "DCAB";
		String str3 = "";
		char [] ch = str2.toCharArray();
		Character c = null;
		boolean b = true;
		for(int i=0; i < ch.length; i++) {
			
			if(c != null && Character.valueOf(c).compareTo(ch[i]) > 0 && ch[i] != str1.toCharArray()[0]){
//				System.err.println(c+" = "+ch[i]);
				b = false;
				break;
				
			}
			c = ch[i];
		}
		System.err.println(b);
    }
	
	static void Test2()
	{
		int[] arr = {4,2,5,4,3,5,1,4,2,7};
		int x = 3;
		int y = 2;
		int count = 0;
		int sum = 0;
		int res = 0;
		for(int i = 0; i<arr.length;i++)
		{
			sum = 0;
			count = 0;
			for(int j = i; j<arr.length;j++)
			{
				if(j%y==0){
//					System.err.println(arr[j]+" ===== "+i);
					sum += arr[j];
					count++;
					if(x==count) break;
				}
			}
			if(count<x) sum = 0;
			if(count == x)
			{
				if(i == 0) res = sum;
				if(sum<res) res = sum;
			}
		}
		System.err.println(res);
	}
	
	static void Test3()
	{
		int[] A = {3,5,1,3,9,8}; 
		int K = 4;
		int minDiff = -1;
	    for (int i = 0; i + K <= A.length; i++) {
	        int val = i + K;
	        int maxNo = -1;
	        int minNo = -1;
	        for (int j = 0; j < A.length; j++) {
	            if (j >= val || i > j) {
	                if (maxNo < A[j]) {
	                    maxNo = A[j];
	                }
	                if (minNo == -1 || minNo > A[j]) {
	                    minNo = A[j];
	                }
	            }
	        }
	        if (minDiff == -1 || minDiff > maxNo - minNo) {
	            minDiff = maxNo - minNo;
	        }
	    }
	    System.err.println(minDiff);
	}
	
	static void Test4()
	{
		Integer nineA = new Integer(9);
		Integer nineB = new Integer(9);
		
		System.err.println(nineA == nineB);
		System.err.println(nineA.equals(nineB));
	}
	
	static void Test5()
	{
		List<Integer> list = Arrays.asList(10,4,2,6,3,5);
		List<Integer> result = new ArrayList<>();
		int b = list.get(list.size()-1); 
		for(int i = list.size()-1; i >= 0; i--) {
			int a = list.get(i);
			if(a > b) {
				result.add(b);
				b = a;
			}
		}
		System.err.println(result);
	}
  
    /* program to test above function */
    public static void main(String args[]) 
    { 
    	Test5();
    }
}
