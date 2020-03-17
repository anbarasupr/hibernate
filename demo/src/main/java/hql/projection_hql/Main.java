package hql.projection_hql;

import entities.ProductEntity;

public class Main {

	public static void main(String[] args) {

		ProductModel productModel = new ProductModel();

		for (ProductEntity productEntity : productModel.projection()) {
			System.out.println("Id: " + productEntity.getId());
			System.out.println("Name: " + productEntity.getName());
			System.out.println("Price: " + productEntity.getPrice());
			System.out.println("=======================");
		}

	}

}
