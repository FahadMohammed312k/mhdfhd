package com.apidemos.service;

import com.apidemos.entity.Registration;

public interface RegistrationService {

    public Registration createRegistration(Registration registration);

    void deleteRegistrationById(long id);

    Registration updateRegistration(long id, Registration registration);

    Registration getAllRegistration();
}
