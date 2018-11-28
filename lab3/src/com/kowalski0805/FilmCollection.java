package com.kowalski0805;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

class FilmCollection {
    private Film[] films = {
            new Film("Перший фільм", "Екшн", "Мужик", new String[]{"Multiplex", "Ультрамарин", "Космополіт"}, LocalTime.now().plusHours(2), 25.5f, 5),
            new Film("Другий фільм", "Комедія", "Мужик", new String[]{"Київська Русь", "Ультрамарин"}, LocalTime.now().plusHours(4), 16.4f, 20),
            new Film("Третій фільм", "Екшн", "Студент", new String[]{"Multiplex"}, LocalTime.now(), 75.5f, 1),
            new Film("Четвертий фільм", "Драма", "Студент", new String[]{"Київська Русь", "Космополіт"}, LocalTime.now().plusHours(6), 100.5f, 216)
    };

    Film[] all() { return this.films; }

    String[] findCinemasByTitle(String title) {
        for (Film film : this.films) {
            if (film.getTitle().equalsIgnoreCase(title)) return film.getCinemas();
        }
        return new String[0];
    }

    Film[] findFilmsByDirector(String director) {
        ArrayList<Film> films = new ArrayList<>();
        for (Film film : this.films) {
            if (film.getDirector().equalsIgnoreCase(director)) films.add(film);
        }

        Film[] filmsArray = new Film[films.size()];
        films.toArray(filmsArray);
        return filmsArray;
    }

    Film[] findFilmsByTimeAndCinema(LocalTime start, String cinema) {
        ArrayList<Film> films = new ArrayList<>();
        for (Film film : this.films) {
            if (film.getStartTime().isAfter(start)
                    && Arrays.asList(film.getCinemas()).contains(cinema))
                films.add(film);
        }

        Film[] filmsArray = new Film[films.size()];
        films.toArray(filmsArray);
        return filmsArray;
    }
}
