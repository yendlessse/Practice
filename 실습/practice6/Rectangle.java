package com.ohgiraffers.level01.basic;

public class Rectangle extends Shape implements Resizable{
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void resize(double factor) {
        this.width = width * factor;
        this.height = height * factor;
    }

    @Override
    double calculateArea() {
        double area = width * height;
        return area;
    }

    @Override
    double calculatePerimeter() {
        double perimeter = (width + height) * 2;
        return perimeter;
    }
}
