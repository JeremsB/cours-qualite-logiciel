package com.tactfactory.monprojetsb.monprojetsb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tactfactory.monprojetsb.monprojetsb.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
