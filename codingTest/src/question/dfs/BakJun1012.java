package question.dfs;

import java.util.Scanner;

/**
 * 백준 1012번 유기농 배추 (DFS)
 */
public class BakJun1012 {
    static int testCaseNum;
    static int answer;
    static int[][] graph;
    static boolean[][] visited;

    public void solve() {
        Scanner sc = new Scanner(System.in);
        testCaseNum = sc.nextInt();

        for (int t = 0; t < testCaseNum; t++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            int cabbageCount = sc.nextInt();

            answer = 0;
            graph = new int[row][col];
            visited = new boolean[row][col]; // boolean 배열로 초기화

            // 배추 위치 입력
            for (int i = 0; i < cabbageCount; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                graph[x][y] = 1;
            }

            // 배추밭 탐색
            for (int x = 0; x < row; x++) {
                for (int y = 0; y < col; y++) {
                    // 새로운 영역을 발견하면 DFS 탐색
                    if (graph[x][y] == 1 && !visited[x][y]) {
                        answer++;
                        dfs(x, y);
                    }
                }
            }

            System.out.println(answer); // 테스트 케이스 결과 출력
        }

        sc.close();
    }

    public void dfs(int x, int y) {
        // 그래프 범위를 벗어난 경우
        if (x < 0 || y < 0 || x >= graph.length || y >= graph[0].length) {
            return;
        }

        // 이미 방문했거나 배추가 없는 경우
        if (visited[x][y] || graph[x][y] == 0) {
            return;
        }

        // 방문 처리
        visited[x][y] = true;

        // 상하좌우 탐색
        dfs(x + 1, y); // 아래
        dfs(x - 1, y); // 위
        dfs(x, y + 1); // 오른쪽
        dfs(x, y - 1); // 왼쪽
    }
}
