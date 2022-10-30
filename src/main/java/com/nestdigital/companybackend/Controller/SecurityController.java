package com.nestdigital.companybackend.Controller;

import com.nestdigital.companybackend.Dao.SecurityDao;
import com.nestdigital.companybackend.Model.SecurityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class SecurityController {
    @Autowired
    private SecurityDao dao;


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addsecurity",consumes = "application/json",produces = "application/json")
    public String addsecurity(@RequestBody SecurityModel security)
    {
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentdate=String.valueOf(dt.format(now));
        security.setDoj(currentdate);
        System.out.println(security.toString());
        dao.save(security);
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewsecurity")
    public List<SecurityModel> view()
        {
        return (List<SecurityModel>) dao.findAll();
    }

@CrossOrigin(origins = "*")
    @PostMapping(path = "/searchsecurity",consumes = "application/json",produces = "application/json")
    public List<SecurityModel> searchsecurity(@RequestBody SecurityModel security)
{
    return (List<SecurityModel>) dao.searchsecurity(security.getSecurity_code());

}

@Transactional
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/deletesecurity",consumes = "application/json",produces = "application/json")
    public String deletesecurity(@RequestBody SecurityModel security){
        dao.deleteBySecurityId(security.getSecurity_code());
        return "{status:'success'}";
}
@Transactional
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/updatesecurity",consumes = "application/json",produces = "application/json")
    public String updatesecurity(@RequestBody SecurityModel security){
        dao.update(security.getDoj(),security.getEmail(),security.getName(),security.getPassword(),security.getSecurity_code());
        return "{status:'success'}";
}


@CrossOrigin(origins = "*")
    @PostMapping(path = "/loginsecurity",consumes = "application/json",produces = "application/json")
    public List<SecurityModel> login(@RequestBody SecurityModel security){
        return  (List<SecurityModel>) dao.login(security.getEmail(),security.getPassword());
}
}
