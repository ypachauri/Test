package interview;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortByKey {
	public static void main(String[] args) {
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
}
