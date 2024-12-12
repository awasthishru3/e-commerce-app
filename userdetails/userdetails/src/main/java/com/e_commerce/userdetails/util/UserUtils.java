package com.e_commerce.userdetails.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.e_commerce.userdetails.dto.UserDTO;
import com.e_commerce.userdetails.entity.UserEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Component
public class UserUtils {

	public UserEntity convertUserDtoToUserEntity(UserDTO userDTO) {
		return new UserEntity().builder()
				.userId(userDTO.getUserId()!= null ?userDTO.getUserId(): null)
				.userName(userDTO.getUserName())
				.userAddress(userDTO.getUserAddress())
				.phoneNumber(userDTO.getPhoneNumber())
				.userAddedDate(userDTO.getUserAddedDate()!=null?userDTO.getUserAddedDate():null)
				.build();
	}
	
	public UserDTO convertUserEntityToUserDto(UserEntity userEntity) {
		return new UserDTO().builder()
				.userId(userEntity.getUserId()!= null ?userEntity.getUserId(): null)
				.userName(userEntity.getUserName())
				.userAddress(userEntity.getUserAddress())
				.phoneNumber(userEntity.getPhoneNumber())
				.userAddedDate(userEntity.getUserAddedDate()!=null?userEntity.getUserAddedDate():null)
				.build();
	}
	

	  public static Date asDate(LocalDate localDate) {
	    return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	  }

	  public static Date asDate(LocalDateTime localDateTime) {
	    return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	  }

	  public static LocalDate asLocalDate(Date date) {
	    return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	  }

	  public static LocalDateTime asLocalDateTime(Date date) {
	    return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
	  }
}
