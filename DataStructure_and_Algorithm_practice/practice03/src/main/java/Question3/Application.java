package Question3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Application {
    static int N;

    static int[][] height_map;

    static int MAX_AREA;
    static int[][] map;
    static boolean[][] visit;


    static class Node {
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    //상하좌우 개념의 좌표 배열
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        height_map = new int[N][N];

        int max = 0; //최고 수위
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] parts = line.split(" ");
            for (int j = 0; j < N; j++) {
                height_map[i][j] = Integer.parseInt(parts[j]);
                if (height_map[i][j] > max) {
                    max = height_map[i][j];
                }
            }
        }


        // 수위보다 이하이면 지도에 1로 표시하고 0인부분 탐색
        int max_group = 1;
        for (int m = 0; m < max; m++) {
            map = new int[N][N];
            map = rain_height_check(m);
            visit = new boolean[N][N];
            int group = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0 && !visit[i][j]){
                        group++;
                        bfs(i, j);
                    }
                }
            }
            if (group > max_group) {
                max_group = group;
            }
        }

        //출력
        System.out.println(max_group);


    }

    //비에 잠긴 곳 체크해서 새로운 맵 만들어주기
    static int[][] rain_height_check(int rain) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (height_map[i][j] <= rain) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 0;
                }
            }
        }
        return map;
    }

    static void bfs(int x, int y) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(x, y));
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int cx = node.x + dirX[i];
                int cy = node.y + dirY[i];

                if (cx < 0 || cy < 0 || cx >= N || cy >= N) continue;
                if (visit[cx][cy] || map[cx][cy] == 1) continue;

                queue.offer(new Node(cx, cy));
                visit[cx][cy] = true;
            }
        }
    }
}
