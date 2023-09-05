package  io.github.newpzp.blog.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.newpzp.blog.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController{

    @Autowired
    private PostService postService;

    
}