package org.example.web;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "web")
public class WebProperties {

	private ResponseProperties response = new ResponseProperties(false);

	public ResponseProperties getResponse() {
		return response;
	}

	public void setResponse(ResponseProperties response) {
		this.response = response;
	}

	public record ResponseProperties(boolean enabled) {
	}
}




