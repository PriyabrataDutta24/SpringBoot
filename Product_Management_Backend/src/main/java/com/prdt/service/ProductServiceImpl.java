package com.prdt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prdt.model.Product;
import com.prdt.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public Product saveProduct(Product product) {
		
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		
		return productRepo.findById(id).get();
		
	}

	@Override
	public String deleteProduct(Integer id) {
		Product product = productRepo.findById(id).get();
		if(product !=null)
		{
			productRepo.delete(product);
			return "Product delete successfully";
		}
		return  "something wrong on server";
	}

	@Override
	public Product editProduct(Product product, Integer id) {
		
		Product oldProduct = productRepo.findById(id).get();
		
		oldProduct.setProductName(product.getProductName());
		oldProduct.setDescription(product.getDescription());
		oldProduct.setPrice(product.getPrice());
		oldProduct.setStatus(product.getStatus());
	
		
		return productRepo.save(oldProduct);
	}

}
