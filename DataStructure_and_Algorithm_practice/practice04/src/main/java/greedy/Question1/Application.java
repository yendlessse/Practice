package greedy.Question1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;
/* 13305 - 주유소
* 지금까지 본 최소 주유 가격으로 다음 도로를 달린다
* 앞으로 더 싼 주유소가 나오기 전 까지는 현재 최소 가격으로 채우고 그 거리만큼 달리는게 항상이득*/

public class Application {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(""));
        int N = Integer.parseInt(br.readLine());

        long[] dist = new long[N-1];
        long[] price = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) dist[i] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) price[i] = Long.parseLong(st.nextToken());

        long ans = 0L;

        long minPrice = price[0];
        for (int i  = 0 ; i < N -1; i++){
            if (price[i] < minPrice) minPrice = price[i];
            ans += minPrice * dist[i];
        }
        System.out.println(Long.toString(ans));
    }
}
