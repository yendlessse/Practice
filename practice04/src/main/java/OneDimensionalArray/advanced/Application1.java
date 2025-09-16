package OneDimensionalArray.advanced;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Application1 {
    public static void main(String[] args) {
        int[] arr = new int[6];

        // arr[i] 값 만들기
        for (int i = 0 ; i < 6; i ++) {
            while(true) {
                // 난수생성
                int temp = (int)(Math.random()*45) + 1;

                // 중복일 경우
                boolean isDuplicated = false;
                for (int n : arr) {
                    if (n == temp) {
                        isDuplicated = true;
                        break;
                    }
                }
                //중복이 아닐 경우
                if(!isDuplicated) {
                    arr[i] = temp;
                    break;
                }
            }
        }
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}

