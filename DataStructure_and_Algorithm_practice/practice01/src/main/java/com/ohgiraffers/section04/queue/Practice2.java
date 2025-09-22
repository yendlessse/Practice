package com.ohgiraffers.section04.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Practice2 {
    public int solution(int w, int l, Integer[] truckWeight) {

        // 다리 만들기
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < w; i++) bridge.offer(0); // [0, 0]

        int t = 0;
        int index = 0; //truc_weights 배열 인덱스

        while (!bridge.isEmpty()) {
            //시간 증가
            t += 1;

            //다리 위 트럭 이동 (가장 앞에 있는 원소 제거)
            bridge.poll();

            int nowWeight = 0;
            //다리 위 트럭 무게 계산
            for (int i : bridge) nowWeight += i;

            if(index < truckWeight.length && (nowWeight + truckWeight[index]) <= l){
                bridge.offer(truckWeight[index]);
                index++;
            }else if (index < truckWeight.length && (nowWeight + truckWeight[index]) >= l){
                bridge.offer(0);
            }else {
                continue;
            }
            System.out.println(t);
            System.out.println(bridge);
        }
        System.out.println("최종 t:" + t);

        return t;
    }
}