package Week3Day2AbstractandInterface;

import java.util.Set;
import java.util.TreeSet;

public class MissingNumber {

	public static void main(String[] args) {
		int[] data = {6,7,2,3,5,6,1,8,10,9,5,1};
		Set<Integer> value=new TreeSet<Integer>();
		for (int i = 0; i < data.length; i++) {
			value.add(data[i]);
			
		}
		System.out.println(value);
		System.out.println("Size is "+value.size());
		
		for (int i = 1; i <=value.size(); i++) {
		if(!value.contains(i)) {
			System.out.println("Missing element is  "+i);
		}}
	//System.out.println("Missing element in array is "+ (sum-sum1));
	
		

		}


}
