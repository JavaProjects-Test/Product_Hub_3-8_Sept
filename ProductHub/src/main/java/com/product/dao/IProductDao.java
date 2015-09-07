package com.product.dao;

import java.util.List;

import com.producthub.dto.Product;

public interface IProductDao {

	public boolean addNewProduct(Product object);

	public boolean deleteProduct(Product object);

	public boolean updateProduct(Product object);

	public List<Product> listOfProducts();
}
