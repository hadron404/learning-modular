package org.example.web;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({WebAutoConfiguration.class})
public @interface EnableWebResponseAdvice {
}
