package org.sfs.service;

import java.time.Duration;
import java.util.Random;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.mutiny.Multi;

@ApplicationScoped
public class ProduceService {

	
	private final Random random = new Random();

    @Outgoing("sfs")
    public Multi<String> generate() {
        // Build an infinite stream of random prices
        // It emits a price every second
        return Multi.createFrom().ticks().every(Duration.ofSeconds(1))
            .map(x -> "valor"+String.valueOf(random.nextDouble()));
    }}
