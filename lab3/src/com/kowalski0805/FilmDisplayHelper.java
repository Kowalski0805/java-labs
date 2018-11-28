package com.kowalski0805;

import java.util.Arrays;

class FilmDisplayHelper {
    private static String[] fields = {"Назва", "Жанр", "Режисер", "Кінотеатри", "Початок", "Сер. ціна", "К-сть акторів"};

    static void display(Film[] films) {
        if (films.length == 0) {
            System.out.println("Нічого не знайдено!");
            return;
        }

        int[] widths = getMargins(films);

        for (int i = 0; i < fields.length; i++) {
            System.out.printf("%-" + widths[i] + "s    ", fields[i]);
        }
        System.out.println();

        for (Film film : films) {
            for (int i = 0; i < fields.length; i++) {
                System.out.printf("%-" + widths[i] + "s    ", get(film, i));
            }
            System.out.println();
        }
        System.out.println();

    }

    static void rawDisplay(Film[] films) {
        System.out.println(String.join("\t", fields));
        if (films.length == 0) System.out.println("Нічого не знайдено!");
        else for (Film film : films) System.out.println(film.toString());
    }

    private static int[] getMargins(Film[] films) {
        int[] widths = {5, 4, 7, 10, 7, 9, 13};

        for (Film film : films) {
            for (int i = 0; i < fields.length; i++) {
                int fieldLength = get(film, i).length();
                if (fieldLength > widths[i]) widths[i] = fieldLength;
            }
        }

        return widths;
    }

    private static String get(Film film, int i) {
        switch (i) {
            case 0:
                return film.getTitle();
            case 1:
                return film.getGenre();
            case 2:
                return film.getDirector();
            case 3:
                return Arrays.toString(film.getCinemas());
            case 4:
                return String.format("%tR", film.getStartTime());
            case 5:
                return String.format("%.2f", film.getAvgPrice());
            case 6:
                return Integer.toString(film.getActorsCount());
            default:
                return "";
        }
    }

    static void displayArray(String[] cinemas) {
        if (cinemas.length == 0) {
            System.out.println("Нічого не знайдено!");
            return;
        }
        System.out.println("Кінотеатри:\n" + Arrays.toString(cinemas));
    }
}
