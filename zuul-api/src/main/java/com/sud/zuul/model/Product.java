package com.sud.zuul.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private long id;
	private String adminId;
	private String name;
	private String status;
	private String price;
	private String imageUri;
	private String category;
	private String detail;
}
