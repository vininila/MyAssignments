package Week3Day2AbstractandInterface;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String name="PayPal India";
		char[] charArray=name.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			System.out.println(charArray[i]);
		}
		Set<Character> charSet= new LinkedHashSet<Character>();
		Set<Character> dupCharSet= new LinkedHashSet<Character>();
		for (int i = 0; i < charArray.length; i++) {
			if(!charSet.contains(charArray[i]))
				charSet.add(charArray[i]);
			else
				dupCharSet.add(charArray[i]);
				 
		}
		
	System.out.println("charSet is  "+charSet);
	System.out.println("---------------");
	System.out.println("dupCharSet is "+dupCharSet);
		
	for(Character value:dupCharSet)
	charSet.remove(value);

		System.out.println(charSet);
	if(charSet.contains(' '))
		charSet.remove(' ');
		System.out.println("Final Charset is "+ charSet);
}}
