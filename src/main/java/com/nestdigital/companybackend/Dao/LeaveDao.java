package com.nestdigital.companybackend.Dao;

import com.nestdigital.companybackend.Model.LeaveModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface LeaveDao extends CrudRepository<LeaveModel,Integer> {
    @Query(value = "SELECT l.`id`, l.`applydate`, l.`date`, l.`emp_code`, l.`reason`, l.`type`,l.`status`,e.name FROM `leaves` l JOIN employee e ON e.emp_code=l.emp_code WHERE l.`emp_code`=:emp_code",nativeQuery = true)
    List<Map<String,String>> View(Integer emp_code);

    @Query(value = "SELECT l.`id`, l.`applydate`, l.`date`, l.`emp_code`, l.`reason`, l.`type`,l.`status`,e.name FROM `leaves` l JOIN employee e ON e.emp_code=l.emp_code",nativeQuery = true)
    List<Map<String,String>> Post();

    @Modifying
    @Query(value = "UPDATE `leaves` SET `status`=:status WHERE `emp_code`=:emp_code",nativeQuery = true)
    void  changeStatusOfLeave(Integer emp_code,Integer status);
}
