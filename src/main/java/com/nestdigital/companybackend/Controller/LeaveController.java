package com.nestdigital.companybackend.Controller;

import com.nestdigital.companybackend.Dao.LeaveDao;
import com.nestdigital.companybackend.Model.LeaveModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;


@RestController
public class LeaveController {
    @Autowired
    private LeaveDao dao;


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/leaveAdd",consumes = "application/json",produces = "application/json")
    public String leaveadd(@RequestBody LeaveModel leave){
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentdate=String.valueOf(dt.format(now));
        leave.setApplydate(currentdate);
        System.out.println(leave.toString());
        dao.save(leave);
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/leaveappli",consumes = "application/json",produces = "application/json")
    List<Map<String,String>> leaveappli(@RequestBody LeaveModel leave){
        return  (List<Map<String, String>>) dao.View(leave.getEmp_code());
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewleaves")
    public List<Map<String,String>> viewleaves(){
        return  (List<Map<String, String>>) dao.Post();
    }
    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping("/leaveStatus")
    public String changeLeaveStatus(@RequestBody LeaveModel model){
        dao.changeStatusOfLeave(model.getEmp_code(),model.getStatus());
        return  "success";
    }
}
