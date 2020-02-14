package nse;

import java.util.ArrayList;
import java.util.List;

public class Get {
	public static void main(String[] args) {
        Nse nse = new Nse();
        List<String> list = new ArrayList<>();
        list.add("UPL");
        list.add("HAVELLS");
        list.add("M&M");
        list.add("MARICO");
        list.add("NIFTY50");
        for(String s : list) {
        	String lastPrice = nse.getStockDetails(s).get("lastPrice");
        	System.out.println(s+" == "+lastPrice);
        }
        nse.close();
    }
}
