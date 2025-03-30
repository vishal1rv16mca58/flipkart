package com.flikart.inventory_service.Controller;

import com.flikart.inventory_service.dto.InventoryResponseDto;
import com.flikart.inventory_service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponseDto> isProductInStock(@RequestParam List<String> skuCode) throws InterruptedException {
          return inventoryService.isProductInStock(skuCode);
    }

}
