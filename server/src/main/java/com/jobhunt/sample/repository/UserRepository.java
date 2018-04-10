package com.jobhunt.sample.repository;

import com.jobhunt.sample.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>
{
}
