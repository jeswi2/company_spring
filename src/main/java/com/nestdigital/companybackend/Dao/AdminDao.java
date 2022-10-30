package com.nestdigital.companybackend.Dao;

import com.nestdigital.companybackend.Model.AdminModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminDao extends CrudRepository<AdminModel,Integer> {

@Query(value = "SELECT `id`, `address`, `designation`, `dob`, `doj`, `email`, `emp_code`, `name`, `password`, `phone` FROM `employee` WHERE `emp_code`=:emp_code",nativeQuery = true)
    List<AdminModel> searchemp(Integer emp_code);

@Modifying
@Query(value = "DELETE FROM `employee` WHERE `emp_code`=:emp_code",nativeQuery = true)
    void deleteId(Integer emp_code);

@Modifying
    @Query(value = "UPDATE `employee` SET `address`=:address,`designation`=:designation,`dob`=:dob,`doj`=:doj,`email`=:email,`name`=:name,`password`=:password,`phone`=:phone WHERE `emp_code`=:emp_code",nativeQuery = true)
void update(String address,String designation,String dob,String doj,String email,String name,String password,String phone,Integer emp_code);

@Query(value = "SELECT `id`, `address`, `designation`, `dob`, `doj`, `email`, `emp_code`, `name`, `password`, `phone` FROM `employee` WHERE `email`=:email AND `password`=:password",nativeQuery = true)
List<AdminModel>login(String email,String password);
}
