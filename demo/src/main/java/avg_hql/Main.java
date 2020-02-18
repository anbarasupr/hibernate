package avg_hql;

public class Main {

	public static void main(String[] args) {

		ProductModel productModel = new ProductModel();
		System.out.println("Sum Quantities: " + productModel.sumQuantities());
		System.out.println("Total: " + productModel.total());

	}

}
