import java.util.*;

class Maul {
    int maulnum;
    int time;
    
    public Maul(int maulnum, int time) {
        this.maulnum = maulnum;
        this.time = time;
    }
}
class Solution {
    static int n, k;
    static int[][] vil;
    static int[] dist;
    static PriorityQueue<Maul> q = new PriorityQueue<>((a, b)-> a.time - b.time);
    
    public long solution(int n, int[][] road, int k) {
        this.n = n;
        this.k = k;
        vil = new int[n][n];
        dist = new int[n];

        Arrays.fill(dist, 500001);
        dist[0] = 0;
        for (int i=0; i<n; i++) {
            Arrays.fill(vil[i], 10001);
        }
        for (int i=0; i<road.length; i++) {
            int a = road[i][0]-1;
            int b = road[i][1]-1;
            int c = road[i][2];
            
            vil[a][b] = Math.min(vil[a][b], c);
            vil[b][a] = vil[a][b];
        }
        q.add(new Maul(0, 0));
        di();
        //System.out.println(Arrays.toString(dist));
        return Arrays.stream(dist).filter(i->i<=k).count();
    }
    
    public static void di() {
        while (!q.isEmpty()) {
            Maul curMaul = q.poll();
            int cur = curMaul.maulnum;
            int time = curMaul.time;
            
            if (time>dist[cur]) {
                continue;
            }
            for (int i=0; i<n; i++) {
                if (vil[cur][i] != 10001 && dist[i] > time+vil[cur][i]) {
                    dist[i] = time+vil[cur][i];
                    q.add(new Maul(i, dist[i]));
                }
            }
        }
    }
}