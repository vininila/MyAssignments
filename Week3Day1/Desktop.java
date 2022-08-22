package Week3Day1;

public class Desktop extends Computer {

	public void desktopSize() {
		System.out.println("Desktop Size");
	}

	public static void main(String[] args) {
		Desktop des=new Desktop();
		des.computerModel();
		des.desktopSize();
	}

}
