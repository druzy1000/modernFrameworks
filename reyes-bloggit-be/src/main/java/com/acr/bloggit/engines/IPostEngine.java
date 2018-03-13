package com.acr.bloggit.engines;

import com.acr.bloggit.views.ViewPost;

public interface IPostEngine {

    boolean isPostInDateRange(ViewPost post, Long startDate, Long endDate);
    
    String getSummaryText(String text);
}


