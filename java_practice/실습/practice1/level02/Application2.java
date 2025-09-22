package com.ohfiraffers.level02;

public class Application2 {
    public static void main(String[] args) {
        double korean = 80.5;
        double math = 50.6;
        double english = 70.8;

        double sum = korean + math + english;

        System.out.println("총점: " + (int) sum);
        System.out.println("평균: "+ (int) (sum/3));
    }
}
