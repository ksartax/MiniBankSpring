package java.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Damian Stępniak on 31.03.2017.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "java")
public class AppConfig {



}