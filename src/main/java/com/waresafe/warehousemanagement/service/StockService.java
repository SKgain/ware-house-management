package com.waresafe.warehousemanagement.service;

import com.waresafe.warehousemanagement.entity.Item;
import com.waresafe.warehousemanagement.entity.Stock;
import com.waresafe.warehousemanagement.entity.Warehouse;
import com.waresafe.warehousemanagement.repository.ItemRepository;
import com.waresafe.warehousemanagement.repository.StockRepository;
import com.waresafe.warehousemanagement.repository.WarehouseRepository;
import com.waresafe.warehousemanagement.requestDTO.StockRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;
    private final ItemRepository itemRepository;
    private final WarehouseRepository warehouseRepository;
    public void addStock(
            StockRequestDTO stockDTO
    ){
        Stock stock = new Stock();
        Item item = itemRepository
                .findById(stockDTO.getItemId())
                .orElseThrow(()-> new RuntimeException("Item Not Found"));

        Warehouse warehouse = warehouseRepository
                .findById(stockDTO.getWarehouseId())
                .orElseThrow(()-> new RuntimeException("Warehouse Not Found"));
        stock
                .setQuantity(stockDTO.getQuantity());
        stock
                .setItem(item);
        stock
                .setWarehouse(warehouse);
        stockRepository
                .save(stock);
    }

    public List<Stock> getAllStudent() {

        return stockRepository
                .findAll();
    }

    public Stock getStockById(
            int id
    ){
        return
                stockRepository
                        .findById(id)
                        .orElseThrow(()-> new RuntimeException("Stock Not Found"));
    }

    public void updateStock(
            int id,
            StockRequestDTO stockDTO
    ) {
        Stock stock  =  stockRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Stock Not Found"));
        stock
                .setQuantity(stockDTO.getQuantity());
        stockRepository
                .save(stock);
    }

    public void deleteStock(
            int id
    ){
        Stock stock = stockRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Stock Not Found"));
        stockRepository
                .delete(stock);
    }
}
