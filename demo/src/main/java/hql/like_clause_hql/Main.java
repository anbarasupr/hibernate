package hql.like_clause_hql;

import java.util.List;
import entities.Product;

public class Main {

	public static void main(String[] args) {

		ProductModel productModel = new ProductModel();

		System.out.println("Start with mob string");
		System.out.println("==========================");
		List<Product> result1 = productModel.startsWith("mob");
		for (Product product : result1) {
			System.out.println("Id: " + product.getId());
			System.out.println("Name: " + product.getName());
			System.out.println("Price: " + product.getPrice());
			System.out.println("----------------------");
		}

		System.out.println("Ends with top 1 string");
		System.out.println("==========================");
		List<Product> result2 = productModel.endsWith("top 1");
		for (Product product : result2) {
			System.out.println("Id: " + product.getId());
			System.out.println("Name: " + product.getName());
			System.out.println("Price: " + product.getPrice());
			System.out.println("----------------------");
		}

		System.out.println("Contains bi string");
		System.out.println("==========================");
		List<Product> result3 = productModel.contains("bi");
		for (Product product : result3) {
			System.out.println("Id: " + product.getId());
			System.out.println("Name: " + product.getName());
			System.out.println("Price: " + product.getPrice());
			System.out.println("----------------------");
		}

	}

}
