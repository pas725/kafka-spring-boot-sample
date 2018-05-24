package com.example.kafka;

import com.example.kafka.producer.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaStarterApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(KafkaStarterApplication.class, args);
	}

	@Autowired
	Sender sender;

	@Override
	public void run(String... strings) throws Exception {
		new Worker(sender).start();
	}
}

class Worker extends Thread {
	private Sender sender;
	private String[] data = {"Spring", "Kafka", "Producer", "and", "Consumer", "Example"};
	public Worker(Sender sender) {
		this.sender = sender;
	}
	public void run() {
		int n = data.length;
		try {
			while (true) {
				String msg = data[(int) (Math.random() * n)];
				sender.send(msg);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			System.out.println("Exception ....");
		}
	}
}