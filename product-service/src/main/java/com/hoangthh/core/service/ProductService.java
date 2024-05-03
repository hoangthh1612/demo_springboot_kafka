package com.hoangthh.core.service;

import com.hoangthh.api.dto.request.ProductBodyRequest;
import com.hoangthh.core.domain.ProductBody;
import com.hoangthh.core.domain.ProductCore;
import com.hoangthh.infra.repository.db.entity.Product;
import com.hoangthh.infra.repository.db.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {


    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    private final ProductProducer productProducer;

    public List<ProductCore> getAllProducts() {
        return productProducer.getAllProducts();
    }

    public ProductCore save(ProductCore productCore) {
        return productProducer.save(productCore);
    }
//
    public boolean checkAvailability(ProductBody productBody) {
        Optional<ProductCore> product = productProducer.findById(productBody.getProductId());
        //log.info(product.toString());
        if(product.isPresent()) {
            //System.out.println(product.get().getQuantity());
            Long restQuantity = product.get().getQuantity() - productBody.getQuantity();
            if(restQuantity < 0)  return false;


        product.get().setQuantity(restQuantity);
        productProducer.save(product.get());
            return true;
        }
        return false;


    }

}
