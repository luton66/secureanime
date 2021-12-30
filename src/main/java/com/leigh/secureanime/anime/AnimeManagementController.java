package com.leigh.secureanime.anime;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AnimeManagementController {

    @GetMapping
    public List<Anime> getAllAnime() {
        return AnimeController.ANIME_LIST;
    }

    @PostMapping
    public void addNewAnine(@RequestBody Anime anime) {
        System.out.println(anime);
    }

    @DeleteMapping(path = "{animeId}")
    public void deleteAnime(@PathVariable("animeId") Integer animeId) {
        System.out.println(animeId);
    }

    @PutMapping(path = "{studentId}")
    public void updateAnime(@PathVariable("animeId") Integer animeId, @RequestBody Anime anime) {
        System.out.println(String.format("%s %s", animeId, anime));
    }
}
