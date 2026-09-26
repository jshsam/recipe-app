package com.hembree.recipe_app.controller;

import com.hembree.recipe_app.model.Tag;
import com.hembree.recipe_app.repository.TagRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    private final TagRepository tagRepository;

    public TagController(TagRepository tagRepository) { this.tagRepository = tagRepository; }

    @GetMapping
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @GetMapping("/{id}")
    public Tag getTagById(@PathVariable Long id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tag not found"));
    }

    @PostMapping
    public Tag createTag(@RequestBody Tag tag) { return tagRepository.save(tag); }

    @DeleteMapping("/{id}")
    public void deleteTag(@PathVariable Long id) {
        if(!tagRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tag not found");
        }
        tagRepository.deleteById(id);
    }

}
