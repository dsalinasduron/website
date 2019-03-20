import java.util.List;
public interface UndirectedGraph<Vertex,Edge> {
	public boolean isComplete();
	public boolean hasCycle();
	public List<Vertex> getVertices();
	public List<Edge> getEdges();
}
