package ind.awhic.nouvites.service.controller;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ArticlesControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private TestRestTemplate template;

    @Test
    public void getGreetingMvc() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/version").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("NouVites version 0.1.0")));
    }

    @Test
    public void getGreetingRest() {
        ResponseEntity<String> response = template.getForEntity("/v1/version", String.class);
        assertThat(response.getBody()).isEqualTo("NouVites version 0.1.0");
    }
}