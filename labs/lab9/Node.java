import java.util.ArrayList;
import java.util.List;
public class Node {
	private ArrayList<Node> children = new ArrayList<>();
	String content;
	public Node(String content) {
		this.content = content;
	}
	public void makeChild(Node child) {
		children.add(child);
	}
	public List<Node> getChildren() {
		return children;
	}
}
