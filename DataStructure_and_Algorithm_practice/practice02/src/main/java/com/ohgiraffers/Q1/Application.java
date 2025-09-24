package com.ohgiraffers.Q1;

import java.util.Arrays;
import java.util.Scanner;

/* 백준 1654
    왼쪽(l) = 1 (최소 가능 길이)

    오른쪽(r) = 최대 랜선 길이

    중간(m) = (l + r) / 2

    판단 함수

    중간값 m으로 랜선을 잘랐을 때 K개 이상 만들 수 있는가?

    각 랜선을 m 길이로 나누어서 몇 개가 나오는지 계산

    합이 K 이상이면 “가능”

    K보다 작으면 “불가능”
*/

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();
        //만들 수 있는 랜선의 최대 길이
        int ans = 0;

        int[] cables = new int[k];

        for (int i = 0; i < k; i++) {
            cables[i] = sc.nextInt();
        }

        System.out.println(length_range(cables, n));

    }

    //만들 수 있는 쪼갠 케이블 개수 판단
    private static boolean can_I_make_by_length_mid(int[] cables, int mid, int n){
        int count  = 0;
        for (int cable : cables) {
            //케이블을 순화 하면서 mid값으로 쪼개 count 값을 올려준다
            count += cable/mid;
        }
        if (count >= n) return  true;
        else return false;
    }

    //이분 탐색
    private static int BSearch(int[] cables, int s, int r, int n){
        if (s > r) return r; //종료조건 알맞는 쪼개는 값 찾음

        int mid = (s + r) /2;
        if (can_I_make_by_length_mid(cables, mid, n)){
            return BSearch(cables,mid+1, r, n); //자를 수 있으면 mid의 오른쪽만 보기
        }else {
            return BSearch(cables, s, mid-1, n); //자를 수 없으면 mid의 왼쪽만 보기
        }

    }

    //길이 범위 설정
    private static int length_range(int[] cables, int n){
        int s = 1;
        int r = Arrays.stream(cables).max().getAsInt();

        return BSearch(cables, s, r, n);
    }

}
