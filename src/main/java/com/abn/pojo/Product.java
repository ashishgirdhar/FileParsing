package com.abn.pojo;

public class Product {
	
	
	private String productGroupCode;
	private String exchangeCode;
	private String symbol;
	private long exprirationDate;
	
	

	
	
	public String getProductGroupCode() {
		return productGroupCode;
	}
	public void setProductGroupCode(String productGroupCode) {
		this.productGroupCode = productGroupCode;
	}
	public String getExchangeCode() {
		return exchangeCode;
	}
	public void setExchangeCode(String exchangeCode) {
		this.exchangeCode = exchangeCode;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public long getExprirationDate() {
		return exprirationDate;
	}
	public void setExprirationDate(long exprirationDate) {
		this.exprirationDate = exprirationDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exchangeCode == null) ? 0 : exchangeCode.hashCode());
		result = prime * result + (int) (exprirationDate ^ (exprirationDate >>> 32));
		result = prime * result + ((productGroupCode == null) ? 0 : productGroupCode.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (exchangeCode == null) {
			if (other.exchangeCode != null)
				return false;
		} else if (!exchangeCode.equals(other.exchangeCode))
			return false;
		if (exprirationDate != other.exprirationDate)
			return false;
		if (productGroupCode == null) {
			if (other.productGroupCode != null)
				return false;
		} else if (!productGroupCode.equals(other.productGroupCode))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Product [productGroupCode=" + productGroupCode + ", exchangeCode=" + exchangeCode + ", symbol=" + symbol
				+ ", exprirationDate=" + exprirationDate + "]";
	}
	
	
}
