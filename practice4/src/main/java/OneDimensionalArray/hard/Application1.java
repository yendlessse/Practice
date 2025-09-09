package OneDimensionalArray.hard;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        // 정수 입력
        Scanner scanner = new Scanner(System.in);
        System.out.printf("홀수인 양의 정수를 입력하세요 : ");
        int n = scanner.nextInt();
        //배열 생성
        int[] num_list = new int[n];

        // 정수 판별
        if (n <= 0 || n%2 == 0) {
            System.out.println("양수 혹은 홀수만 입력해야 합니다.");
        }

        //배열 수정
        // 중간 값
        int mid = n / 2 ;

        //중간 앞
        for (int i = 0; i <= mid; i++) {
            num_list[i] = i + 1;
        }

        //중간 뒤
        int temp = 1;
        for (int j = n-1; j > mid; j--) {
            num_list[j] = temp;
            temp ++;

        }

        // 배열 출력
        showArr(num_list);
    }
    private static void showArr(int[] arr) {
        for (int i = 0 ; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }
}
