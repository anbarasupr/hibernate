package entities;

import java.math.BigDecimal;

public class ProductJoin implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private BigDecimal price;
	private Integer categoryId;
	private String categoryName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public ProductJoin(Integer id, String name, BigDecimal price, Integer categoryId, String categoryName) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public ProductJoin() {
		super();
	}

}
