package com.acr.bloggit.accessors;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acr.bloggit.domains.DomainPost;

public interface IPostAccessor extends JpaRepository<DomainPost, Long> {

    List<DomainPost> findAllByAuthor(String author);
    
}


