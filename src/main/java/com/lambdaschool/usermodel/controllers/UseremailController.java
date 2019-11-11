package com.lambdaschool.usermodel.controllers;

import com.lambdaschool.usermodel.models.Useremail;
import com.lambdaschool.usermodel.services.UseremailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/useremails")
public class UseremailController
{
    @Autowired
    UseremailService useremailService;

    // http://localhost:2019/useremails/useremails
    @GetMapping(value = "/useremails",
                produces = {"application/json"})
    public ResponseEntity<?> listAllUseremails()
    {
        List<Useremail> allUserEmails = useremailService.findAll();
        return new ResponseEntity<>(allUserEmails,
                                    HttpStatus.OK);
    }

    // http://localhost:2019/useremails/useremail/8
    @GetMapping(value = "/useremail/{useremailId}",
                produces = {"application/json"})
    public ResponseEntity<?> getUserEmailById(
            @PathVariable
                    Long useremailId)
    {
        Useremail ue = useremailService.findUseremailById(useremailId);
        return new ResponseEntity<>(ue,
                                    HttpStatus.OK);
    }


    // http://localhost:2019/useremails/username/cinnamon
    @GetMapping(value = "/username/{userName}",
                produces = {"application/json"})
    public ResponseEntity<?> findUseremailByUserName(
            @PathVariable
                    String userName)
    {
        //        List<Useremail> theUseremails = useremailService.findByUserName(userName);
        //        return new ResponseEntity<>(theUseremails,
        return new ResponseEntity<>(null,
                                    HttpStatus.OK);
    }

    // http://localhost:2019/useremails/useremail/8
    @DeleteMapping(value = "/useremail/{useremailid}")
    public ResponseEntity<?> deleteUserEmailById(
            @PathVariable
                    long useremailid)
    {
        useremailService.delete(useremailid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // http://localhost:2019/useremails/useremail/9/email/favbun@hops.local
    @PutMapping("/useremail/{useremailid}/email/{emailaddress}")
    public ResponseEntity<?> updateUserEmail(
            @PathVariable
                    long useremailid,
            @PathVariable
                    String emailaddress)
    {
        useremailService.update(useremailid,
                                emailaddress);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // note emails are added through the user process
}
