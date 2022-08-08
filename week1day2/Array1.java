package week1day2;

import java.util.Arrays;

public class Array1 {

	public static void main(String[] args) {
		int[] n= {2,5,3,3,4,7,8};
		Arrays.sort(n);
		
		for(int i=0;i<n.length;i++) {
			System.out.println(n[i]);
			
		}
		System.out.println("---------------------");
System.out.println(n[n.length-2]);
	}

}
