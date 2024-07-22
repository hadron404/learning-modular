package org.example.rest;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {
	private ServerProperties user = new ServerProperties();
	private ServerProperties order = new ServerProperties();

	public ServerProperties getOrder() {
		return order;
	}

	public void setOrder(ServerProperties order) {
		this.order = order;
	}

	public ServerProperties getUser() {
		return user;
	}

	public void setUser(ServerProperties user) {
		this.user = user;
	}

	public static class ServerProperties {
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




