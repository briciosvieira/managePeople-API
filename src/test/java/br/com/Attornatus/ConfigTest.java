package br.com.Attornatus;

import org.junit.Before;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.context.WebApplicationContextServletContextAwareProcessor;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class ConfigTest {

    protected MockMvc mockMvc;

    protected WebApplicationContext context;

    @Before
    public void prepare(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }
}
