package com.ohgiraffers.Q2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 백준1940
* 주몽문제
* 2가지의 재료를 합하여 M을 만들면 갑옷 만들어짐
*
* 풀이 과정
* sort 한 다음
*   M보다 큰 수면 넘어가고
*   M-해당 수가 리스트에 있으면 찾고 바로 끝
* */
public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> materials = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            materials.add(sc.nextInt());
        }

        int count = 0;
        Collections.sort(materials);

        for (int i = 0; i < materials.size(); i++) {
            int need = m - materials.get(i);
            for (int j = i+1; j < materials.size(); j++) {
                if (need == materials.get(j)) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
