public class q4 {
	private static class Node {
		Object content;
		public Node(Object input) {
			this.content = input;
		}
		public Object getContent() {
			return this.content;
		}
	}
	public static void main(String[] args) {
		Node a = new Node("Ada");
		Node b = new Node(5);
	}
}
