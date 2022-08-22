package Week3Day1;

public class Departments extends Students{
	public void getStudentInfo(int id, String name) {
		super.getStudentInfo(id,name);
		System.out.println("Id is "+ id +"Name "+ name);
	}

}
