package com.tactfactory.monprojetsb.monprjetsb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tactfactory.monprojetsb.monprjetsb.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
