package Week3Day1Polymorphisim;

public class BankInfo extends AxisBank {
public void saving() {
	System.out.println("Saving");
}
public void fixed() {
	System.out.println("Fixed");
}
public void deposit() {
	super.deposit();
	System.out.println("Bank Deposit");
}
public static void main(String[] args) {
	
	BankInfo bank=new BankInfo();
	bank.deposit();
	}
}
