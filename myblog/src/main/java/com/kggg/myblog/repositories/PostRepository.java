package com.kggg.myblog.repositories;

import com.kggg.myblog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

}
