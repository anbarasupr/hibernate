package hql.groupby_clause_hql;

import entities.*;

public class Main {

	public static void main(String[] args) {

		ProductModel productModel = new ProductModel();

		for (CategoryGroup categoryGroup : productModel.group()) {
			System.out.println("Category Id: " + categoryGroup.getCategoryId());
			System.out.println("Min Price: " + categoryGroup.getMinPrice());
			System.out.println("Max Price: " + categoryGroup.getMaxPrice());
			System.out.println("Sum Quantity: " + categoryGroup.getSumQuantity());
			System.out.println("Count Product: " + categoryGroup.getCountProduct());
			System.out.println("Avg Price: " + categoryGroup.getAvgPrice());
			System.out.println("=======================================");
		}

	}

}
