package pl.aplikacja.bot.botApi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class WebSecurityTest {

    @LocalServerPort
    private int port;
    private final TestRestTemplate restTemplate = new TestRestTemplate().withBasicAuth("client-id", "client-secret");

    @Autowired
    private MockMvc mockMvc;


    @Test
    @WithMockUser(username = "user", roles = "USER")
    void test_access_to_protected_resource_with_authenticated_user() {
        String testApiUrl = "/testApi";
        String url = "http://localhost:" + port + testApiUrl;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.FOUND);
    }

    @Test
    void test_access_to_test_api_without_authentication() throws Exception {
        mockMvc.perform(get("/testApi"))
                .andExpect(status().isUnauthorized());
    }
}
