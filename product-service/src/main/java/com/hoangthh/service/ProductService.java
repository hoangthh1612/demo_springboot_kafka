package com.hoangthh.service;

import com.hoangthh.dto.ProductBody;
import com.hoangthh.entity.Product;
import com.hoangthh.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;



    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public boolean checkAvailability(ProductBody productBody) {
        Product product = productRepository.findById(productBody.getProductId()).orElse(null);
        if (product == null) {
            return false;
        }
        if(productBody.getQuantity() > product.getQuantity()) {
            return false;
        }
        Long restQuantity = product.getQuantity() - productBody.getQuantity();
        product.setQuantity(restQuantity);
        productRepository.save(product);
        return true;
    }
//    public Double calculateTotalPrice(List<Map<String, Integer>> itemOrders) {
//        Double totalPrice = 0.0;
//        for(Map<String, Integer> itemOrder : itemOrders) {
//            Long id = Long.valueOf(itemOrder.get("id"));
//            Long quantity = Long.valueOf(itemOrder.get("quantity"));
//            Optional<Product> product = productRepository.findById(id);
//            double price = product.get().getPrice();
//            totalPrice += price * quantity;
//            product.get().setQuantity(product.get().getQuantity() - quantity);
//            productRepository.save(product.get());
//        }
//        return totalPrice;
//    }

//    public Map<String, Object> checkAvailability(Map<String, ?> orderInfo) {
//        System.out.println(orderInfo.get("itemOrders"));
//
//        List<Map<String, Integer>> itemOrders = (ArrayList<Map<String, Integer>>)orderInfo.get("itemOrders");
//
//        boolean isAvailable = isCheckAvailability(itemOrders);
//        Map<String, Object> result = new HashMap<>();
//        if(!isAvailable) {
//            result.put("isAvailability", false);
//            return result;
//        }
//
//        double totalPrice = calculateTotalPrice(itemOrders);
//
//        result.put("isAvailability", true);
//        result.put("totalPrice", totalPrice);
//
//        return result;
//    }
}
