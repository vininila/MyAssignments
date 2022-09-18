package ExplicitWait;

public class LearnKeywords {

	String collegeName="Test";
	//Create a static final variable as building fee
     static final int buidingFee=100;
     //Create a constructor (default)
     public LearnKeywords(){
    	
    	System.out.println("Anna University"); 
     }
     //Create a parametrized constructor (collegeName, depart)
     public LearnKeywords(String collegeName, String dept){
    //Do call the default constructor to print the university
    	this();//to call default constructor
    	this.collegeName=collegeName;//to assign local variable value to global variable 
     	System.out.println(collegeName); 
     	System.out.println(dept);
      }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LearnKeywords obj=new LearnKeywords();
		//Main method -->pass the value to the parametrized constructor
		LearnKeywords obj1=new LearnKeywords("ESEC","CSE");
        System.out.println("Static final variable called "+buidingFee);//calling static variable
        System.out.println(obj1.collegeName);//calling global variable
	}

}
