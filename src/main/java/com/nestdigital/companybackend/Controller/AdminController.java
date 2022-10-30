package com.nestdigital.companybackend.Controller;

import com.nestdigital.companybackend.Dao.AdminDao;
import com.nestdigital.companybackend.Model.AdminModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminDao dao;

@CrossOrigin(origins = "*")
    @PostMapping(path = "/empAdd",consumes = "application/json",produces = "application/json")
    public String empadd(@RequestBody AdminModel admin){
    DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    LocalDateTime now=LocalDateTime.now();
    String currentdate=String.valueOf(dt.format(now));
    admin.setDoj(currentdate);
    System.out.println(admin.toString());
    dao.save(admin);
    return "{status:'success'}";
}
@CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<AdminModel> view()
{
    return (List<AdminModel>) dao.findAll();

}

@CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<AdminModel> searchemp(@RequestBody AdminModel emp){
    return (List<AdminModel>)dao.searchemp(emp.getEmp_code());

}

@Transactional
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/delete",consumes = "application/json",produces = "application/json")
    public String deleteId(@RequestBody AdminModel admin){
    dao.deleteId(admin.getEmp_code());
    return "{status:'success'}";
}
@Transactional
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/edit",consumes = "application/json",produces = "application/json")
    public String edit(@RequestBody AdminModel admin)
{
    dao.update(admin.getAddress(),admin.getDesignation(),admin.getDob(),admin.getDoj(),admin.getEmail(),admin.getName(),admin.getPassword(),admin.getPhone(),admin.getEmp_code());
    return "{status:'success'}";
}
@CrossOrigin("*")
    @PostMapping(path = "/emplogin",consumes = "application/json",produces = "application/json")
    public List<AdminModel>login(@RequestBody AdminModel admin){
    return (List<AdminModel>)dao.login(admin.getEmail(),admin.getPassword());

}
}
