package com.ohgiraffers.section03.stack;

import java.util.Stack;

public class Practice2 {
    public int solution(String input) {
        char[] arr = input.toCharArray();
        Stack<Character> stack = new Stack<>();

        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(arr[i]);
            }else if (arr[i] == ')') {
                // 레이저 인 경우
                if (i != 0 && arr[i - 1] == '(') {
                    stack.pop(); //레이저니까 스택에서 pop

                    //스택에 남아있는 ( 개수(= 열려 있는 쇠막대기 개수)
                    //레이저로 자르면 열려있는 괄호만큼 생김
                    ans += stack.size();

                }
                // 쇠막대기 끝 여부
                else if (i != 0 && arr[i - 1] == ')'){
                    stack.pop();
                    ans += 1;
                }
            }
        }
        return ans;
    }
}