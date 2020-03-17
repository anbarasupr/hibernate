package hql.join_hql;

import entities.ProductJoin;

public class Main {

	public static void main(String[] args) {

		ProductModel productModel = new ProductModel();
		for (ProductJoin productJoin : productModel.join()) {
			System.out.println("Id: " + productJoin.getId());
			System.out.println("Name: " + productJoin.getName());
			System.out.println("Price: " + productJoin.getPrice());
			System.out.println("Category Id: " + productJoin.getCategoryId());
			System.out.println("Category Name: " + productJoin.getCategoryName());
			System.out.println("==================");
		}
	}

}
