package limit_hql;

import java.util.List;
import entities.Product;

public class Main {

	public static void main(String[] args) {

		ProductModel productModel = new ProductModel();
		System.out.println("Find 2 products with the biggest price");
		System.out.println("==========================");
		List<Product> products = productModel.limit(2);
		for (Product product : products) {
			System.out.println("Id: " + product.getId());
			System.out.println("Name: " + product.getName());
			System.out.println("Price: " + product.getPrice());
			System.out.println("----------------------");
		}

	}
}
