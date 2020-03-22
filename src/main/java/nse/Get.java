package nse;

import java.util.ArrayList;
import java.util.List;

public class Get {
	public static void main(String[] args) {
        Nse nse = new Nse();
        List<String> list = new ArrayList<>();
        list.add("HAVELLS");
        list.add("MARICO");
        list.add("ITC");
        for(String s : list) {
        	String lastPrice = nse.getStockDetails(s).get("lastPrice");
        	System.out.println(s+" == "+lastPrice);
        }
        nse.close();
    }
}
