package com.ohgiraffers.level01.basic;

import java.util.Arrays;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        /* 대문자 변환기 */

        // 입력
        Scanner scanner = new Scanner(System.in);
        System.out.printf("문자열 입력 : ");
        String user_str =  scanner.nextLine();

        //공백을 기준으로 문자열 쪼개기
        String[] str_list =  user_str.split(" ");

        //배열에 든 단어들의 각 첫글자 대문자로 바꾸기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str_list.length; i++) {
            // str_list[i].charAt(0).toUpperCase() -> char타입에 String메서드를 쓰려함
            String ans_word = str_list[i].substring(0,1).toUpperCase() + str_list[i].substring(1);
            sb.append(ans_word).append(" ");
        }

        // 출력
        System.out.println("변화된 문자열 : " + sb);
        System.out.println("총 단어 개수 : " + str_list.length);
    }
}
