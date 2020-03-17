package hql.min_max_hql;

public class Main {

	public static void main(String[] args) {

		ProductModel productModel = new ProductModel();
		System.out.println("The biggest price: " + productModel.max());
		System.out.println("The smallest price: " + productModel.min());
	}

}
