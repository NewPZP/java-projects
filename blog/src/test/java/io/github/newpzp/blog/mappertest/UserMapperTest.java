package io.github.newpzp.blog.mappertest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import io.github.newpzp.blog.domain.mapper.PostMapper;
import io.github.newpzp.blog.domain.mapper.UserMapper;
import io.github.newpzp.blog.service.PostService;
import io.github.newpzp.blog.domain.dto.CreatePostDTO;
import io.github.newpzp.blog.domain.entity.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PostService postService;

    @Test
    public void crudTest() {
        // Create
        // User user = new User();
        // user.setUsername("testUser");
        // user.setPassword("testPassword");
        // user.setEmail("test@email.com");
        // assertEquals(1, userMapper.insert(user));

        // Read
        // User retrievedUser = userMapper.findByUsername("testUser");
        // assertNotNull(retrievedUser);
        // assertEquals(user.getUsername(), retrievedUser.getUsername());

        // // Update
        // retrievedUser.setUsername("updatedUser");
        // assertEquals(1, userMapper.update(retrievedUser));

        // User updatedUser = userMapper.findByUsername("updatedUser");
        // assertNotNull(updatedUser);

        // // Delete
        // assertEquals(1, userMapper.delete(updatedUser.getId()));
        // assertNull(userMapper.findById(updatedUser.getId()));
    }
    @Test
    public void testInsertPost() {

        CreatePostDTO createPostDTO =  CreatePostDTO.builder()
                                        .title("testTitle")
                                        .content("testContent")
                                        .build();
        postService.createPost(createPostDTO);
        

    }

}
