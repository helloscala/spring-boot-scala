package me.yangbajing.springscala.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Yang Jing (yangbajing@gmail.com) on 2016-03-04.
 */
@Configuration
public class BootConfig {

    @Bean
    AsyncRestTemplate asyncRestTemplate() {
        AsyncRestTemplate restTemplate = new AsyncRestTemplate();
        List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));
        ObjectMapper mapper = JsonHelpers.createObjectMapper();
        converter.setObjectMapper(mapper);
        converters.add(converter);
        restTemplate.setMessageConverters(converters);

        return restTemplate;
    }

    @Bean
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));
        ObjectMapper mapper = JsonHelpers.createObjectMapper();
        converter.setObjectMapper(mapper);
        converters.add(converter);
        restTemplate.setMessageConverters(converters);

        return restTemplate;
    }

}
