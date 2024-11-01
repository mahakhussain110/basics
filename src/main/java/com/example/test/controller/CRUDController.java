package com.example.test.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/items")
public class CRUDController {
    // In-memory storage for demonstration purposes
    private Map<Integer, String> itemStore = new HashMap<>();
    private int currentId = 1;

    @GetMapping
    public List<Map.Entry<Integer, String>> getAllItems() {
        return new ArrayList<>(itemStore.entrySet());
    }

    @PostMapping(value = "/saveItem", produces = "application/json", consumes = "application/json")
    public Map<String, Object> addItem(@RequestBody String itemName) {
        itemStore.put(currentId, itemName);
        Map<String, Object> response = new HashMap<>();
        response.put("id", currentId);
        response.put("name", itemName);
        currentId++;
        return response;
    }

}
