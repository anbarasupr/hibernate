package hql.orderby_clause_hql;

import java.util.List;
import entities.Product;

public class Main {

	public static void main(String[] args) {

		ProductModel productModel = new ProductModel();

		System.out.println("Sort by Price Ascending");
		System.out.println("==========================");
		List<Product> result1 = productModel.orderByAscending();
		for (Product product : result1) {
			System.out.println("Id: " + product.getId());
			System.out.println("Name: " + product.getName());
			System.out.println("Price: " + product.getPrice());
			System.out.println("----------------------");
		}

		System.out.println("Sort by Price Descending");
		System.out.println("==========================");
		List<Product> result2 = productModel.orderByDescending();
		for (Product product : result2) {
			System.out.println("Id: " + product.getId());
			System.out.println("Name: " + product.getName());
			System.out.println("Price: " + product.getPrice());
			System.out.println("----------------------");
		}

	}
}
