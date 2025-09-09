package OneDimensionalArray.advanced;

import java.util.Arrays;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 길이 4의 정수 배열
        int[] ans = new int[] {-1,-1,-1,-1};

        // 랜덤한 값 넣어 배열 완성
        // 중복 제거
        for (int i = 0; i < ans.length; i++) {
            while(true) {
                //0나오는건가?
                int temp = (int)(Math.random()*10);

                boolean isDuplicated = false;
                for (int n : ans) {
                    if (n == temp) {
                        isDuplicated = true;
                        break;
                    }
                }
                if(!isDuplicated) {
                    ans[i] = temp;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(ans));

        int guess_time = 10;
        while (guess_time != 0){

            //숫자 입력받기
            int guess = 0;
            while (true) {
                System.out.println(guess_time +"회 남으셨습니다.");
                System.out.printf("4자리 숫자를 입력하세요 : ");
                int temp = scanner.nextInt();
                int length = 0;
                int copy = temp;
                while (copy > 0) {
                    copy /= 10;
                    length++;
                }

                if (length == 4){
                    guess = temp;
                    break;
                }else{
                    System.out.println("4자리 정수를 입력해야 합니다.");
                    System.out.println();
                }
            }

            //추측 배열 만들기
            /*
                System.out.println(1234/1000 %10);
                System.out.println(1234/100 %10);
                System.out.println(1234/10 %10);
                System.out.println(1234 %10);
             */

            int[] guess_arr = new int[4];

            for (int i =0; i < 4; i++) {
                int div = 1;
                for (int j = 0; j < 4 - i -1; j ++) {
                    div *= 10;
                }
                guess_arr[i] = guess/div %10;
            }

            // 게임 시작
//          /* 배열에서 뽑아낸 수가 정답에 포함되어 있다면
//              - 같은 자리인지
//              - 같은 자리가 아닌지
//           * 배열에서 뽑아낸 수가 정답에 포함되어 있지 않다면
//              반복*/

            int strike = 0;
            int ball = 0;
            int ans_count = 0;
            for (int i = 0 ; i < 4; i++) {
                for (int j = 0; j < 4; j++){
                    // 배열에서 뽑아낸 수가 정답에 포함되어 있다면
                    if (guess_arr[i] == ans[j]) {
                        if (i == j) {
                            strike++;
                            ans_count++;
                        } else {
                            ball++;
                        }
                    }else {
                        continue;
                    }
                }
            }
            if (ans_count == 4) {
                System.out.println("정답입니다.");
                break;
            }else {
                System.out.println("아쉽네요 " +strike+"S " + ball + "B 입니다.");
                System.out.println();
                guess_time --;
            }

        }
        if (guess_time == 0) {
            System.out.println("10번의 기회를 모두 소진하셨습니다. 프로그램을 종료합니다");
        }
    }
}
