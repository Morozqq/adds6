import java.util.*;

public class DepthFirstSearch<Vertex> extends Search<Vertex> {

    public DepthFirstSearch(WeightedGraph<Vertex> graph, Vertex source) {
        super(source);
        dfs(graph, source);
    }

    private void dfs(WeightedGraph<Vertex> graph, Vertex current) {
        marked.add(current);

        for (Vertex vertex : graph.adjacencyList(current)) {
            if (!marked.contains(vertex)) {
                edgeTo.put(vertex, current);
                dfs(graph, vertex);
            }
        }
    }
}
