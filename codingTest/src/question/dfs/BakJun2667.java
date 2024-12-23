package question.dfs;

import java.util.*;

/**
 * 백준 2667번 단지번호붙이기 (DFS)
 */
public class BakJun2667 {

    static boolean[][] visited;
    static int[][] board;
    static int N;
    static int houseCnt;


    public void solve() {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        board = new int[N][N];
        visited = new boolean[N][N];
        List<Integer> list = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(Character.toString(line.charAt(j)));
            }
        }

        for(int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
                if(board[j][k] == 1){
                    houseCnt = 0;
                    dfs(j, k);

                    if(houseCnt != 0){
                        list.add(houseCnt);
                    }
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for(int i : list){
            System.out.println(i);
        }

    }

    public void dfs(int x, int y){

        if(x < 0 || x >= N || y < 0 || y >= N) return;

        if(visited[x][y]) return;

        if(board[x][y] == 0) return;

        houseCnt++;
        visited[x][y] = true;

        dfs(x-1, y);
        dfs(x+1, y);
        dfs(x, y+1);
        dfs(x, y-1);


    }
}
