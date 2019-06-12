package com.thehecklers.thingtwo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class ThingTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThingTwoApplication.class, args);
	}

}

@EnableBinding(Sink.class)
class CoffeeCatcher {
//	@StreamListener(Sink.INPUT)
//	void drinkIt(Coffee coffee) {
//		System.out.println(coffee);
//	}

	@Bean
	Consumer<Coffee> drinkIt() {
		return System.out::println;
	}
}

@Data
@AllArgsConstructor
class Coffee {
	private final String id, name;
}