package week1day2;

public class NegativeToPositive {

	public static void main(String[] args) {
		int number = -40;
		if(number<0) {
			System.out.println("Negative number");
		}else
			System.out.println("Positive Number");
	//Math.abs(number) can also be used
		System.out.println("The number "+number+ " is converted to "+(number*-1));
		

	}

}
