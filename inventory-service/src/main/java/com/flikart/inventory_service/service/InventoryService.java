package com.flikart.inventory_service.service;

import com.flikart.inventory_service.Repository.InventoryRepository;
import com.flikart.inventory_service.dto.InventoryResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventoryService {
    
    @Autowired
    private InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)

    public List<InventoryResponseDto> isProductInStock(List<String> skuCode) throws InterruptedException {
       return inventoryRepository.findBySkuCodeIn(skuCode)
               .stream()
               .map(inventory->
                   new InventoryResponseDto(inventory.getSkuCode(),inventory.getQuantity()>0)).toList();
    }
    
}
