package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args)
	{
		/*Integer[] arr={1,1,2,3,4,5,5,6,7,8};
		Set<Integer> set = new HashSet<>(Arrays.asList(arr));
		List<Integer> lst = new ArrayList<>(Arrays.asList(arr));
		Integer[] arr2 = lst.toArray(new Integer[lst.size()]);
		Integer[] arr3 = set.toArray(new Integer[set.size()]);
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		int[] arr4 = list.stream().mapToInt(i -> i).toArray();
		System.out.println(Arrays.toString(arr));
		System.out.println(set);
		System.out.println(lst);
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		System.out.println(list);
		System.out.println(Arrays.toString(arr4));*/
		List<Integer> list = new ArrayList<>();
		Integer[] arr = list.toArray(new Integer[list.size()]);
		Integer a = 500;
		Integer b = 500;
		System.out.println(a==b);
	}
}
