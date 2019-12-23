package com.service.victoria.controllers;

import com.service.victoria.ChildrenGameApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ChildrenGameApplication.class)
@AutoConfigureMockMvc
class GameControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testHealthCheckEndpoint() throws Exception {
        mvc.perform(get("/healthCheck"))
                .andExpect(status().isOk())
                .andExpect(content().string("Children Game Endpoint is up and running ! Enjoy the game"));
    }

    @Test
    public void test_Children_Game_Without_Parameters() throws Exception {
        mvc.perform(get("/game")) // test with default parameters 5 & 6 when not passed
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(4)));
    }

    @Test
    public void test_Children_Game_With_Parameters() throws Exception {
        String url = getUrl(5, 4);
        mvc.perform(get(url)) // test with default parameters 5 & 6 when not passed
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(1)));
    }

    private String getUrl(int noOfChildren, int counter) {
        return "/game?noOfChildren="+noOfChildren+"&counter="+counter;
    }

}

