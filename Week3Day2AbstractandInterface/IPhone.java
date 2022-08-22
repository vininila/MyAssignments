package Week3Day2AbstractandInterface;

public class IPhone implements Mobile  {

		static int j=11;//has single memory space and value can be changed and doesnt need obj reference created to use it in main method
		public void sendSMS() {
		System.out.println("sendSMS");
		
	}

	public void dialNumber() {
		System.out.println("dialNumber");
	}

	public void switchOn() {
		System.out.println("switchOn");
		
	}
	public static void main(String[] args) {
		IPhone phone=new IPhone();
		phone.sendSMS();
		phone.dialNumber();
		phone.switchOn();
		System.out.println(i);
		j=j+1;
		System.out.println(j);

	}

}
