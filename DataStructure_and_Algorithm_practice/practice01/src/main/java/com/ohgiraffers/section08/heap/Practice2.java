package com.ohgiraffers.section08.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

class Jewelry {
    int weight;
    int price;

    public Jewelry(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }
}

public class Practice2 {
    public long solution(String input) throws IOException {
        BufferedReader br
                = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        //가벼운 가방부터 들어갈 수 있는 것 중 가장 비싼 걸 선택


        // 보석 정보 저장
        Jewelry[] jewelries = new Jewelry[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer diamond = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(diamond.nextToken());
            int price = Integer.parseInt(diamond.nextToken());
            jewelries[i] = new Jewelry(weight, price);
        }
        Arrays.sort(jewelries, Comparator.comparingInt(j -> j.weight));

        //가방 무게
        ArrayList<Integer> bags = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int bag = Integer.parseInt(br.readLine());
            bags.add(bag);
        }
        Collections.sort(bags);

        //정렬기준
        PriorityQueue<Jewelry> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.price == b.price) {
                        return Integer.compare(a.weight, b.weight); // 가격 같으면 무게 작은 순
                    }
                    return Integer.compare(b.price, a.price); // 가격 높은 순
                }
        );

        int totalPrice = 0;
        int j = 0; //보석 배열 인덱스

        //최대 가격 계산하기
        //가방 무게 작은 순서대로 돌아가게됨
        //따라서 pq리셋 하지 않아도됨
        for (int bagWeight : bags) {
            // 현재 가방에 넣을 수 있는 보석들을 pq에 추가
            while (j < n && jewelries[j].weight <= bagWeight) {
                pq.offer(jewelries[j]);
                j++;
            }
            // 가장 비싼 보석 하나 선택
            if (!pq.isEmpty()) {
                totalPrice += pq.poll().price; //보석 pq에서 꺼내기
            }
        }

        return totalPrice;
    }
}