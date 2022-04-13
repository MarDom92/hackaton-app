package com.example.eventApp.service;

import com.example.eventApp.model.dto.CommentDTO;
import com.example.eventApp.model.entity.Comment;
import com.example.eventApp.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    public void addNewComment(CommentDTO commentDTO) {
        commentRepository.save(modelMapper.map(commentDTO, Comment.class));
    }
}
