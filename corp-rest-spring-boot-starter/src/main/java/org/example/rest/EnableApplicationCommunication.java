package org.example.rest;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ApplicationAutoConfiguration.class})
@EnableFeignClients
public @interface EnableApplicationCommunication {
}
