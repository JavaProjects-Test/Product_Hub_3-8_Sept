package com.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.producthub.dto.Product;

public class ProductDaoImpl implements IProductDao {

	int numberOfUpdate;
	boolean status;

	public Connection getConnection() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3307/productsdb", "root", "12345");

		return connection;

	}

	public boolean addNewProduct(Product object) {
		status = false;
		Connection connection;
		try {
			connection = getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into product values(?,?,?,?,?,default,default)");
			preparedStatement.setString(1, object.getProductId());
			preparedStatement.setString(2, object.getProductName());
			preparedStatement.setString(3, object.getProductDescription());
			preparedStatement.setString(4, object.getProductPrice());
			preparedStatement.setString(5, object.getProductImage());

			numberOfUpdate = preparedStatement.executeUpdate();
			if (numberOfUpdate == 1) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean deleteProduct(Product object) {
		status = false;
		Connection connection;
		try {
			connection = getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from product where PRODUCT_ID=?");
			preparedStatement.setString(1, object.getProductId());

			numberOfUpdate = preparedStatement.executeUpdate();
			System.out.println("Execute UPDATEDD-> " + numberOfUpdate);
			if (numberOfUpdate == 1) {
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean updateProduct(Product object) {
		status = false;
		Connection connection;
		PreparedStatement preparedStatement;
		try {
			connection = getConnection();
			System.out.println("ghghhg");
			preparedStatement = connection
					.prepareStatement("UPDATE product SET PRODUCT_NAME=?, PRODUCT_DESCRIPTION=?, PRODUCT_PRICE=?, PRODUCT_IMAGE=?, MODIFIED_DATE=default where PRODUCT_ID= ?");
			preparedStatement.setString(5, object.getProductId());
			preparedStatement.setString(4, object.getProductImage());
			preparedStatement.setString(3, object.getProductPrice());
			preparedStatement.setString(2, object.getProductDescription());
			preparedStatement.setString(1, object.getProductName());

			numberOfUpdate = preparedStatement.executeUpdate();
			System.out.println("Number of Update : " + numberOfUpdate);
			if (numberOfUpdate == 1) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public List<Product> listOfProducts() {
		List<Product> list = new ArrayList<Product>();
		Connection connection;

		try {
			connection = getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from product");

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Product productList = new Product();
				productList.setProductId(resultSet.getString(1));
				productList.setProductName(resultSet.getString(2));
				productList.setProductDescription(resultSet.getString(3));
				productList.setProductPrice(resultSet.getString(4));
				productList.setProductImage(resultSet.getString(5));

				list.add(productList);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
