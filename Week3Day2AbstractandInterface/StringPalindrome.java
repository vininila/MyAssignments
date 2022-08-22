package Week3Day2AbstractandInterface;

public class StringPalindrome {

	public static void main(String[] args) {
		String value="madam";
		String rev = "";
		char[] charArray= value.toCharArray();
		for (int i = charArray.length-1;i>=0; i--) {
				
			rev=rev+charArray[i];
			//System.out.println(rev);
		}
     if(value.equals(rev))
    	System.out.println("Its a Palindrome"); 
     else 
    	 System.out.println("Not a	 Palindrome");
	}

}
