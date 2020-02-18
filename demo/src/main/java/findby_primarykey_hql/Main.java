package findby_primarykey_hql;

import entities.Product;

public class Main {

	public static void main(String[] args) {

		ProductModel productModel = new ProductModel();
		System.out.println("Find product with id is 6");
		Product product = productModel.find(6);
		if (product == null) {
			System.out.println("No results");
		} else {
			System.out.println("Id: " + product.getId());
			System.out.println("Name: " + product.getName());
			System.out.println("Price: " + product.getPrice());
		}

	}

}
