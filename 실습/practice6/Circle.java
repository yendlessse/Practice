package com.ohgiraffers.level01.basic;

public class Circle extends Shape implements Resizable{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void resize(double factor) {
        this.radius = radius * factor;
    }

    @Override
    double calculateArea() {
        double area = Math.PI * Math.pow(radius, 2);
        return area;
    }

    @Override
    double calculatePerimeter() {
        double perimeter = 2 * Math.PI * radius;
        return perimeter;
    }
}
