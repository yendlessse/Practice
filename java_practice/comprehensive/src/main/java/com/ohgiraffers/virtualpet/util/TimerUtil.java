package com.ohgiraffers.virtualpet.util;

import com.ohgiraffers.virtualpet.domain.Dog;
import com.ohgiraffers.virtualpet.service.DogService;

public class TimerUtil extends Thread {
    private final DogService dogService;
    private final Dog dog;
    private boolean running = true;

    public TimerUtil(DogService dogService, Dog dog) {
        this.dogService = dogService;
        this.dog = dog;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(30_000); // 30초마다
                dogService.decreaseStatus(dog); // 배부름, 기분, 체력 감소
            } catch (InterruptedException e) {
                running = false;
            }
        }
    }

    // TimerUtil.java
    public void stopTimer() {
        running = false;
        this.interrupt(); // sleep 깨우기
    }

}
