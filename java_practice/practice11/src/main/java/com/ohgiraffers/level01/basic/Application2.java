package com.ohgiraffers.level01.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Application2 {
    public static void main(String[] args) {
        LinkedList<String> urls =  new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        String url = "";

        while (true){
            System.out.print("방문 URL을 입력하세요 (단, exit를 입력하면 종료) : ");
            url = sc.nextLine();

            if (url.equals("exit")){
                break;
            }

            urls.addFirst(url);
            System.out.println("최근 방문 url : " + urls);
        }

        System.out.print("최근에 방문한 5개의 url : ");
        for (int i = 0; i < 5; i++) {
            System.out.print(urls.get(i) + " ");
        }
    }
}
