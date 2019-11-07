package com.github.apz.cloud;

import java.util.ArrayList;
import java.util.List;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.ProjectTopicName;
import com.google.pubsub.v1.PubsubMessage;

public class PubSubSample {

	public static void main(String[] args) throws Exception {

		String topicId = "item-transfer-topic";
		int messageCount = 5;
		ProjectTopicName topicName = ProjectTopicName.of("chain-pack", topicId);
		Publisher publisher = null;
		List<ApiFuture<String>> futures = new ArrayList<>();

		try {
			// Create a publisher instance with default settings bound to the topic
			publisher = Publisher.newBuilder(topicName).build();

			for (int i = 0; i < messageCount; i++) {
				String message = "message-" + i;

				// convert message to bytes
				ByteString data = ByteString.copyFromUtf8(message);
				PubsubMessage pubsubMessage = PubsubMessage.newBuilder()
						.setData(data)
						.build();

				// Schedule a message to be published. Messages are automatically batched.
				ApiFuture<String> future = publisher.publish(pubsubMessage);
				futures.add(future);
			}
		} finally {
			// Wait on any pending requests
			List<String> messageIds = ApiFutures.allAsList(futures).get();

			for (String messageId : messageIds) {
				System.out.println(messageId);
			}

			if (publisher != null) {
				// When finished with the publisher, shutdown to free up resources.
				publisher.shutdown();
			}
		}
	}

	// topic id, eg. "my-topic"

}
