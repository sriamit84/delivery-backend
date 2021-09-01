package com.fresure.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fresure.entity.SubscriptionEntity;

@Repository
public interface SubscriptionRepository extends CrudRepository<SubscriptionEntity, Integer>{

}
