import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReadFile {
	public static void main(String[] args) {
		File f = new File("D://sample.txt");
		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line=null;
			while((line = br.readLine()) != null)
			{
				String[] name = line.split(" ");
				for(int i=0; i<name.length;i++)
				{
					set.add(name[i]);
					//System.out.println(name[i]);
					if(!list.contains(name[i])) list.add(name[i]);
				}
			}
			System.out.println(set);
			System.out.println(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
