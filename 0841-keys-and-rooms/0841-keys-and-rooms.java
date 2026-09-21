class Solution {
    private void bfs(int i, boolean[] vis,List<List<Integer>> adj ){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(q.size() > 0){
            int front = q.remove();
            for(int ele : adj.get(front)){
                if(!vis[ele]){
                    vis[ele] = true;
                    q.add(ele);
                }
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> adj) {
        int n = adj.size();
        boolean[] vis= new boolean[n];
        vis[0] = true;
        bfs(0,vis, adj);

        for(boolean ele : vis){
            if(ele == false) return false;
        }

        return true;
    }
}