package com.leigh.secureanime.anime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/anime")
public class AnimeController {

    private static final List<Anime> ANIME_LIST = Arrays.asList(
            new Anime(1, "Attack On Titan"),
            new Anime(2, "Ghost In The Shell"),
            new Anime(3, "Gate")
    );

    @GetMapping(path = "{animeId}")
    public Anime getAnimeId(@PathVariable("animeId") Integer animeId) {
        return ANIME_LIST
                .stream()
                .filter(anime -> animeId.equals(anime.getAnimeId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Knackered"));
    }
}
