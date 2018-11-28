package com.kowalski0805;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static FilmCollection fc = new FilmCollection();

    public static void main(String[] args) {
        FilmDisplayHelper.display(fc.all());
        int action;
        do {
            action = promptInt();
            startAction(action);
        } while (action != 0);
    }

    private static int promptInt() {
        int action;
        do {
            System.out.println("\n1 - Отримати кінотеатри для фільму\n" +
                    "2 - Отримати фільми режисера\n" +
                    "3 - Отримати фільми за часом в кінотеатрі\n" +
                    "0 - Вийти");
            String actionString = scanner.nextLine();
            try {
                action = Integer.parseInt(actionString);
            } catch (NumberFormatException e) {
                action = -1;
            }
        } while (action < 0 || action > 3);
        return action;
    }

    private static void startAction(int action) {
        switch (action) {
            case 1:
                String title = prompt("Введіть назву фільму: ");
                if (title.equals("0")) break;
                FilmDisplayHelper.displayArray(fc.findCinemasByTitle(title));
                break;
            case 2:
                String director = prompt("Введіть режисера: ");
                if (director.equals("0")) break;
                FilmDisplayHelper.display(fc.findFilmsByDirector(director));
                break;
            case 3:
                String time = prompt("Введіть час (ГГ:ХХ): ");
                if (time.equals("0")) break;
                LocalTime start;
                try {
                    start = LocalTime.parse(time);
                } catch (DateTimeParseException e) {
                    break;
                }
                String cinema = prompt("Введіть кінотеатр: ");
                if (cinema.equals("0")) break;
                FilmDisplayHelper.display(fc.findFilmsByTimeAndCinema(start, cinema));
                break;
            default:
                break;
        }
    }

    private static String prompt(String s) {
        System.out.print("\nВведіть 0 щоб повернутися до меню\n" + s);
        return scanner.nextLine();
    }
}