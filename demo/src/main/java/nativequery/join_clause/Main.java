package nativequery.join_clause;

import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) {

		ProductModel productModel = new ProductModel();
		for (Object[] productJoin : productModel.join()) {
			int productId = Integer.parseInt(productJoin[0].toString());
			System.out.println("Id: " + productId);
			String productName = productJoin[1].toString();
			System.out.println("Name: " + productName);
			BigDecimal price = BigDecimal.valueOf(Double.parseDouble(productJoin[2].toString()));
			System.out.println("Price: " + price);
			int categoryId = Integer.parseInt(productJoin[3].toString());
			System.out.println("Category Id: " + categoryId);
			String categoryName = productJoin[4].toString();
			System.out.println("Category Name: " + categoryName);
			System.out.println("=========================");
		}
	}

}
