package Week3Day1;

public class FindCharCount {

	public static void main(String[] args) {
		String input="TestLeaf";
		int count=0;
		char[] charArray=input.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			 if(input.charAt(i) =='e')    
	                count++;  
		}

	System.out.println("Total number of e characters in a string: " + count);
	}}
