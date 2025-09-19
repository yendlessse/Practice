package com.ohgiraffers.virtualpet.util;

import com.ohgiraffers.virtualpet.service.DogService;

public class TimerUtil extends Thread {
    private final DogService dogService;
    private final String dogName;
    private boolean running = true;

    public TimerUtil(DogService dogService, String dogName) {
        this.dogService = dogService;
        this.dogName = dogName;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(30_000); // 30초마다
                dogService.decreaseStatus(dogName); // 배부름, 기분, 체력 감소
            } catch (InterruptedException e) {
                running = false; // interrupt 발생 시 종료
            }
        }
    }
}



