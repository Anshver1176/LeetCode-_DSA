class Solution {

    public void bfs(int source, List<List<Integer>> adj, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();

        q.add(source);

        while (q.size() > 0) {
            int front = q.remove();

            for (int ele : adj.get(front)) {
                if (!vis[ele]) {
                    q.add(ele);
                    vis[ele] = true;
                }
            }
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if (source == destination) {
            return true;
        }

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            adj.add(list);
        }

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean[] vis = new boolean[n];

        vis[source] = true;

        bfs(source, adj, vis);

        return vis[destination];
    }
}