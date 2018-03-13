package com.acr.bloggit.managers.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acr.bloggit.accessors.IPostAccessor;
import com.acr.bloggit.converters.IPostConverter;
import com.acr.bloggit.domains.DomainPost;
import com.acr.bloggit.engines.IPostEngine;
import com.acr.bloggit.engines.impl.PostEngine;
import com.acr.bloggit.managers.IPostManager;
import com.acr.bloggit.views.ViewPost;

@SuppressWarnings("unused")
@Component
public class PostManager implements IPostManager {

    @Autowired
    IPostAccessor postAccessor;
    
    @Autowired
    IPostEngine postEngine;
    
    @Autowired
    IPostConverter postConverter;
    
    @Override
    public List<ViewPost> getAllPosts() {
        return postAccessor.findAll().stream()
                .map(postConverter::domainToView)
                .collect(Collectors.toList());
    }

    @Override
    public ViewPost getPostById(Long postId) {
        DomainPost domainPost = postAccessor.findOne(postId);
        if (domainPost == null) {
            throw new EntityNotFoundException("Unable to retrieve post: " + postId);
 
        }
        return postConverter.domainToView(domainPost);
    }

    @Override
    public List<ViewPost> getPostsByAuthor(String author) {
        return postAccessor.findAllByAuthor(author).stream()
                .map(postConverter::domainToView)
                .collect(Collectors.toList());
    }

    @Override
    public ViewPost createPost(ViewPost post) {
        return postConverter.domainToView(
                postAccessor.save(
                        postConverter.viewToDomain(post)));
    }

    @Override
    public ViewPost updatePost(Long postId, ViewPost post) {
        DomainPost currentPost = postAccessor.findOne(postId);
        if (currentPost == null || post.getPostId() != postId) {
            return null;
        }
        return postConverter.domainToView(
                postAccessor.save(
                        postConverter.viewToDomain(post)));
    }

    @Override
    public ViewPost deletePost(Long postId) {
        DomainPost post = postAccessor.findOne(postId);
        if (post == null) {
            return null;
        }
        postAccessor.delete(postId);
        return postConverter.domainToView(post);
    }

    @Override
    public List<ViewPost> getPostsInRange(Long startDate, Long endDate) {
        return postAccessor.findAll().stream()
                .map(postConverter::domainToView)
                .filter(post -> {
                    return postEngine.isPostInDateRange(post,startDate,endDate);
                })
                .collect(Collectors.toList());
    }

}
