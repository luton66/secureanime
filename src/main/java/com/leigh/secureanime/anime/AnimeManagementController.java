package com.leigh.secureanime.anime;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AnimeManagementController {

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMIN_TRAINEE')")
    public List<Anime> getAllAnime() {
        return AnimeController.ANIME_LIST;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin:write')")
    public void addNewAnine(@RequestBody Anime anime) {
        System.out.println(anime);
    }

    @DeleteMapping(path = "{animeId}")
    @PreAuthorize("hasAuthority('admin:write')")
    public void deleteAnime(@PathVariable("animeId") Integer animeId) {
        System.out.println(animeId);
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('admin:write')")
    public void updateAnime(@PathVariable("animeId") Integer animeId, @RequestBody Anime anime) {
        System.out.println(String.format("%s %s", animeId, anime));
    }

    // Using annotations to pre-approve endpoints
    // The following can use...
    // hasRole('ROLE_') hasAnyRole('ROLE_') hasAuthority('permission') hasAnyAuthority('permission')
}
