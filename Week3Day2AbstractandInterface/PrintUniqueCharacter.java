package Week3Day2AbstractandInterface;

import java.util.HashSet;
import java.util.Set;


public class PrintUniqueCharacter {

	public static void main(String[] args) {
		String name="vennila";
		char[] charArray=name.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			System.out.println(charArray[i]);
		}
		System.out.println();
		Set<Character> value=new HashSet<Character>();
        for (int i = 0; i < charArray.length; i++) {
			if(!value.contains(charArray[i]))
				value.add(charArray[i]);
			else
				value.remove(charArray[i]);
			
				 
			}
        System.out.println("The set is "+value);
		
		
		

	}

}
