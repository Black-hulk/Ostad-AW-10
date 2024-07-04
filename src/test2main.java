

import java.util.Scanner;

abstract class Shape {
    public abstract void draw();
    public abstract double calculateArea();
}


class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}


class Square extends Shape {
    private double wdith;

    public Square(double wdith) {
        this.wdith = wdith;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }

    @Override
    public double calculateArea() {
        return wdith * wdith;
    }
}


class Triangle extends Shape {
    private double wdith;
    private double length;

    public Triangle(double wdith, double length) {
        this.wdith = wdith;
        this.length = length;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Triangle");
    }

    @Override
    public double calculateArea() {
        return 0.5 * wdith * length;
    }
}


public class test2main {
    public static void main(String[] args) {
    	
        Shape circle = new Circle(5);
        Shape square = new Square(9);
        Shape triangle = new Triangle(3, 6);

        circle.draw();
        System.out.println("Circle Area: " + circle.calculateArea());
        square.draw();
        System.out.println("Square Area: " + square.calculateArea());

        triangle.draw();
        System.out.println("Triangle Area: " + triangle.calculateArea());
    }
}
