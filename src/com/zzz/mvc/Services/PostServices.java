package com.zzz.mvc.Services;

import com.zzz.mvc.Mappers.PostMapper;
import com.zzz.mvc.entities.MasterAndFan;
import com.zzz.mvc.entities.Post;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostServices {

    private ApplicationContext applicationContext;
    private PostMapper postMapper;

    public PostServices() {

    }

    public PostServices(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public List showAllRelatedPosts(Integer Fans_id) {
        postMapper = applicationContext.getBean(PostMapper.class);
        List<Post> allRelatedPosts = postMapper.showAllRelatedPosts(Fans_id);
        return allRelatedPosts;
    }

}
