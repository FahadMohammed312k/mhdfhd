package com.apidemos.controller;

import com.apidemos.entity.Registration;
import com.apidemos.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {


    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    //http://localhost:8080/api/v1/registration

    @PostMapping
    public ResponseEntity<Registration> addRegistration(@RequestBody Registration registration){
        Registration reg=registrationService.createRegistration(registration);
        return new ResponseEntity<>(reg, HttpStatus.CREATED);
    }


    //http://localhost:8080/api/v1/registration?id=
    @DeleteMapping
    public ResponseEntity<String> deleteRegistrationById(
            @RequestParam long id
    ){
        registrationService.deleteRegistrationById(id);
        return new ResponseEntity<>("Registration deleted", HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<Registration> updateRegistration(
            @RequestParam long id,
            @RequestBody Registration registration
    ){
        Registration updateReg=registrationService.updateRegistration(id, registration);
        return new ResponseEntity("Registration updated", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Registration> getAllRegistration(){
       Registration reg= registrationService.getAllRegistration();
       return new ResponseEntity("reg",HttpStatus.OK);

    }

}
