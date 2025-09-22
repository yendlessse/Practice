package com.ohgiraffers.level01.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class Application6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> phoneBook = new HashMap<>();

        while (true){
            System.out.print("이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): ");
            String ans = sc.nextLine();
            if (ans.equals("exit")) {
                // 나가기
                break;
            }else if (ans.equals("search")) {
                // 검색
                System.out.print("검색 할 이름: ");
                String search = sc.nextLine();

                // 검색할 이름이 있는 경우
                if (phoneBook.containsKey(search)) {
                    System.out.println(search + "씨의 전화번호: " + phoneBook.get(search));
                }else{
                    System.out.println(search + "씨의 번호는 등록되어 있지 않습니다. ");
                }
            }else {
                String[] name_phone = ans.split(" ");
                if (name_phone.length == 2) {
                    phoneBook.put(name_phone[0], name_phone[1]);
                    System.out.println("추가 완료 : " + name_phone[0] + " " + name_phone[1]);
                } else {
                    System.out.println("입력이 잘못 되었습니다. 다음 양식으로 입력해주세요 : <이름> <전화번호>");
                }
            }
        }

    }
}
