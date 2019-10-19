package com.github.apz.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;

@Configuration
@Component
@ConfigurationProperties(prefix = "cloud")
@Data
public class CloudConfig {

	private PubSub pubsub;

	@Data
	public static class PubSub {

		private String baseurl;
		private Topic topic;
		private Subscribe subscribe;

		@Data
		public static class Topic {
			private String endpoint;
		}

		@Data
		public static class Subscribe {
			private String endpoint;
		}

	}
}
