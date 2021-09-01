package com.fresure.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fresure.entity.ItemEntity;

@Repository
public interface ItemRepository extends CrudRepository<ItemEntity, Integer>{

}
