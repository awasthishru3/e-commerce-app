package com.e_commerce.userdetails.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class UserDTO {
	private Long userId;
	private String userName;
	private String userAddress;
	private Long phoneNumber;
	private Date userAddedDate;
}
