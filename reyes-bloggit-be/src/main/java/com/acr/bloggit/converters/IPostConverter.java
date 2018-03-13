package com.acr.bloggit.converters;

import com.acr.bloggit.domains.DomainPost;
import com.acr.bloggit.views.ViewPost;

public interface IPostConverter {
    
    DomainPost viewToDomain(ViewPost post);
    
    ViewPost domainToView(DomainPost post);

}


