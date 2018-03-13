package com.acr.bloggit.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acr.bloggit.managers.IPostManager;
import com.acr.bloggit.views.ViewPost;

@RestController
@RequestMapping("/api/v1/post")
public class PostControllerV1 {
    
    @Autowired
    IPostManager postManager;
    
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<ViewPost>> getAllPosts() {
        return new ResponseEntity<>(postManager.getAllPosts(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{postId}", method = RequestMethod.GET)
    ResponseEntity<ViewPost> getPost(@PathVariable Long postId) {
        return new ResponseEntity<> (postManager.getPostById(postId), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    ResponseEntity<List<ViewPost>> getPostsByParams(
            @RequestParam(value = "author", required = false) String author,
            @RequestParam(value = "startDate", required = false) Long startDate,
            @RequestParam(value = "endDate", required = false) Long endDate
            ) {
        if (startDate != null && endDate != null) {
            return new ResponseEntity <> (postManager.getPostsInRange(startDate, endDate),HttpStatus.OK);
        } else if (author != null) {
            return new ResponseEntity <> (postManager.getPostsByAuthor(author),HttpStatus.OK);
        } else {
            return new ResponseEntity <> (Collections.emptyList(),HttpStatus.OK);
        }
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    ResponseEntity<ViewPost> createPost(@RequestBody ViewPost post) {
        return new ResponseEntity <> (postManager.createPost(post), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{postId}", method = RequestMethod.PUT)
    ResponseEntity<ViewPost> updatePost(@PathVariable Long postId, @RequestBody ViewPost post) {
        return new ResponseEntity <>(postManager.updatePost(postId, post), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{postId}", method = RequestMethod.DELETE)
    ResponseEntity<ViewPost> deletePost(@PathVariable Long postId) {
        return new ResponseEntity <>(postManager.deletePost(postId), HttpStatus.OK);
    }
    
}


