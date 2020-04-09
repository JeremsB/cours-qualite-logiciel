package com.tactfactory.monprojetsb.monprjetsb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tactfactory.monprojetsb.monprjetsb.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
