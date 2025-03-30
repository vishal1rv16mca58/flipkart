package com.flikart.inventory_service;

import com.flikart.inventory_service.Repository.InventoryRepository;
import com.flikart.inventory_service.entity.Inventory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository)
	{
		return args -> {
			Inventory inventory1=new Inventory();
			inventory1.setSkuCode("iphone_13");
			inventory1.setQuantity(100);

			Inventory inventory2=new Inventory();
			inventory2.setSkuCode("iphone_13_pink");
			inventory2.setQuantity(0);

			inventoryRepository.save(inventory1);
			inventoryRepository.save(inventory2);
		};
	}
}
