package com.e_commerce.orderdetails.entity;

import java.util.Date;

import com.e_commerce.orderdetails.dto.UserDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Order")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	private String orderDescription;
	private UserDTO userDesc;
	private Date orderDate;
	private Long quantity;
}
