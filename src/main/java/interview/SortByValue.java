package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortByValue {
	public static void main(String[] args) {
		Map<String, Integer> mp = new HashMap<String, Integer>();
		mp.put("Sonu", 3);
		mp.put("Kushal", 4);
		mp.put("Deepak", 5);
		mp.put("Yash", 1);
		mp.put("Akash", 2);
		
		Set<Entry<String, Integer>> set = mp.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<>(set);
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2)
			{
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		for(Entry<String, Integer> ls : list)
		{
			System.out.println(ls.getKey()+" === "+ls.getValue());
		}
	}
}
