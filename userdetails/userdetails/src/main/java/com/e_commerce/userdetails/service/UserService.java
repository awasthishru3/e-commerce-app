package com.e_commerce.userdetails.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_commerce.userdetails.dao.UserRepository;
import com.e_commerce.userdetails.dto.UserDTO;
import com.e_commerce.userdetails.entity.UserEntity;
import com.e_commerce.userdetails.util.UserUtils;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserUtils util;

	public UserDTO saveUserDetails(UserDTO userDto) {
		LocalDate localDate = LocalDate.now();
		Date date = util.asDate(localDate);
		userDto.setUserAddedDate(date);
		UserEntity userEntity = util.convertUserDtoToUserEntity(userDto);
		UserEntity savedUserEntity=userRepository.save(userEntity);
		return util.convertUserEntityToUserDto(savedUserEntity);
	}

	public  UserDTO getUserDetailsById(Long userId) {
		Optional<UserEntity> userEntity = userRepository.findById(userId);
		if(userEntity.isPresent()) {
			return util.convertUserEntityToUserDto(userEntity.get());
		}else {
			return null;
		}
	}

	public List<UserDTO> getAllUserDetails() {
		List<UserEntity> userEntity = userRepository.findAll();
		List<UserDTO> userDTO = userEntity.stream().map(x-> util.convertUserEntityToUserDto(x)).toList();

		return userDTO;
	}

	public Boolean updateUserDetails(UserDTO user) {
		Optional<UserEntity> userEntity = userRepository.findByUserName(user.getUserName());
		if(userEntity.isPresent()) {
			UserEntity updateUserEntity = userEntity.get();
			updateUserEntity.setPhoneNumber(user.getPhoneNumber());
			updateUserEntity.setUserAddress(user.getUserAddress());
			UserEntity userUpdated = userRepository.save(updateUserEntity);
			if(userUpdated != null)
				return true;
		}
			return false;
		
	}

	public Boolean deleteUserDetail(Long userId) {
		try {
			userRepository.deleteById(userId);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}

}
