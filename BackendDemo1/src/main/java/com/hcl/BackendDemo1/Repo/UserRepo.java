package com.hcl.BackendDemo1.Repo;

import com.hcl.BackendDemo1.Entity.Employee;
import com.hcl.BackendDemo1.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User findByName(String name);

    Optional<User> findOneByNameAndPassword(String name,String password);
}
