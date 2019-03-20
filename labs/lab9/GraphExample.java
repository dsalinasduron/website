import java.util.List;
/* This example class uses a class called Node to represent each vertex and a
 * a list with two nodes in it to represent each edge.*/
public class GraphExample implements UndirectedGraph<Node,List<Node>>{
	public boolean isComplete() {return false;}
	public boolean hasCycle() {return false;}
	public List<Node> getVertices() {return null;}
	public List<List<Node>> getEdges() {return null;}

}
