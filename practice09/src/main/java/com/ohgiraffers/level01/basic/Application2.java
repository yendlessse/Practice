package com.ohgiraffers.level01.basic;

import java.io.*;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("원본 파일의 이름을 입력하세요 : ");
        String originFileName = sc.nextLine();

        System.out.print("복사 파일의 이름을 입력하세요 : ");
        String copyFile = sc.nextLine();


        try (FileReader fr = new FileReader(originFileName);
             FileWriter fw = new FileWriter(copyFile)) {

            int value;
            while ((value = fr.read()) != -1) {
                fw.write(value);
            }

            System.out.println("파일 복사가 성공적으로 완료 되었습니다.");

        } catch (FileNotFoundException e) {
            System.out.println("오류 : " + originFileName + " (지정된 파일을 찾을 수 없습니다)");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
