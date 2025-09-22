package com.ohgiraffers.level02.normal;

import java.io.*;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("병합할 파일의 개수 입력 : ");
        int n = sc.nextInt();
        String[] files = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print((i+1) + " 번째 파일 이름 입력 : ");
            files[i] = sc.next();
        }

        sc.nextLine();
        System.out.print("병합 될 파일명 입력 : ");
        String fileZip =  sc.nextLine();

        for (int i = 0; i < n; i++) {
            try(BufferedReader br = new BufferedReader(new FileReader(files[i]));
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileZip, true))) { // append 모드

                String temp;
                while ((temp = br.readLine()) != null) {
                    bw.write(temp);
                    bw.newLine();
                }

                System.out.println("모든 파일 병합이 완료 되었습니다.");

            }  catch (IOException e) {
                System.out.println("오류 : " + files[i] + " (지정된 파일을 찾을 수 없습니다.)");
            }
        }

    }
}
