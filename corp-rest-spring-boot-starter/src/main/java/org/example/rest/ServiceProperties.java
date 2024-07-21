package org.example.rest;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "svc")
public class ServiceProperties {
	private URL user = new URL();

	public URL getUser() {
		return user;
	}

	public void setUser(URL user) {
		this.user = user;
	}

	public static class URL {
		private String host;
		private int port = 80;

		public String getHost() {
			return host;
		}

		public void setHost(String host) {
			this.host = host;
		}

		public int getPort() {
			return port;
		}

		public void setPort(int port) {
			this.port = port;
		}
	}
}




