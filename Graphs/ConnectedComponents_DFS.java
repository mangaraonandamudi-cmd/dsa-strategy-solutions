/*You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.

Return the number of connected components in the graph.



Example 1:


Input: n = 5, edges = [[0,1],[1,2],[3,4]]
Output: 2
Example 2:


Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
Output: 1


Constraints:

1 <= n <= 2000
1 <= edges.length <= 5000
edges[i].length == 2
0 <= ai <= bi < n
ai != bi
There are no repeated edges.
*/

class Solution {
    public int countComponents(int n, int[][] edges) {

        //Step 1 Creating the graph
        List<Integer>[] graph = new LinkedList[n];

        Set<Integer> visited = new HashSet<>();
        int components = 0;

        // Step 2 Initializing the graph with default List
        for(int vertex=0; vertex<n; vertex++) {
            graph[vertex] = new LinkedList<>();
        }

        // Building the graph
        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        // DFS for each vertex. , you may try even BFS as well
        for(int vertex=0; vertex<n; vertex++) {
            if(!visited.contains(vertex)) {
                dfs(vertex, graph, visited);
                components++;
            }
        }
        return components;
    }

    private void dfs(int v, List<Integer>[] graph, Set<Integer> visited) {
        // First add the new vertex into visited set
        visited.add(v);

        // fetch all the adjecent verteces of vertex v and if is not visited do the dfs on the new vertex
        for(int adjVertex : graph[v]) {
            if(!visited.contains(adjVertex)) {
                dfs(adjVertex, graph, visited);
            }
        }

    }
}
