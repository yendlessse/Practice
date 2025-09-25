package Question2;
/*
5 7 3
0 2 4 4
1 1 2 5
4 0 6 2
* */

//빈칸을 다 0로 놓고 직사각형은 1로 표시
// 0을 찾아다니면서 영역 넓이 세기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Application {
    // 세로 가로 직사각형 개수
    static int M, N, K;

    static int[][] map;

    static boolean[][] visit;

    //영역 넓이 저장
    static ArrayList<Integer> areaArr;

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

    static class Rectangle {
        int x1, y1, x2, y2;
        Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1; //왼쪽 아래
            this.y1 = y1;
            this.x2 = x2; //오른쪽 위
            this.y2 = y2;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); //세로
        N = Integer.parseInt(st.nextToken()); //가로
        K = Integer.parseInt(st.nextToken()); //직사각형 갯수

        map = new int[N][M];
        visit = new boolean[N][M];

        //직사각형 좌표 저장
        Rectangle[] rectangles = new Rectangle[K];
        for (int i = 0; i < K; i++) {
            String line = br.readLine();      // "0 2 4 4" 읽기
            String[] parts = line.split(" "); // 공백으로 나누기

            int x1 = Integer.parseInt(parts[0]);
            int y1 = Integer.parseInt(parts[1]);
            int x2 = Integer.parseInt(parts[2]);
            int y2 = Integer.parseInt(parts[3]);

            rectangles[i] = new Rectangle(x1, y1, x2, y2);

        }

        //직사각형 위치 표시
        for (Rectangle rect : rectangles) {
            for (int i = rect.x1; i < rect.x2; i++) {
                Arrays.fill(map[i], rect.y1, rect.y2, 1);
            }
        }

        int group = 0;
        areaArr = new ArrayList<>();
        //빈 영역 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visit[i][j]){
                    group++;
                    bfs(i, j);
                }
            }
        }

        StringBuilder sb =  new StringBuilder();
        sb.append(group).append("\n");
        Collections.sort(areaArr);
        for (int i = 0; i < group; i++) {
            sb.append(areaArr.get(i)).append(" ");
        }

        System.out.println(sb.toString());
    }
    static void bfs(int x, int y) {
        Queue<Node> q = new ArrayDeque<>();
        visit[x][y] = true;
        int area = 1;
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node node = q.poll();

            //상하좌우 살펴보기
            for (int i = 0; i < 4; i++) {
                int cx = node.x + dirX[i];
                int cy = node.y + dirY[i];

                if (cx < 0 || cy < 0 || cx >= N || cy >= M) continue;
                if (visit[cx][cy] || map[cx][cy] == 1) continue;

                q.offer(new Node(cx, cy));
                area++;
                visit[cx][cy] = true;
            }
        }
        areaArr.add(area);
    }
}
