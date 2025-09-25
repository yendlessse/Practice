package Question1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Application {
    //지도의 크기
    static int N;
    //지도
    static int[][] map;
    //방문 배열
    static boolean[][] visit;
    //집 개수 저장
    static ArrayList<Integer> houseCountArr;

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

    // 현재 좌표
    static int cx, cy;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N][N];

        // 집 표시
        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = Character.getNumericValue(ch[j]);
            }
        }

//        //집 보기
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        int group = 0;
        houseCountArr = new ArrayList<>(); //집 개수 저장

        //단지 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //방문하지 않은 위치에 집이 있다면 단지로 설정한다
                if (map[i][j] == 1 && !visit[i][j]) {
                    group++;
                    // 해당 위치와 상하좌우로 붙어있는 집을 방문 체크한다
                    bfs(i, j);
                }
            }
        }



        //출력문
        sb.append(group).append("\n"); //단지
        //집 수 오름차순
        Collections.sort(houseCountArr);
        for (int i = 0; i < group; i++) {
            sb.append(houseCountArr.get(i)).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void bfs(int x, int y) {

        Queue<Node> q = new ArrayDeque<>();
        visit[x][y] = true;
        //집 개수 세기
        int houseCount = 1;
        q.offer(new Node(x, y));

        // 연속적으로 상하좌우에 집이 있다면 해당 위치를 방문한 것으로 체크하고
        // queue를 통해 탐색을 진행한다
        while (!q.isEmpty()) {
            Node node = q.poll();

            //상하좌우 살펴보기
            for (int i = 0; i < 4; i++) {
                int cx = node.x + dirX[i];
                int cy = node.y + dirY[i];

                if (cx < 0 || cy < 0 || cx >= N || cy >= N) continue;
                if (visit[cx][cy] || map[cx][cy] == 0) continue;

                q.offer(new Node(cx, cy));
                houseCount++;
                visit[cx][cy] = true;
            }
        }
        houseCountArr.add(houseCount);
    }
}

