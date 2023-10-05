package com.roytuts.completablefuture.fetchdata.asynchronously.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roytuts.completablefuture.fetchdata.asynchronously.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
