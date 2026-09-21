class Solution {

    public boolean isCycleDFS(int src, boolean[] visit, boolean[] recPath, int[][] edges) {
        visit[src] = true;
        recPath[src] = true;

        for (int i = 0; i < edges.length; i++) {

            int v = edges[i][0];
            int u = edges[i][1];

            if (src == u) {

                if (!visit[v]) {
                    if (isCycleDFS(v, visit, recPath, edges)) {
                        return true;
                    }
                } else if (recPath[v]) {
                    return true;
                }
            }
        }

        recPath[src] = false;
        return false;
    }

    public void topologicalSort(int src, boolean[] visit, Stack<Integer> s, int[][] edges) {
        visit[src] = true;

        for (int i = 0; i < edges.length; i++) {

            int v = edges[i][0];
            int u = edges[i][1];

            if (src == u) {

                if (!visit[v]) {
                    topologicalSort(v, visit, s, edges);
                }
            }
        }

        s.push(src);
    }

    public int[] findOrder(int n, int[][] edges) {

        boolean[] visit = new boolean[n];
        boolean[] recPath = new boolean[n];

        // Cycle Detection
        for (int i = 0; i < n; i++) {

            if (!visit[i]) {

                if (isCycleDFS(i, visit, recPath, edges)) {
                    return new int[0];
                }
            }
        }

        // Topological Sort
        Stack<Integer> s = new Stack<>();
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {

            if (!visit[i]) {
                topologicalSort(i, visit, s, edges);
            }
        }

        int[] ans = new int[n];
        int index = 0;

        while (s.size() > 0) {
            ans[index] = s.peek();
            index++;
            s.pop();
        }

        return ans;
    }
}