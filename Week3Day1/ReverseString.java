package Week3Day1;

public class ReverseString {

	public static void main(String[] args) {
    String name="Vennila";
    char[] charArray = name.toCharArray();
    String rev="";
    for(int j=0;j<charArray.length;j++) {
    	System.out.println(charArray[j]);
    }
    
    System.out.println("-------------------");
    for(int i=charArray.length-1;i>=0;i--) {
    	rev=rev+charArray[i];
    }
    System.out.println("Reversed string  "+rev);
	}

}
