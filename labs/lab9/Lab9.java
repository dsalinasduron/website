public class Lab9 {
	public static void main(String[] args) {
		Node nM = new Node("M");
		Node nF = new Node("F");
		Node nD = new Node("D");
		Node nH = new Node("H");
		Node nQ = new Node("Q");
		Node nG = new Node("G");
		Node nL = new Node("L");
		Node nR = new Node("R");
		Node nT = new Node("T");

		nM.makeChild(nF);
		nM.makeChild(nR);
		nF.makeChild(nD);
		nF.makeChild(nH);
		nD.makeChild(nQ);
		nH.makeChild(nG);
		nH.makeChild(nL);
		nR.makeChild(nT);

		TreeGraph tg = new TreeGraph(nM);
		tg.draw();

		System.out.println("Pre-order output:");
		preOrder(nM);
		System.out.println("Post-order output:");
		postOrder(nM);
		System.out.println("In-order output:");
		inOrder(nM);
	}
	public static void preOrder(Node node) {
		System.out.println("Please complete the pre-order traversal method.");
	}
	public static void postOrder(Node node) {
		System.out.println("Please complete the post-order traversal method.");
	}
	public static void inOrder(Node node) {
		System.out.println("Please complete the in-order traversal method.");
	}
}
