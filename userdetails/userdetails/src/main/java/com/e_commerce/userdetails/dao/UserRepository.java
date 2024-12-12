package com.e_commerce.userdetails.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.e_commerce.userdetails.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

//	@Query(name = "select * from UserEntity where userName=?")
//	Optional<UserEntity> findByName(String userName);

	Optional<UserEntity> findByUserName(String userName);

}
