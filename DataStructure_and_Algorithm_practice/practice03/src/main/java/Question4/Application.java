package Question4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 촌수 계산
    깊이우선탐색으로 풀어야 겠다
    연결된 최대한 내려가고 내려간 만큼 전에꺼 +1

* */
public class Application {
    static int N; // 전체 사람 수
    static int now, end;
    static int M; // 부모 자식 관계 수
    static int answer = -1; // 답

    static int[][] map;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String line = br.readLine();
        String[] tmp = line.split(" ");
        now = Integer.parseInt(tmp[0]); //시작
        end = Integer.parseInt(tmp[1]); //끝

        M = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        visit = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            line = br.readLine();
            String[] parts = line.split(" ");
            int parent = Integer.parseInt(parts[0]);
            int child = Integer.parseInt(parts[1]);
            map[parent][child] = 1;
            map[child][parent] = 1;
        }

        dfs(now, 0);
        System.out.println(answer);

    }

    public static void dfs(int point, int cnt) {
        visit[point] = true;
        for (int i = 1; i <= N; i++) {
            if (map[point][i] == 1 && !visit[i]) {
                if (i == end) {
                    answer = cnt + 1;
                    return;
                }
                dfs(i, cnt + 1);
            }
        }

    }
}
