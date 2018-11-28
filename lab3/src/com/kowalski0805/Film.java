package com.kowalski0805;

import java.time.LocalTime;
import java.util.Arrays;

class Film {
    private String title;
    private String genre;
    private String director;
    private String[] cinemas;
    private LocalTime startTime;
    private float avgPrice;
    private int actorsCount;

    Film(String title, String genre, String director, String[] cinemas, LocalTime startTime, float avgPrice, int actorsCount) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.cinemas = Arrays.copyOf(cinemas, cinemas.length);
        this.startTime = startTime;
        this.avgPrice = avgPrice;
        this.actorsCount = actorsCount;
    }

    String getTitle() {
        return title;
    }

    String getGenre() {
        return genre;
    }

    String getDirector() {
        return director;
    }

    String[] getCinemas() {
        return Arrays.copyOf(cinemas, cinemas.length);
    }

    LocalTime getStartTime() {
        return startTime;
    }

    float getAvgPrice() {
        return avgPrice;
    }

    int getActorsCount() {
        return actorsCount;
    }

    @Override
    public String toString() {
        return  title +
                "\t" + genre +
                "\t" + director +
                "\t" + Arrays.toString(cinemas) +
                "\t" + startTime +
                "\t" + avgPrice +
                "\t" + actorsCount;
    }
}
