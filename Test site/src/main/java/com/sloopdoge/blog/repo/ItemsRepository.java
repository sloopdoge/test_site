package com.sloopdoge.blog.repo;

import com.sloopdoge.blog.models.Items;
import org.springframework.data.repository.CrudRepository;

/* Interface to control data in MySql database  */
public interface ItemsRepository extends CrudRepository<Items, Integer> {
}
