import java.util.*;
public class q2 {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(5);
		q.add(4);
		q.add(3);
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());

	}
}
