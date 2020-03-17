package hql.get_entities_list_hql;

import java.util.List;

import entities.Product;

public class Main {

	public static void main(String[] args) {

		ProductModel productModel = new ProductModel();
		List<Product> products = productModel.findAll();
		for(Product product : products) {
			System.out.println("Id: " + product.getId());
			System.out.println("Name: " + product.getName());
			System.out.println("Price: " + product.getPrice());
			System.out.println("=======================");
		}

	}

}