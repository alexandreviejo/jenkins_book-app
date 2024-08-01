package daaw.book_app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import daaw.book_app.controllers.BookController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BookController controller;

    @Test
    public void bookControllerContexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void bookControllerFindAllWorks() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/books",
                String.class)).contains("To Kill a Mockingbird", "Harper");
    }
}
