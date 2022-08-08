package week1day2;

import java.util.Arrays;

public class MissingElementInAnArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,7,6,8};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int l=arr.length+1;
		int sum=l*(l+1)/2;
		int sum1=0;
		for(int i=0;i<arr.length;i++) {
					sum1=sum1+arr[i];
					
			}
		System.out.println("Missing element in array is "+ (sum-sum1));
			
  
	}

}
