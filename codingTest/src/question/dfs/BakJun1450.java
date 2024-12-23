package question.dfs;

import java.util.Scanner;

/**
 * 백준 1450번 냅색문제 (DFS)
 */
public class BakJun1450 {

    static int N;
    static int C;
    static int[] weight;
    static int answer;

    public void solve(){

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        C = sc.nextInt();
        weight = new int[N];
        answer = 0;

        for(int i = 0; i < N; i++){
            weight[i] = sc.nextInt();
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    public void dfs(int idx, int curWeight){

        if(curWeight >C) return;

        if(idx == N){
            answer++;
            return;
        }

        dfs(idx+1, curWeight);

        dfs(idx+1, curWeight+weight[idx]);
    }
}
