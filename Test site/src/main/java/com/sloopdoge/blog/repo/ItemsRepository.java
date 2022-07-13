package com.sloopdoge.blog.repo;

import com.sloopdoge.blog.models.Items;
import org.springframework.data.repository.CrudRepository;

public interface ItemsRepository extends CrudRepository<Items, Long> {


}
