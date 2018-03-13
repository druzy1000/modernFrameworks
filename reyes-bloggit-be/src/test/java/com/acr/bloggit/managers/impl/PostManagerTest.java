package com.acr.bloggit.managers.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import javax.persistence.EntityNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.acr.bloggit.accessors.IPostAccessor;
import com.acr.bloggit.converters.IPostConverter;
import com.acr.bloggit.domains.DomainPost;
import com.acr.bloggit.engines.IPostEngine;
import com.acr.bloggit.views.ViewPost;

@RunWith(MockitoJUnitRunner.class)
public class PostManagerTest {

   @Mock
   private IPostAccessor postAccessor;
   
   @Mock
   private IPostConverter postConverter;
   
   @Mock
   private IPostEngine postEngine;
   
   @InjectMocks
   private PostManager postManager;
   
    
   @Test
   public void testGetPostById() {
      
      DomainPost mockDomainPost = new DomainPost();
      ViewPost mockViewPost = new ViewPost();
      
      when(postAccessor.findOne(anyLong())).thenReturn(mockDomainPost);
      when(postConverter.domainToView(any(DomainPost.class))).thenReturn(mockViewPost);
      ViewPost response = postManager.getPostById(1L);
      assertThat(response, is(mockViewPost));
      
   }
   
   @Test(expected = EntityNotFoundException.class)
   public void testGetPostById_EntityNotFound() {
      when(postAccessor.findOne(anyLong())).thenReturn(null);
      postManager.getPostById(1L);

  }

   @Test
  public void testDeletePost() {
      DomainPost mockDomainPost = new DomainPost();
      ViewPost mockViewPost = new ViewPost();
      when(postAccessor.findOne(anyLong()))
          .thenReturn(mockDomainPost);
      doNothing().when(postAccessor).delete(any(DomainPost.class));
      when(postConverter.domainToView(any(DomainPost.class)))
          .thenReturn(mockViewPost);
      ViewPost response = postManager.deletePost(1L);
      assertThat(response, is(mockViewPost));        
  }

}
