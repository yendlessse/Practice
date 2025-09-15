package com.ohgiraffers.level01.basic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("생년월일 입력 (yyyy-MM-dd 양식으로 작성) : ");
            String date = sc.nextLine();

            try {
                String[] dateArr = date.split("-");

                int birthYear = Integer.parseInt(dateArr[0]);
                int birthMonth = Integer.parseInt(dateArr[1]);
                int birthDay = Integer.parseInt(dateArr[2]);

                java.util.Calendar now = java.util.Calendar.getInstance();
                int nowYear = now.get(java.util.Calendar.YEAR);
                int nowMonth = now.get(java.util.Calendar.MONTH) + 1;
                int nowDay = now.get(java.util.Calendar.DAY_OF_MONTH);

                if ((dateArr.length != 3)
                        || (birthYear > nowYear)
                        || (birthMonth < 1 || birthMonth > 12)
                        || (birthDay < 1 || birthDay > 31)
                        || (birthYear == nowYear && birthMonth > nowMonth)
                        || (birthYear == nowYear && birthMonth == nowMonth && birthDay > nowDay)) {
                    throw new Exception("날짜 양식을 잘못 입력하셨습니다.");
                }


                int age = nowYear - birthYear;

                if ((nowMonth < birthMonth) || (nowMonth == birthMonth && nowDay < birthDay)) {
                    age --;
                }

                if (age < 20) {
                    throw new InvalidAgeException("만 20세 미만은 입장 불가입니다.");
                }

                System.out.println("입장하셔도 됩니다.");

            } catch (InvalidAgeException e) {
                System.out.println(e.getMessage());
            }catch (Exception e) {
                System.out.println("날짜 양식을 잘못 입력하셨습니다. ");
            }
        }

    }
}
