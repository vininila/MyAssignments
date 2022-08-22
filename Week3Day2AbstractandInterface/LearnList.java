package Week3Day2AbstractandInterface;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class LearnList {

	public static void main(String[] args) {
		List<String> names=new ArrayList<String>();
		names.add("Adam");
		names.add("Ben");
		names.add("Zara");
		names.add("Adam");
		names.add("Charlie");
		names.add("James");
		names.add("Ben");
		//int count=0;
		
		System.out.println(names);
		Set<String> orgname=new LinkedHashSet<String>();
		Set<String> dupname=new LinkedHashSet<String>();
		for(String string: names) {
				if(!orgname.add(string)) {
					dupname.add(string);
			}
		}
		System.out.println(orgname);
		System.out.println(dupname);
		
		
	}

}
