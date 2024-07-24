package org.example.web.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Resource;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.annotation.Annotation;
import java.util.Objects;

@RestControllerAdvice
public class CustomizeResponseBodyAdvice implements ResponseBodyAdvice<Object> {

	@Resource
	private ObjectMapper objectMapper;
	private static final Class<? extends Annotation> ANNOTATION_TYPE = RequestMapping.class;

	@Override
	public boolean supports(MethodParameter returnType, @Nonnull Class<? extends HttpMessageConverter<?>> converterType) {
		return AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), ANNOTATION_TYPE)
			|| returnType.hasMethodAnnotation(ANNOTATION_TYPE);
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType,
		@Nonnull MediaType selectedContentType, @Nonnull Class<? extends HttpMessageConverter<?>> selectedConverterType,
		@Nonnull ServerHttpRequest request, @Nonnull ServerHttpResponse response) {
		Class<?> returnClass = returnType.getMethod().getReturnType();
		if (body instanceof String || Objects.equals(returnClass, String.class)) {
			String value = null;
			try {
				value = objectMapper.writeValueAsString(CustomizeResponseEntity.ok(body));
				return value;
			} catch (JsonProcessingException e) {
				// todo 进行异常封装
				throw new RuntimeException(e);
			}
		}
		// 防止重复包裹的问题出现
		if (body instanceof CustomizeResponseEntity) {
			return body;
		}
		return CustomizeResponseEntity.ok(body);
	}
}
