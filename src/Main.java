public class Main {

    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(true);

        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);

        System.out.println("Dijkstra:");
        Search<String> dijkstraSearch = new DijkstraSearch<>(graph, "Almaty");
        outputPath(dijkstraSearch, "Kyzylorda");

        System.out.println("\nDFS:");
        Search<String> dfs = new DepthFirstSearch<>(graph, "Almaty");
        outputPath(dfs, "Kyzylorda");

        System.out.println("\nBFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, "Almaty");
        outputPath(bfs, "Kyzylorda");
    }

    public static void outputPath(Search<String> search, String key) {
        Iterable<String> path = search.pathTo(key);
        if (path != null) {
            for (String v : path) {
                System.out.print(v + " -> ");
            }
        } else {
            System.out.println("No path found.");
        }
        System.out.println();
    }
}
