package entities;

import java.math.BigDecimal;

public class CategoryGroup {

	private Integer categoryId;
	private BigDecimal minPrice;
	private BigDecimal maxPrice;
	private Long sumQuantity;
	private Long countProduct;
	private Double avgPrice;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public BigDecimal getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}

	public BigDecimal getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Long getSumQuantity() {
		return sumQuantity;
	}

	public void setSumQuantity(Long sumQuantity) {
		this.sumQuantity = sumQuantity;
	}

	public Long getCountProduct() {
		return countProduct;
	}

	public void setCountProduct(Long countProduct) {
		this.countProduct = countProduct;
	}

	public Double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(Double avgPrice) {
		this.avgPrice = avgPrice;
	}

	public CategoryGroup(Integer categoryId, BigDecimal minPrice, BigDecimal maxPrice, Long sumQuantity,
			Long countProduct, Double avgPrice) {
		this.categoryId = categoryId;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.sumQuantity = sumQuantity;
		this.countProduct = countProduct;
		this.avgPrice = avgPrice;
	}

	public CategoryGroup() {
	}

}
