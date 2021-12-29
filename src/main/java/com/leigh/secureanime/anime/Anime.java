package com.leigh.secureanime.anime;

public class Anime {
    private final Integer animeId;
    private final String title;

    public Anime(Integer animeId, String title) {
        this.animeId = animeId;
        this.title = title;
    }

    public Integer getAnimeId() {
        return animeId;
    }

    public String getTitle() {
        return title;
    }
}
