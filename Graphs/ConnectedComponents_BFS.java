/*
   # Leetcode 323. Number of Connected Components in an Undirected Graph
You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.

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
edges[i] = [ai, bi]
ai != bi
There are no repeated edges.*/
class Solution {
    public int countComponents(int n, int[][] edges) {

        // Create Graph
        List<Integer>[] graph = new LinkedList[n];
        int[] visited = new int[n];
        int components = 0;
        // initialize the graph
        for(int i=0; i<n; i++) {
            graph[i] = new LinkedList<>();
        }

        // Build the graph
        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        for(int vertex=0; vertex<n; vertex++) {
            if(visited[vertex] == 0) {
                visited[vertex] = 1;
                bfs(vertex, graph, visited);
                components++;
            }
        }
        return components;

    }

    private void bfs(int v, List<Integer>[] graph, int[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i< size; i++) {
                int j = q.poll();
                visited[j] = 1;
                for(Integer vertex : graph[j]) {
                    if(visited[vertex] == 0) q.offer(vertex);
                }

            }
        }

    }
}