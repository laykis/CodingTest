package question.dfs;

import java.util.*;

//백준 2606번 바이러스 문제 (DFS)
public class BakJun2606 {

    static int computerNum;
    static int conNum;
    static int[][] graph;
    static boolean[] visited;
    static int answer;

    public void solve(){
        Scanner sc = new Scanner(System.in);
        computerNum = sc.nextInt();
        conNum = sc.nextInt();
        graph = new int[computerNum+1][computerNum+1];
        visited = new boolean[graph.length];
        answer = 0;

        for(int i = 0; i < conNum; i++){
            int com1 = Integer.parseInt(sc.next());
            int com2 = Integer.parseInt(sc.next());
            graph[com1][com2] = 1;
            graph[com2][com1] = 1;

        }

        dfs(1);
        System.out.println(answer);
        sc.close();

    }

    public static void dfs(int start){
        visited[start] = true;

        for(int i = 1; i <= computerNum; i++){
            if(graph[start][i] == 1){
                if(!visited[i]){
                    answer++;
                    dfs(i);
                }
            }
        }
    }
}
