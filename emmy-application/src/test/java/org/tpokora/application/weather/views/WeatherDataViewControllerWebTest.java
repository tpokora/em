package org.tpokora.application.weather.views;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {WeatherDataViewController.class} )
class WeatherDataViewControllerWebTest {

    @Autowired
    WeatherDataViewController weatherDataViewController;

    @Test
    void contextLoads() throws Exception {
        assertThat(weatherDataViewController).isNotNull();
    }
}