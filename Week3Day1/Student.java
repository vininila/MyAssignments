package Week3Day1;

public class Student extends Department {
public void studentName() {
	System.out.println("Student Name");
}
public void studentDept() {
	System.out.println("Student department");
}
public void studentId() {
	System.out.println("Student Id");
}

	public static void main(String[] args) {
		Student stu=new Student();
		stu.collegeName();
		stu.collegeCode();
		stu.collegeRank();
		stu.deptName();
		stu.studentName();
		stu.studentId();
		stu.studentDept();

	}

}
