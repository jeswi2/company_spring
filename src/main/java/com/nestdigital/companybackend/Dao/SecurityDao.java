package com.nestdigital.companybackend.Dao;

import com.nestdigital.companybackend.Model.SecurityModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface SecurityDao extends CrudRepository<SecurityModel,Integer> {

    @Query(value = "SELECT `id`, `doj`, `email`, `name`, `password`, `security_code` FROM `security` WHERE `security_code`=:security_code",nativeQuery = true)
    List<SecurityModel> searchsecurity(Integer security_code);

    @Modifying
    @Query(value = "DELETE FROM `security` WHERE `security_code`=:security_code",nativeQuery = true)
    void deleteBySecurityId(Integer security_code);

    @Modifying
    @Query(value = "UPDATE `security` SET `doj`=:doj,`email`=:email,`name`=:name,`password`=:password WHERE `security_code`=:security_code",nativeQuery = true)
void update(String doj,String email,String name,String password,Integer security_code);

    @Query(value = "SELECT `id`, `doj`, `email`, `name`, `password`, `security_code` FROM `security` WHERE `email`=:email AND `password`=:password",nativeQuery = true)
    List<SecurityModel> login (String email,String password);
}
