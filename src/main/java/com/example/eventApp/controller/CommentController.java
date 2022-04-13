package com.example.eventApp.controller;

import com.example.eventApp.model.dto.CommentDTO;
import com.example.eventApp.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping(path = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createComment(@RequestBody CommentDTO commentDTO) {
        commentService.addNewComment(commentDTO);
    }
}
