package com.fresure.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fresure.entity.DeliveryExecutiveEntity;

@Repository
public interface DeliveryExecutiveRepository extends CrudRepository<DeliveryExecutiveEntity, Integer>{

}
