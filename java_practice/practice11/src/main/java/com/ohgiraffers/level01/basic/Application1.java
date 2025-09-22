package com.ohgiraffers.level01.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> scores = new ArrayList<>();

        System.out.print("학생 성적 : ");
        int score = sc.nextInt();
        scores.add(score);

        System.out.print("추가 입력하려면 y : ");
        String is_more = sc.next();

        while(is_more.equals("y") || is_more.equals("Y")){
            System.out.print("학생 성적 : ");
            score = sc.nextInt();
            scores.add(score);

            System.out.print("추가 입력하려면 y : ");
            is_more = sc.next();

        }

        System.out.println("학생 인원 : " + scores.size());

        int sum = 0;
        for (int s : scores) {
            sum += s;
        }
        double ave_score = sum/scores.size();

        System.out.println("평균 점수 : " + ave_score);
    }
}
