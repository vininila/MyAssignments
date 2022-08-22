package Week3Day1;

public class ReverseEvenWords {

	public static void main(String[] args) {
		String word = "I am a software tester";
		String[] split =word.split(" ");
		for (int i = 0; i < split.length; i++) {
			if(i%2==1)
			{
				char[] charArray=split[i].toCharArray();
				for (int j = charArray.length-1;j>=0;j--) {
					System.out.println(charArray[j]);
					
				}
				System.out.println(" ");
			}else 
			
				System.out.println(split[i]);
		}

	}

}
