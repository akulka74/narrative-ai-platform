package com.narrative.ingestorservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@SpringBootApplication
@RestController
public class IngestorServiceApplication {

	@Autowired
	private StreamBridge streamBridge;

	public static void main(String[] args) {
		SpringApplication.run(IngestorServiceApplication.class, args);
	}

	@PostMapping("/ingest")
	public String ingest(@RequestBody Map<String, String> payload) {
		String headline = payload.get("headline");

		// Wrap the data in a simple Map to send as JSON
		Map<String, Object> event = Map.of(
				"id", UUID.randomUUID().toString(),
				"headline", headline,
				"timestamp", System.currentTimeMillis()
		);

		// Send to the destination 'news-out-0' defined in our properties
		streamBridge.send("news-out-0", event);

		return "Lead, the event is in the pipe: " + headline;
	}
}