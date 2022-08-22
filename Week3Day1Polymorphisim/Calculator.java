package Week3Day1Polymorphisim;

public class Calculator {
	
	public void add(int a, int b, int c) {
		int d =a+b+c;
		System.out.println("method with 3 int args: " +d);
	}
	public void add(int a, int b) {
		int e =a+b;
		System.out.println("method with 2 int agrs: " +e);
	}
	public void add(double a, double b) {
		double f =a+b;
		System.out.println("methods with 2 double args: " +f);
	}
	public void add(double a, int b) {
		double g=a+b;
		System.out.println("methods with 1 double arg and 1 int arg: " +g);
	}

	public static void main(String[] args) {
	
		Calculator cal= new Calculator();
		cal.add(2, 3, 4);
		cal.add(20, 40);
		cal.add(100.12d, 300.14d);
		cal.add(20.3d,40);

	}

}
