package com.example.DivineCuisine.security;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class SecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testMenuRoute() throws Exception {
        mockMvc.perform(get("/menu"))
                .andExpect(status().isOk());
    }
    @Test
    public void testLoginRoute() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk());
    }
    @Test
    public void testIndexRoute() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }
}


