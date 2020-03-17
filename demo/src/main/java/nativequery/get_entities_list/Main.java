package nativequery.get_entities_list;

import entities.*;

public class Main {

	public static void main(String[] args) {

		ProductModel productModel = new ProductModel();
		for (Product product : productModel.findAll()) {
			System.out.println("Id: " + product.getId());
			System.out.println("Name: " + product.getName());
			System.out.println("Price: " + product.getPrice());
			System.out.println("=======================");
		}
	}

}
