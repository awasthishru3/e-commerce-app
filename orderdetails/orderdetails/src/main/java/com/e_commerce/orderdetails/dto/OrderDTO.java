package com.e_commerce.orderdetails.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class OrderDTO {
	private Long orderId;
	private String orderDescription;
	private UserDTO userDesc;
	private Date orderDate;
	private Long quantity;
}
