package com.ohgiraffers.level01.basic;

public class ShapeManager{
    private Shape[] shapes = new Shape[10];
    private int index;

    public void addShape(Shape shape) {
        /* 배열에 전달 된 Shape를 추가. 단, 배열의 크기가 부족할 경우 2배로 늘려서 추가. */
        shapes[index++] = shape;
    }

    public void removeShape(Shape shape) {
        for (int i = 0; i < index; i++) { // index까지만 확인
            if (shapes[i] == shape) {
                // 뒤에 있는 요소를 한 칸씩 앞으로 이동
                for (int j = i; j < index - 1; j++) {
                    shapes[j] = shapes[j + 1];
                }
                shapes[index - 1] = null;
                index--;
                break;
            }
        }
    }

    public void printAllShapes() {
        /* 배열에 저장 된 모든 도형의 이름, 넓이, 둘레를 출력 */
        for(Shape shape : shapes){
            if(shape != null){
                System.out.println("Shape: " + shape.getClass().getSimpleName());
                System.out.println("Area: " + shape.calculateArea());
                System.out.println("Perimeter: " + shape.calculatePerimeter());
            }

        }
    }

    public double getTotalArea() {
        /* 배열에 저장 된 모든 도형의 넓이를 더해서 반환 */
        double totalArea = 0;
        for (Shape shape : shapes){
            if(shape != null){
                totalArea += shape.calculateArea();
            }
        }
        return totalArea;
    }

    public double getTotalPerimeter() {
        /* 배열에 저장 된 모든 도형의 둘레를 더해서 반환 */
        double totalPerimeter = 0;
        for (Shape shape : shapes){
            if(shape != null){
                totalPerimeter += shape.calculatePerimeter();
            }
        }
        return totalPerimeter;
    }
}
