package com.sls.sample.action;

import java.math.BigDecimal;

import com.opensymphony.xwork2.ActionSupport;
import com.sls.sample.entity.Product;

public class ConverterTestAction extends ActionSupport{

	private Product product;
	
	public String execute(){
		if(product != null && product.getPrice() != null){
			for(BigDecimal decimal : product.getPrice()){
				System.out.println(decimal);
			}
		}
		return SUCCESS;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
