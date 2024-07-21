package org.example.rest;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "svc")
public class ServiceProperties {
	private URL user = new URL();
	private URL order = new URL();

	public URL getOrder() {
		return order;
	}

	public void setOrder(URL order) {
		this.order = order;
	}

	public URL getUser() {
		return user;
	}

	public void setUser(URL user) {
		this.user = user;
	}

	public static class URL {
		private String host;
		private String path;
		private int port = 80;

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

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

		public String toURL() {
			return this.host + ":" + this.port + "/" + this.path;
		}
	}
}




