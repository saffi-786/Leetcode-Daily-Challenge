class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int indegree[] = new int[numCourses];
        int count = 0;
        
        for(int i = 0; i < numCourses; i++) {
            for(int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()) {
            int node = q.poll();
            count++;
            
            for(int it : adj.get(node)) {
                indegree[it]--;
                
                if(indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }
        
        return count == numCourses;
    }
}