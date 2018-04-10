package com.jobhunt.sample.repository;

import com.jobhunt.sample.data.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
