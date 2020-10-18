package pl.redheadsolutions.lg.lets.vote.gateway.cucumber;

import io.cucumber.java.Before;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.redheadsolutions.lg.lets.vote.gateway.LetsVoteGatewayApp;

@SpringBootTest
@WebAppConfiguration
@ContextConfiguration(classes = LetsVoteGatewayApp.class)
public class CucumberContextConfiguration {

    @Before
    public void setup_cucumber_spring_context() {
        // Dummy method so cucumber will recognize this class as glue
        // and use its context configuration.
    }
}
