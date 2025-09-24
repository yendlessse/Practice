package com.ohgiraffers.Q3;

import java.util.*;
import java.io.*;

public class Application {
    static int idx(char c) {
        switch (c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken()); // 임의의 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 만들려는 비밀번호 길이

        char[] arr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        int[] need = new int[4]; // A(2) C(1) G(0) T(1)
        for (int i = 0; i < 4; i++) need[i] = Integer.parseInt(st.nextToken());

        int[] have = new int[4];
        for (int i = 0; i < P; i++) have[idx(arr[i])]++;

        int count = 0;
        if (ok(have, need)) count++;

        for (int i = P; i < S; i++) {
            have[idx(arr[i - P])]--;
            have[idx(arr[i])]++;
            if (ok(have, need)) count++;
        }

        System.out.println(count);
    }

    static boolean ok(int[] have, int[] need) {
        for (int k = 0; k < 4; k++) {
            if (have[k] < need[k]) return false;
        }
        return true;
    }
}
