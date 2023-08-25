package io.github.newpzp.blog.mappertest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import io.github.newpzp.blog.domain.mapper.UserMapper;
import io.github.newpzp.blog.domain.entity.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void crudTest() {
        // Create
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("testPassword");
        user.setEmail("test@email.com");
        assertEquals(1, userMapper.insert(user));

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
}
