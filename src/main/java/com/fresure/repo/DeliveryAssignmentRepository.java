package com.fresure.repo;

import java.util.Date;
import java.util.List;

import com.fresure.entity.EDeliveryStatus;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fresure.entity.DeliveryAssignmentEntity;

@Repository
public interface DeliveryAssignmentRepository extends CrudRepository<DeliveryAssignmentEntity, Integer>{
 List<DeliveryAssignmentEntity> findByDeliveryExec(Integer empId);
 
 //List<DeliveryAssignment> findByStatus(String status);
 
 List<DeliveryAssignmentEntity> findByDeliveryDateTime(Date date);
 
 @Modifying
 @Query("UPDATE DeliveryAssignmentEntity d SET d.deliveryStatus=:deliveryStatus , d.deliveryDateTime= :deliveryDateTime where d.deliveryAssignmentId=:deliveryAssignmentId")
 int updateDeliveryStatus(@Param("deliveryStatus") String deliveryStatus , @Param("deliveryDateTime") Date deliveryDateTime, @Param("deliveryAssignmentId") Integer deliveryAssignmentId);
 /*
 List<DeliveryAssignment> findByDeliveryDateAndDeliveryExec(Date date, Integer empId);
 
 List<DeliveryAssignment> deliveryStatsForMeOnParticularDay(Date date, Integer empId, Integer status);

 void upDeliveries(List<DeliveryAssignment> deliverAssignments);
 */
}
