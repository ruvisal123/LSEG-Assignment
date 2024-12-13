
package com.example.chatbot.controller;

import com.example.chatbot.model.Stock;
import com.example.chatbot.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@CrossOrigin(origins = "*")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public List<String> getExchanges() {
        return stockService.getAllExchanges();
    }

    @GetMapping("/{exchange}")
    public List<Stock> getStocks(@PathVariable String exchange) {
        return stockService.getStocks(exchange);
    }

    @GetMapping("/{exchange}/{stockCode}")
    public Stock getStockDetails(@PathVariable String exchange, @PathVariable String stockCode) {
        return stockService.getStockDetails(exchange, stockCode);
    }
}
