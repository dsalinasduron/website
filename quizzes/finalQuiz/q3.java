public class q3 {
	int x = 5;
	static int y = 6;
	public static void main(String[] args) {
		q3 instance = new q3();
		int x = 7;
		int y = 8;
		instance.run(x);
		System.out.println(x);
		System.out.println(y);
	}
	public void run(int x) {
		x = 9;
	}
}
