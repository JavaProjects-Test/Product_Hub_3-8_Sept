package com.producthub.service;

import java.util.List;

import com.producthub.dto.Product;

public interface IProductService {

	public boolean addNewProduct(Product object);

	public boolean deleteProduct(Product object);

	public boolean updateProduct(Product object);

	public List<Product> listOfProducts();

}
