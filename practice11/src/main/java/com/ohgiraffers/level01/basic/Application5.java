package com.ohgiraffers.level01.basic;

import java.util.Scanner;
import java.util.TreeSet;

public class Application5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<String> wordTS = new TreeSet<>();

        while (true) {
            System.out.print("단어 입력 ('exit' 입력 시 종료): ");
            String word = sc.nextLine();
            if (word.equals("exit")) {
                System.out.println("정렬 된 단어 : " + wordTS);
                break;
            }else {
                wordTS.add(word);
            }
        }
    }
}
