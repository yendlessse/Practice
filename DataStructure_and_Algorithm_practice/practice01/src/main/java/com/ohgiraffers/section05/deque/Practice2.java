package com.ohgiraffers.section05.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Practice2 {
    public String solution(String command, Integer[] array) {

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            deque.offerLast(array[i]);
        }

        //뒤집기 체크
        boolean reversed = false;

        for (char c :command.toCharArray()) {
            if (c == 'R') {reversed = !reversed;}
            else if (c == 'D') {
                if (deque.isEmpty()) {
                    return "error";
                }
                if (!reversed) {
                    deque.pollFirst();
                } else {
                    deque.pollLast();
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (!deque.isEmpty()) {
            sb.append(!reversed ? deque.pollFirst() : deque.pollLast());
            if (!deque.isEmpty()) sb.append(",");
        }
        sb.append("]");

        return sb.toString();
    }
}