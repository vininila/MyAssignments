package Week3Day1;

public class Collegee extends Departments {

	public static void main(String[] args) {
		Collegee col=new Collegee();
		col.getStudentInfo(12);
		col.getStudentInfo(12,"Nila");
		col.getStudentInfo("abc@gmail.com", 987654321);
	}


}
