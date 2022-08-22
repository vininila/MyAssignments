package Week3Day2AbstractandInterface;

import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;

public class FindSecondLargest {

	public static void main(String[] args) {
		// Here is the input
		int[] data = {3,2,11,4,6,7,2,3,3,6,7};
		//      output= 7;
		//a) Create a empty Set Using TreeSet
		Set<Integer> value=new TreeSet<Integer>();
		//b) Declare for loop iterator from 0 to data.length and add into Set 
		for (int i = 0; i < data.length; i++) {
			value.add(data[i]);
			
		}
		System.out.println(value);
      //c) converted Set into List
		List<Integer> list = new ArrayList<Integer>(value);
		 //d) Print the second last element from List
		int i = list.size();
		
       System.out.println("Size of the list is  "+i);
       System.out.println("Second largest element in list is  "+ list.get(i-2));
       
	
		
		
		

			
				

	}

}
