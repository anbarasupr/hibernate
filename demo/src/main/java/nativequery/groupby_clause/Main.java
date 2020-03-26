package nativequery.groupby_clause;                                                             
import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) {

		ProductModel productModel = new ProductModel();
		for (Object[] productGroup : productModel.groupBy()) {
			int categoryId = Integer.parseInt(productGroup[0].toString());
			System.out.println("Category Id: " + categoryId);
			Long sumQuantity = Long.parseLong(productGroup[1].toString());
			System.out.println("Sum Quantity: " + sumQuantity);
			BigDecimal maxPrice = BigDecimal.valueOf(Double.parseDouble(productGroup[2].toString()));
			System.out.println("Max Price: " + maxPrice);
			BigDecimal minPrice = BigDecimal.valueOf(Double.parseDouble(productGroup[3].toString()));
			System.out.println("Min Price: " + minPrice);
			Long countProduct = Long.parseLong(productGroup[4].toString());
			System.out.println("Count Product: " + countProduct);
			Double avgPrice = Double.parseDouble(productGroup[5].toString());
			System.out.println("Avg Price: " + avgPrice);
			System.out.println("=========================");
		}
	}

}
