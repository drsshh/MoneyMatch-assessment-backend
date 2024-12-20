package com.MoneyMatch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MoneyMatchAppTests {
    @Autowired
    private ApplicationContext context;

    @Test
    public void contextLoads() {
        assertThat(context).isNotNull();
    }
}
