package com.producthub.service;

import java.util.List;

import com.product.dao.IProductDao;
import com.product.dao.ProductDaoImpl;
import com.producthub.dto.Product;

public class ProductServiceImpl implements IProductService {

	IProductDao objectProductDao = new ProductDaoImpl();

	public boolean addNewProduct(Product object) {
		boolean status = false;
		if (object.getProductName() == null
				|| object.getProductDescription() == null
				|| object.getProductPrice() == null
				|| object.getProductImage() == null) {
			return status;
		} else {
			return objectProductDao.addNewProduct(object);
		}
	}

	public boolean deleteProduct(Product object) {

		return objectProductDao.deleteProduct(object);

	}

	public boolean updateProduct(Product object) {
		boolean status = false;
		if (object.getProductName() == null
				/*|| object.getProductDescription() == null
				|| object.getProductPrice() == null
				|| object.getProductImage() == null*/) {
			return status;
		} else {
			return objectProductDao.updateProduct(object);
		}
	}

	public List<Product> listOfProducts() {

		return objectProductDao.listOfProducts();
	}

}
