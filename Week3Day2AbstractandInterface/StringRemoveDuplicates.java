package Week3Day2AbstractandInterface;

public class StringRemoveDuplicates {

	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";
		String[] split = text.split(" ");
		for (int i = 0; i < split.length; i++) {
			if(split[i]!=null)
			{
				for(int j=i+1;j<split.length;j++)          //Inner loop to compare two words in a sentence to check for duplicacy
			      {
			        
			      if(split[i].equals(split[j]))          //Checking if both the compared strings are equal
			        {
			    	  split[j]=null;      //Deletes the duplicate words if the compared strings are equal
			        }
			      }
			      }
			    }
			    for(int k=0;k<split.length;k++)    //Displaying the String without the duplicate words  
			    {
			      if(split[k]!=null)
			      {
			        System.out.print(split[k] + " ");
			      }
			}
			}
		
			
			
		
		
		
		}


