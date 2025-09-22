package com.ohgiraffers.virtualpet.domain;

import java.io.Serial;
import java.io.Serializable;

public class Dog implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int hunger; // 배부름: 0~100
    private int mood; // 기분: 0~100
    private int energy; // 체력: 0~100

    public Dog() {
        this.hunger = 100;
        this.mood = 100;
        this.energy = 100;
    }

    public Dog(String name) {
        this.name = name;
        this.hunger = 100;
        this.mood = 100;
        this.energy = 100;
    }

    //행동 메서드
    public void feed() {
        hunger += 10;
        if (hunger > 100) {
            hunger = 100;
        }
    }

    public void play() {
        mood += 10;
        if (mood > 100) {
            mood = 100;
        }
    }

    public void sleep() {
        energy += 10;
        if (energy > 100) {
            energy = 100;
        }
    }

    // 감소 메서드
    public void decreaseHunger(int amount) {
        hunger -= amount;
        if (hunger < 0) hunger = 0;
    }

    public void decreaseMood(int amount) {
        mood -= amount;
        if (mood < 0) mood = 0;
    }

    public void decreaseEnergy(int amount) {
        energy -= amount;
        if (energy < 0) energy = 0;
    }


    //getter

    public int getHunger() {
        return hunger;
    }

    public int getMood() {
        return mood;
    }

    public int getEnergy() {
        return energy;
    }

    public String getName() {
        return name;
    }
}
