package com.rop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rop.entity.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

}
