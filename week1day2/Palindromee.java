package week1day2;

public class Palindromee {

	public static void main(String[] args) {
		int num =34343, rev=0;
		int temp=num;
		for(;num>0;num=num/10) {
		rev=rev*10;
		rev=rev+num%10;
		}
		if(rev==temp) {
			System.out.println("Palindrome");
		}else
		{
			System.out.println("Not a Palindrome");
		}
		 
				

	}

}
