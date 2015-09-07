package com.producthub.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import com.producthub.dto.Product;
import com.producthub.service.IProductService;
import com.producthub.service.ProductServiceImpl;

public class ProductMain {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Product productObject = new Product();
		IProductService objectProductService = new ProductServiceImpl();
		boolean status;
		while (true) {
			System.out.println("What do you want: ");
			System.out.println("1. Add New Product");
			System.out.println("2. Delete Product");
			System.out.println("3. Update Product");
			System.out.println("4. List of all Products");
			System.out.println("5. Exit");
			System.out.println("Enter Your Choice:");
			int choice;
			try {
				choice = Integer.parseInt(br.readLine());
				if (choice == 5) {
					System.out.println("Thanks!!");
					break;
				} else if (choice < 1 || choice > 5) {
					System.out.println("Number should be between 1 and 5");
				}
				switch (choice) {
				case 1: {
					System.out.println("Enter Product ID:");
					productObject.setProductId(br.readLine());
					System.out.println("Enter Product Name:");
					productObject.setProductName(br.readLine());
					System.out.println("Enter Product Description");
					productObject.setProductDescription(br.readLine());
					System.out.println("Enter Product Price");
					productObject.setProductPrice(br.readLine());
					System.out.println("Enter Product Image");
					productObject.setProductImage(br.readLine());

					status = objectProductService.addNewProduct(productObject);
					if (status) {
						System.out.println();
						System.out.println("Product added Successfully!!");
						System.out.println();
					} else {
						System.out.println();
						System.out.println("No Product Added!!");
						System.out.println();
					}
					break;
				}

				case 2: {

					System.out.println("Enter Product ID");
					productObject.setProductId(br.readLine());

					status = objectProductService.deleteProduct(productObject);
					if (status) {
						System.out.println();
						System.out.println("Deleted Successfully!!");
						System.out.println();
					} else {
						System.out.println();
						System.out.println("Product ID is not valid!!");
						System.out.println();
					}
					break;
				}

				case 3: {

					System.out.println("Enter Product ID:");
					productObject.setProductId(br.readLine());

					System.out.println("Enter Product Name:");
					productObject.setProductName(br.readLine());

					System.out.println("Enter Product Description");
					productObject.setProductDescription(br.readLine());
					System.out.println("Enter Product Price");
					productObject.setProductPrice(br.readLine());
					System.out.println("Enter Product Image");
					productObject.setProductImage(br.readLine());

					status = objectProductService.updateProduct(productObject);
					if (status) {
						System.out.println();
						System.out.println("Product updated Successfully!!");
						System.out.println();
					} else {
						System.out.println();
						System.out.println("No Product updated!!");
						System.out.println();
					}
					break;
				}

				case 4: {
					List<Product> listOfProducts = objectProductService
							.listOfProducts();
					Iterator<Product> itr = listOfProducts.iterator();
					while (itr.hasNext()) {
						Product productList = itr.next();
						System.out.println("Product ID: "
								+ productList.getProductId());
						System.out.println("Product Name: "
								+ productList.getProductName());
						System.out.println("Product Description: "
								+ productList.getProductDescription());
						System.out.println("Product Price: "
								+ productList.getProductPrice());
						System.out.println("Product Image: "
								+ productList.getProductImage());
						System.out.println();
					}

				}

				}
			} catch (NumberFormatException e) {
				System.err.println("Only Numbers are Allowed!!");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
