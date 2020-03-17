package hql.call_sp_with_parameters_hql;

import java.math.BigDecimal;
import java.util.List;
import entities.*;

public class Main {

	public static void main(String[] args) {

		ProductModel productModel = new ProductModel();
		List<Product> products = productModel.between(BigDecimal.valueOf(5), BigDecimal.valueOf(10));
		for (Product product : products) {
			System.out.println("Id: " + product.getId());
			System.out.println("Name: " + product.getName());
			System.out.println("Price: " + product.getPrice());
			System.out.println("=======================");
		}
	}

}
