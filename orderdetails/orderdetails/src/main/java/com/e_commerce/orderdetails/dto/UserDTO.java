package com.e_commerce.orderdetails.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDTO {
	private Long userId;
	private String userName;
	private String userAddress;
	private Long phoneNumber;
	private Date userAddedDate;
}
