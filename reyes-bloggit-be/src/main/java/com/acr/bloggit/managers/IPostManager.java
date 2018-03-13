package com.acr.bloggit.managers;

import java.util.List;

import com.acr.bloggit.views.ViewPost;

public interface IPostManager {
    
    List<ViewPost> getAllPosts();

    ViewPost getPostById(Long postId);
    
    List<ViewPost> getPostsInRange(Long startDate, Long endDate);

   List<ViewPost> getPostsByAuthor(String author);

   ViewPost createPost(ViewPost post);

   ViewPost updatePost(Long postId, ViewPost post);

   ViewPost deletePost(Long postId);

}


