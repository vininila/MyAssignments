package week1day2;

public class Calculator {

	public int add(int a, int b) {
		return a+b;
	}
	public double sub(double a, double b) {
		return (a-b);
	}
	public double mul(double a, int b) {
		return (a*b);
	}
	public int div(int a, int b) {
		return (a/b);
	}
	public static void main(String[] args) {
		Calculator cal=new Calculator();
		int add1=cal.add(10,20);
		double sub1=cal.sub(30.1,20.0);
		double mul1=cal.mul(8.1,20);
		int div1=cal.div(100,20);
		System.out.println(add1);
		System.out.println(sub1);
		System.out.println(mul1);
		System.out.println(div1);
		

	}

}
