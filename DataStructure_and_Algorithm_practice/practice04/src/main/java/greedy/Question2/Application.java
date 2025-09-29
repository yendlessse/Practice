package greedy.Question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //테스트 케이스 갯수

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr, Comparator.comparingInt(x -> x[0]));

            int cnt = 0;
            int minInterview = Integer.MAX_VALUE;
            for (int k = 0; k < N; k++){
                if (arr[k][1] < minInterview){
                    cnt ++;
                    minInterview = arr[k][1];
                }
            }
            System.out.println(cnt);

        }
    }
}
