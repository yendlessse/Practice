package com.ohgiraffers.level01.basic;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        /* 텍스트 분석기 */

        //  사용자 입력 받기
        Scanner scanner = new Scanner(System.in);
        System.out.printf("문자열 입력 : ");
        String user_str =  scanner.nextLine(); // 사용자가 입력한 문자열

        //  입력 문자열을 공백 기준으로 나누어 배열에 저장
        String[] str_list =  user_str.split(" ");

        //  단어 방문 여부 체크 배열 (0 = 미방문, 1 = 방문)
        int[] Visited = new int[str_list.length];

        //  각 단어의 빈도수를 저장할 배열
        int[] count = new int[str_list.length];

        //  단어별로 반복
        for (int i = 0; i < str_list.length; i++) {
            str_list[i] = str_list[i].replaceAll("[^a-zA-Z]", "");
            // 빈문자열이면 넘어가기
            if(str_list[i].isEmpty()) continue;
            String source = str_list[i];

                //  아직 방문하지 않은 단어만 처리
                if (Visited[i] == 0) {
                    Visited[i] = 1;   // 현재 단어 방문 처리
                    count[i] = 1;     // 처음 등장했으므로 count 1

                    //  현재 단어 이후 단어들과 비교
                    for (int j = i+1; j < str_list.length; j++) {

                        //  비교 대상 단어가 아직 방문되지 않았다면
                        if(Visited[j] == 0) {
                            //  대소문자 무시하고 두 단어가 같은지 확인
                            boolean isEqual = target(source, str_list[j]);
                            if (isEqual) {
                                Visited[j] = 1;           // 방문 처리
                                count[i] += count[i]++;   // 빈도수 증가
                            }
                        }
                    }
                }
        }

        //  최댓값(가장 많이 등장한 단어) 찾기
        int max_idx = 0;
        int max_value = count[0];

        for (int i = 0; i < count.length; i++) {
            //  count가 0이 아닌 단어 출력
            if(count[i] != 0){
                System.out.println(str_list[i] + ":" + count[i] + "개");
            }

            //  최댓값 갱신
            if (count[i] > max_value){
                max_value = count[i];
                max_idx = i;
            }
        }

        //  가장 빈도 높은 단어 출력
        System.out.println("가장 빈도 높은 단어 : " + str_list[max_idx] + " (" + count[max_idx] + "번)");
    }

    // 두 문자열이 같은지 대소문자 무시하고 비교
    public static boolean target(String source, String target) {
        if (source.compareToIgnoreCase(target) == 0) {
            return true;
        } else {
            return false;
        }
    }
}
