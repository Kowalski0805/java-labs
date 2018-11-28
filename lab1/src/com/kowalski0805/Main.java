package com.kowalski0805;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Розробник: Федорович І. А.");
        int n = Main.readInt();

        Matrix matrix = new Matrix(n);

        System.out.println("До:");
        System.out.println(matrix.toString());

        matrix.transform();

        System.out.println("Після:");
        System.out.println(matrix.toString());
    }

    private static int readInt() {
        int i = 0;
        Scanner scanner = new Scanner(System.in);

        while (i < 1) {
            try {
                System.out.print("Введіть розмірність матриці: ");
                i = scanner.nextInt();
                if (i < 1) System.out.println("Розмірність повинна бути більше нуля!");
            } catch (InputMismatchException e) {
                System.out.println("Розмірність повинна бути цілим числом!");
                scanner.nextLine();
            }
        }

        return i;
    }
}

class Matrix {
    private float[][] values;

    Matrix(int n) {
        this.values = new float[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.values[i][j] = (float) Math.random() * 100;
            }
        }
    }

    void transform() {
        Element min = this.findMin();
        this.values[min.x][min.y] = this.values[0][0];
        this.values[0][0] = min.value;
    }

    private Element findMin() {
        float value = this.values[0][0];
        int x = 0;
        int y = 0;

        for (int i = 0; i < this.values.length; i++) {
            for (int j = 0; j < this.values.length; j++) {
                if (this.values[i][j] < value) {
                    value = this.values[i][j];
                    x = i;
                    y = j;
                }
            }
        }

        return new Element(value, x, y);
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        for (float[] row : values) {
            for (float value : row) {
                str.append(String.format("%.2f", value)).append("\t");
            }
            str.append("\n");
        }

        return str.toString();
    }
}

class Element {
    float value;
    int x;
    int y;

    Element(float value, int x, int y) {
        this.value = value;
        this.x = x;
        this.y = y;
    }
}