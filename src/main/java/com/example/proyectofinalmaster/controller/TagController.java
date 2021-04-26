package com.example.proyectofinalmaster.controller;

import com.example.proyectofinalmaster.model.Tags;
import com.example.proyectofinalmaster.service.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TagController {

    private final TagService tagService;


    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    /**
     * RETRIEVE - Find all tags with multiple parameters
     * @param size The name by which it will be filtered
     * @param pagination pagination - The name by which it will be filtered
     * @param name name - The name by which it will be filtered
     * @return The call from TagService
     */
    @GetMapping("/tags")
    public ResponseEntity<List<Tags>> findAllTags(@RequestParam(name = "size", required = false, defaultValue = "10") int size,
                                                  @RequestParam(name = "pagination", required = false, defaultValue = "0") int pagination,
                                                  @RequestParam(name = "name", required = false) String name) {

        if (name != null) {
            List<Tags> tagsName = tagService.findByName(name, size, pagination);
            if (!tagsName.isEmpty())
                return ResponseEntity.ok().body(tagsName);
        }
        return ResponseEntity.ok().body(tagService.findAllTags(size, pagination));
    }

    /**
     * RETRIEVE - Find tag by id
     * @param id Long Primary key - The number by which it will be filtered
     * @return The call from TagService
     */
    @GetMapping("/tag_id")
    public Tags findTagById(@RequestParam Long id) {
        return tagService.findTagId(id);
    }

    /**
     * CREATE - Create tag in Postman
     * @param tagdata The name by which it will be filtered
     * @return The call from TagService
     */
    @PostMapping("/create_tag")
    public Tags createTag(@RequestBody Tags tagdata) {
        return tagService.createTag(tagdata);
    }

    /**
     * UPDATE - Update an tag by id in Postman
     * @param id Long Primary key - The number by which it will be filtered
     * @return The call from TagService
     */
    @PutMapping("/update_tag")
    public Tags updateTagById(@RequestParam Long id, @RequestBody Tags tagdata) {
        Tags tag = tagService.findTagId(id);
        tagdata.setId(tag.getId());
        return tagService.updateTag(tagdata);
    }

    /**
     * DELETE - Delete an tag by id in Postman
     * @param id Long Primary key - The number by which it will be filtered
     * @return The call from TagService
     */
    @DeleteMapping("/delete_tag")
    public Tags deleteTagById(@RequestParam Long id) {
        return tagService.deleteTag(id);
    }
}
