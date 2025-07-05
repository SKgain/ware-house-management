package com.waresafe.warehousemanagement.service;

import com.waresafe.warehousemanagement.entity.Item;
import com.waresafe.warehousemanagement.entity.Shipment;
import com.waresafe.warehousemanagement.entity.ShipmentItem;
import com.waresafe.warehousemanagement.repository.ItemRepository;
import com.waresafe.warehousemanagement.repository.ShipmentItemRepository;
import com.waresafe.warehousemanagement.repository.ShipmentRepository;
import com.waresafe.warehousemanagement.requestDTO.ShipmentItemRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShipmentItemService {
    private final ShipmentItemRepository shipmentItemRepository;
    private final ShipmentRepository shipmentRepository;
    private final ItemRepository itemRepository;

    public void addShipmentItem(
            ShipmentItemRequestDTO shipmentItemDTO
    ){
        ShipmentItem shipmentItem = new ShipmentItem();
        Shipment shipment = shipmentRepository
                .findById(shipmentItemDTO.getShipmentId())
                .orElseThrow(()->new RuntimeException("Shipment not found"));
        Item item = itemRepository
                .findById(shipmentItemDTO.getItemId())
                .orElseThrow(()->new RuntimeException("Item not found"));
        shipmentItem
                .setShipment(shipment);
        shipmentItem
                .setItem(item);
        shipmentItem
                .setQuantity(shipmentItemDTO.getQuantity());
        shipmentItemRepository
                .save(shipmentItem);

    }

    public List<ShipmentItem> getAllShipmentItem() {
        return
                shipmentItemRepository
                        .findAll();
    }

    public ShipmentItem getShipmentItem(
            int id
    ) {
        return
                shipmentItemRepository
                        .findById(id)
                        .orElseThrow(()-> new RuntimeException("ShipmentItem Not Found"));
    }

    public void updateShipmentItem(
            int id,
            ShipmentItemRequestDTO shipmentItemDTO
    ){
        ShipmentItem shipmentItem = shipmentItemRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("ShipmentItem Not Found"));
        shipmentItem
                .setQuantity(shipmentItemDTO.getQuantity());
        shipmentItemRepository
                .save(shipmentItem);
    }

    public void deleteShipmentItem(
            int id
    ){
        shipmentItemRepository
                .deleteById(id);
    }
}
