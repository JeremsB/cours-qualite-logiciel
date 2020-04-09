package com.tactfactory.monprojetsb.monprjetsb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tactfactory.monprojetsb.monprjetsb.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
