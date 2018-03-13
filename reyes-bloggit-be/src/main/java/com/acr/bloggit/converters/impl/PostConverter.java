package com.acr.bloggit.converters.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acr.bloggit.converters.IDateConverter;
import com.acr.bloggit.converters.IPostConverter;
import com.acr.bloggit.domains.DomainPost;
import com.acr.bloggit.engines.IPostEngine;
import com.acr.bloggit.views.ViewPost;

@Service
public class PostConverter implements IPostConverter {

    @Autowired
    IDateConverter dateConverter;
    
    @Autowired
    IPostEngine postEngine;
    
    @Override
    public DomainPost viewToDomain(ViewPost post) {
        DomainPost domain = new DomainPost();
        domain.setPostId(post.getPostId());
        domain.setTitle(post.getTitle());
        domain.setBody(post.getBody());
        domain.setAuthor(post.getAuthor());
        LocalDateTime now = LocalDateTime.now();
        domain.setLastUpdated(now);
        if (post.getPostId() == null) {
            domain.setCreatedOn(now);
        } else {
            domain.setCreatedOn(dateConverter.convertLongToLocalDateTime(post.getCreatedOn()));
        }
        return domain;
    }

    @Override
    public ViewPost domainToView(DomainPost post) {
        ViewPost view = new ViewPost();
        view.setPostId(post.getPostId());
        view.setTitle(post.getTitle());
        view.setBody(post.getBody());
        view.setAuthor(post.getAuthor());
        view.setSummary(postEngine.getSummaryText(post.getBody()));
        view.setLastUpdated(dateConverter.convertLocalDateTimeToLong(post.getLastUpdated()));
        view.setCreatedOn(dateConverter.convertLocalDateTimeToLong(post.getCreatedOn()));
        return view;
    }

}



