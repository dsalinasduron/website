import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.List;

public class TreeGraph extends JPanel {
	int nodeSize = 30;
	int LeafX = 0;
	int frameX = 500;
	int frameY = 500;
	Node root;
	public TreeGraph(Node root) {
		this.root = root;
	}
	public void draw() {
		JFrame f = new JFrame();
		f.setSize(frameX,frameY);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(this);
		f.setVisible(true);
	}
	public void paint(Graphics g) {
		drawNode(g,root,0);
		frameX = LeafX;
	}
	public int drawNode(Graphics g, Node n, int parentY) {
		int myNodeY = parentY + nodeSize * 2;
		int myNodeX = LeafX;
		List<Node> nChildren = n.getChildren();
		if (nChildren.size() > 0) {
			double myX = 0;
			int[] childrenX = new int[nChildren.size()];
			for (int i = 0; i < nChildren.size(); i++) {
				childrenX[i] = drawNode(g,nChildren.get(i),myNodeY);
				myX += childrenX[i];
			}
			myNodeX = (int) (myX / nChildren.size());
			int childY = myNodeY + nodeSize * 2;
			int sourceX = myNodeX + nodeSize / 2;
			int sourceY = myNodeY + nodeSize;
			for( int childX : childrenX) {
				g.drawLine(sourceX,sourceY,childX + nodeSize/2,childY);
			}
		}
		else {
			LeafX += nodeSize * 2;
		}

		//actually draw the node
		g.drawOval(myNodeX, myNodeY, nodeSize, nodeSize);
		g.drawString(n.content, myNodeX + 10, myNodeY + nodeSize/2 + 4);
		return myNodeX;
	}
}
