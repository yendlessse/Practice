package TwoDimensionalArray.hard;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int width = 0;
        int height = 0;
        while (true){
            System.out.printf("가로 행의 수를 입력하세요 : ");
            width = scanner.nextInt();
            if (width < 1 || width > 10) {
                System.out.println("반드시 1~10까지의 정수를 입력해야 합니다. 다시 입력하세요.");
            }else {
                break;
            }
        }

        while (true){
            System.out.printf("세로 행의 수를 입력하세요 : ");
            height = scanner.nextInt();
            if (height < 1 || height > 10) {
                System.out.println("반드시 1~10까지의 정수를 입력해야 합니다. 다시 입력하세요.");
            }else {
                break;
            }
        }


        char[][] arr = new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = (char)('A' + (int)(Math.random()*26));
            }
        }

        arrPrint(arr);

    }
    public static void arrPrint (char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
