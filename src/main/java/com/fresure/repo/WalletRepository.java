package com.fresure.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fresure.entity.WalletEntity;

@Repository
public interface WalletRepository extends CrudRepository<WalletEntity, Integer>{

}
