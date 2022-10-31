package com.nestdigital.companybackend.Controller;


import com.nestdigital.companybackend.Dao.LogDao;
import com.nestdigital.companybackend.Model.LogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class LogController {

    @Autowired
    private LogDao logDao;



    @CrossOrigin(origins = "*")
    @PostMapping("/checkIn")
    public String addLogDetails(@RequestBody LogModel logModel){
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        logModel.setLogin_time((String.valueOf(date.format(now))));
        logDao.save(logModel);
        return "Success";
    }


    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping("/checkOut")
    public String updateLogDetails(@RequestBody LogModel logModel){
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        logModel.setLogout_time((String.valueOf(date.format(now))));
        logDao.updateLogDetails(logModel.getLogout_time(),logModel.getLogout_security_code(),logModel.getId());
        return "Success";
    }



    @CrossOrigin(origins = "*")
    @GetMapping("/viewAllLog")
    public List<Map<String,String>> viewAllLog(){
        return (List<Map<String, String>>) logDao.viewAllLogs();
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/viewLogById")
    public List<Map<String,String>> viewLogById(@RequestBody LogModel logModel){
        return (List<Map<String, String>>) logDao.viewLogByEmpId(logModel.getEmp_code());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewCheckIn")
    public List<LogModel> viewCheckIn(){
        return (List<LogModel>) logDao.viewCheckIn();
    }
}
