package com.example.wfinittrade.repository;

import com.example.wfinittrade.model.Params;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParamsRepo extends JpaRepository<Params, Integer> {
}
