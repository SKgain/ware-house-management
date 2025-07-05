package com.waresafe.warehousemanagement.controller;

import com.waresafe.warehousemanagement.entity.Stock;
import com.waresafe.warehousemanagement.requestDTO.StockRequestDTO;
import com.waresafe.warehousemanagement.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;
    @PostMapping("/add-stock")
    public ResponseEntity<String> addStock(
            @RequestBody StockRequestDTO stockDTO
    ){
        stockService
                .addStock(stockDTO);
        return
                ResponseEntity
                        .ok("Stock added successfully");
    }
    @GetMapping("/get-all-stock")
    public List<Stock> getAllStock(){
        return
                stockService
                        .getAllStudent();
    }
    @GetMapping("/get-stock/filter/{id}")
    public Stock getStockById(
            @PathVariable int id
    ){
        return
                stockService
                        .getStockById(id);
    }
    @PutMapping("/update-stock/{id}")
    public ResponseEntity<String> updateStock(
            @PathVariable int id,
            @RequestBody StockRequestDTO stockDTO
    ){
        stockService
                .updateStock(id,stockDTO);
        return
                ResponseEntity
                        .ok("Stock updated successfully");
    }
    @DeleteMapping("/delete-stock/{id}")
    public ResponseEntity<String> deleteStock(
            @PathVariable int id
    ){
        stockService
                .deleteStock(id);
        return
                ResponseEntity
                        .ok("Stock deleted successfully");
    }
}
