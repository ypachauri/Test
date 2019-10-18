package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
	static void Fabonacci(int prv, int next, int sum, int num)
	{
		
		if(prv < num)
		{
			System.out.println(sum);
			prv = next;
			next = sum;
			sum = next + prv;
			Fabonacci(prv, next, sum, num);
		}
	}
	
	static void test()
	{
		Map<String, Map<String, Map<String, Integer>>> map = new HashMap<>();
		Map<String, Map<String, Object>> data = new HashMap<>();
		Map<String, Object> subdata = new HashMap<>();
		subdata.put("Color","Green");
		subdata.put("Stage", "Growth");
		subdata.put("Count", 10);
		data.put("a", subdata);
		subdata = new HashMap<>();
		subdata.put("Color","Red");
		subdata.put("Stage", "Renewal");
		subdata.put("Count", 30);
		data.put("b", subdata);
		subdata = new HashMap<>();
		subdata.put("Color","Yellow");
		subdata.put("Stage", "Churned");
		subdata.put("Count", 105);
		data.put("c", subdata);
		subdata = new HashMap<>();
		subdata.put("Color","Green");
		subdata.put("Stage", "Growth");
		subdata.put("Count", 110);
		data.put("d", subdata);
		subdata = new HashMap<>();
		subdata.put("Color","Green");
		subdata.put("Stage", "Renewal");
		subdata.put("Count", 50);
		data.put("e", subdata);
		subdata = new HashMap<>();
		subdata.put("Color","Red");
		subdata.put("Stage", "Renewal");
		subdata.put("Count", 50);
		data.put("f", subdata);
		//System.err.println(data);
		Map<String, List<String>> m1 = new HashMap<>();
		Map<String, Map<String, Integer[]>> m = new HashMap<>();
		Map<String, Integer> mm = new HashMap<>();
//		map.put("Green", new HashMap<>());
//		map.put("Yellow", new HashMap<>());
//		map.put("Red", new HashMap<>());
		for(Map.Entry<String, Map<String, Object>> entry : data.entrySet())
		{
			String Color = (String)entry.getValue().get("Color");
			String Stage = (String)entry.getValue().get("Stage");
			Integer Count = (Integer)entry.getValue().get("Count");
			int val = 0;
			int avgCount = 0;
			Map<String, Map<String, Integer>> mp = map.containsKey(Color) ? map.get(Color) : new HashMap<>();
			
			if(mp.get(Stage) != null && mp.get(Stage).get("value") != null)
			{
				val = mp.get(Stage).get("value");
				avgCount = mp.get(Stage).get("avgCount");
			}
//			if(m.get(Color) != null && m.get(Color).get(Stage) != null)
//			{
//				val = m.get(Color).get(Stage)[0];
//			}
//			Map<String, Integer[]> mp = m.get(Color)!=null ? m.get(Color) : new HashMap<>()		;
//			mp.put(Stage, new Integer[]{val+Count,0});
//			m.put(Color, mp);
			
			
//			if(map.get(Color)!=null) mp = map.get(Color);
			//avgCount++;
			Map<String, Integer> map2 = mp.get(Stage) == null ? new HashMap<>() : mp.get(Stage);
			map2.put("value", val+Count);
			map2.put("avgCount", avgCount+1);
			mp.put(Stage, map2);
			map.put(Color, mp);
		}
		System.out.println(map);
	}
    public static void main( String[] args )
    {
    	test();
//    	Fabonacci(0,1,0,7);
//        System.out.println( "Hello World!" );
//        short s = 0; 
//        int x = 07; 
//        //int y = 08; 
//        int z = 112345; 
//  
//        s += z; 
//        //System.out.println("" + x + y + s);
//        Integer a = 128, b = 128; 
//        System.out.println(a == b); 
//  
//        Integer c = 100, d = 100; 
//        System.out.println(c == d); 
    }
}
