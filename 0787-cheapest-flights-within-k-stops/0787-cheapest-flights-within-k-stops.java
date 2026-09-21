class Solution {

    static class Info {
        int city;
        int cost;
        int stops;

        Info(int city, int cost, int stops) {
            this.city = city;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];

            graph[u].add(new int[]{v, wt});
        }

        int[] dist = new int[n];

        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;

        Queue<Info> q = new LinkedList<>();

        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {

            Info curr = q.remove();

            if (curr.stops > k) {
                continue;
            }

            for (int i = 0; i < graph[curr.city].size(); i++) {

                int[] edge = graph[curr.city].get(i);

                int nextCity = edge[0];
                int price = edge[1];

                if (curr.cost + price < dist[nextCity]) {

                    dist[nextCity] = curr.cost + price;

                    q.add(new Info(
                        nextCity,
                        dist[nextCity],
                        curr.stops + 1
                    ));
                }
            }
        }

        if (dist[dst] == Integer.MAX_VALUE) {
            return -1;
        }

        return dist[dst];
    }
}