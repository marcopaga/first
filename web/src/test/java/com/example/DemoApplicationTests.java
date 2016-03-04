package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.OutputCapture;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
public class DemoApplicationTests {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();
    private DemoApplication demoApplication = new DemoApplication();

    @Test
    public void contextLoads() {
    }


    @Test
    public void shouldLogInfoOnStart() throws Exception {
        demoApplication.sample();

        assertThat(outputCapture.toString(), is(containsString("The value of the entity: 'Value'")));
    }
}
