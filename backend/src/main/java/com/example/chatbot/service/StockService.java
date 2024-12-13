
package com.example.chatbot.service;

import com.example.chatbot.model.Stock;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StockService {
    private static final Map<String, List<Stock>> stockData = new HashMap<>();

    static {
        stockData.put("LSEG", Arrays.asList(
                new Stock("CRDA", "CRODA INTERNATIONAL PLC", 4807.00),
                new Stock("GSK", "GSK PLC", 1574.80),
                new Stock("ANTO", "ANTOFAGASTA PLC", 1746.00),
                new Stock("FLTR", "FLUTTER ENTERTAINMENT PLC", 16340.00),
                new Stock("BDEV", "BARRATT DEVELOPMENTS PLC", 542.60)
        ));
        stockData.put("NASDAQ", Arrays.asList(
                new Stock("AMD", "Advanced Micro Devices, Inc.", 164.21),
                new Stock("TSLA", "Tesla, Inc.", 190.35),
                new Stock("SOFI", "SoFi Technologies, Inc.", 8.24),
                new Stock("PARA", "Paramount Global", 14.92),
                new Stock("GOOGL", "Alphabet Inc.", 141.91)
        ));
        stockData.put("NYSE", Arrays.asList(
                new Stock("AHT", "Ashford Hospitality Trust", 1.72),
                new Stock("KUKE", "Kuke Music Holding Ltd", 1.20),
                new Stock("ASH", "Ashland Inc.", 93.42),
                new Stock("NMR", "Nomura Holdings Inc.", 5.84),
                new Stock("LC", "LendingClub Corp", 9.71)
        ));
    }

    public List<String> getAllExchanges() {
        return new ArrayList<>(stockData.keySet());
    }

    public List<Stock> getStocks(String exchange) {
        return stockData.getOrDefault(exchange, Collections.emptyList());
    }

    public Stock getStockDetails(String exchange, String stockCode) {
        return stockData.getOrDefault(exchange, Collections.emptyList()).stream()
                .filter(stock -> stock.getCode().equalsIgnoreCase(stockCode))
                .findFirst()
                .orElse(null);
    }
}
