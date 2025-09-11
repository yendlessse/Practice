package com.greedy.level01.basic.student.model.run;

import com.greedy.level01.basic.student.model.dto.StudentDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDTO[] students = new StudentDTO[10];

        int count = 0;
        while(count < 10){
            StudentDTO student =  new StudentDTO();
            System.out.print("학년 : ");
            student.setGrade(sc.nextInt());
            System.out.print("반 : ");
            student.setClassroom(sc.nextInt());
            System.out.print("이름 : ");
            student.setName(sc.next());
            System.out.print("국어점수 : ");
            student.setKor(sc.nextInt());
            System.out.print("영어점수 : ");
            student.setEng(sc.nextInt());
            System.out.print("수학점수 : ");
            student.setMath(sc.nextInt());

            students[count] = student;
            count++;

            System.out.print("계속 추가할 겁니까 ? (y/n) : ");
            String answer = sc.next();
            if(answer.equals("y") || answer.equals("Y")){
                continue;
            }else if (answer.equals("n") || answer.equals("N")){
                break;
            }else{
                while (true){
                    System.out.println("y와 n 중에 입력하세요");
                    System.out.print("계속 추가할 겁니까 ? (y/n) : ");
                    answer = sc.next();
                    if (answer.equals("y") || answer.equals("Y") || answer.equals("n") || answer.equals("N")){
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < count; i++){
            String stu_info = students[i].getInformation();
            System.out.println(stu_info);
        }

    }
}
