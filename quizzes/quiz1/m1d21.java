public class m1d21 {
	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person();

		p1.firstName = "Alice";
		p1.lastName = "Adams";

		p2.firstName = "Beverly";
		p2.lastName = "Boone";

		System.out.println(p1.firstName + " " +  p1.lastName);
		System.out.println(p2.firstName + " " +  p2.lastName);
	}
}
