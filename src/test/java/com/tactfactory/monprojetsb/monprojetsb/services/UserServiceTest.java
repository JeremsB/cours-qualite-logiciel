package com.tactfactory.monprojetsb.monprojetsb.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.tactfactory.monprojetsb.monprojetsb.entities.Product;
import com.tactfactory.monprojetsb.monprojetsb.entities.User;
import com.tactfactory.monprojetsb.monprojetsb.repositories.UserRepository;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@EntityScan(basePackages="com.tactfactory.monprojetsb")
@ComponentScan(basePackages="com.tactfactory.monprojetsb")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    /**
     * Test insertion element
     */
    @Test
    public void TestInsertOne() {
        Long before = userRepository.count();
        userService.save(new User());
        Long after = userRepository.count();

        assertEquals(before + 1, after);
    }

    @Test
    public void TestInsertUser() {
        User userBase = new User((long) 10, "Bobba", "Bobby", new ArrayList<Product>());
        Long id = userService.save(userBase).getId();
        User userFetch = userRepository.getOne(id);
        assertEquals(userFetch.getFirstname(), userBase.getFirstname());
        assertEquals(userFetch.getLastname(), userBase.getLastname());
        assertEquals(userFetch.getProducts(), userBase.getProducts());
    }

    @Test
    public void test4() {

    }

    @Test
    public void test5() {

    }

    @Test
    public void test6() {

    }

    @Test
    public void TestDeleteUser() {
        User userTemp = new User();
        userService.save(userTemp);
        Long before = userRepository.count();
        userService.delete(userTemp);
        Long after = userRepository.count();

        assertEquals(before - 1, after);
    }

    @Test
    public void Test8() {

    }

}
