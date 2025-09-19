package com.ohgiraffers.virtualpet.domain;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int points;

    public User(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void usePoints(int amount) {
        if (points >= amount) {
            points -= amount;
        } else {
            System.out.println("포인트가 부족합니다!");
        }
    }



    public void addPoints(int amount) {
        points += amount;
    }
}
