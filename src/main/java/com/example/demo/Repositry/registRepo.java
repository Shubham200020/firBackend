package com.example.demo.Repositry;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Registration;
@Repository
public interface registRepo extends JpaRepository<Registration ,Integer> {
	
	
}
