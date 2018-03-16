package com.zzz.mvc.handlers;

import com.zzz.mvc.Mappers.AccountMapper;
import com.zzz.mvc.Mappers.CommentMapper;
import com.zzz.mvc.Mappers.PostMapper;
import com.zzz.mvc.Services.PostServices;
import com.zzz.mvc.entities.Comment;
import com.zzz.mvc.entities.Post;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.*;

@Controller
@RequestMapping(value = "/PostText")
public class PostHandler {

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "com/zzz/mvc/config/Spring/applicationContext.xml"
    );

    private PostMapper postMapper = applicationContext.getBean(PostMapper.class);
    private CommentMapper commentMapper = applicationContext.getBean(CommentMapper.class);
    private AccountMapper accountMapper = applicationContext.getBean(AccountMapper.class);

    @RequestMapping(value = "/initNewTopic")
    public String init(Post post,
                       Map<String, Object> map) {
//        generate timestamp for post_id
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        post.setPost_id(UUID.randomUUID().toString());
        post.setPost_time(timestamp.toString());
//        System.out.println("######################=====>#####################");
        System.out.println(post);
        postMapper.addANewPost(post);
        String post_by = post.getPost_by();
        return "redirect:/PostText/showAllTopics/" + post_by;
    }

    @RequestMapping(value = "/showAllTopics/{Fans_id}")
    public String showAllRelatedPosts(@PathVariable String Fans_id,
                                      Map<String, Object> map) {
        Integer fans_id = Integer.parseInt(Fans_id);
        PostServices postServices = new PostServices(applicationContext);
        List<Post> allPosts = postServices.showAllRelatedPosts(fans_id);
        List<Map<Post, List>> PostAndComment = new ArrayList<>();

//        这里要写每个主题的所有评论们
        for (Post p : allPosts) {
            List<Comment> temp = commentMapper.queryAllCommentUponOnePostById(p.getPost_id());
            if (p != null)
                trans(p);
            if (temp != null)
                trans2(temp);

            Map<Post, List> eachPair = new HashMap<>();
            eachPair.put(p, new ArrayList<>(temp));
            PostAndComment.add(eachPair);
        }

        map.put("PostAndComment", PostAndComment);

        return "/topics";
    }

    public void trans(Post post) {
        Integer Account_id = Integer.valueOf(post.getPost_by());
        String name = accountMapper.queryAccountInfoById(Account_id).getAccount_name();
        post.setPost_by(name);

    }

    public void trans2(List<Comment> comments) {
        for (Comment c : comments) {
            Integer Account_id = Integer.valueOf(c.getComment_by());
            String name = accountMapper.queryAccountInfoById(Account_id).getAccount_name();
            c.setComment_by(name);
        }
    }
}
