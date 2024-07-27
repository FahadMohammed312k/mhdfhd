package com.apidemos.service;

import com.apidemos.entity.Registration;
import com.apidemos.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Override
    public Registration updateRegistration(long id, Registration registration) {
        Optional<Registration> byId = registrationRepository.findById(id);
        Registration registration1 = byId.get();
        registration1.setName(registration.getName());
        registration1.setEmail(registration.getEmail());
        registration1.setMobile(registration.getMobile());
       Registration dto= registrationRepository.save(registration1);
        return dto;
    }

    @Override
    public Registration getAllRegistration() {
        List<Registration> registrations = registrationRepository.findAll();

        List<Registration>registrationDtos = registrations.stream().map(r->new Registration()).collect(Collectors.toList());
        return (Registration) registrationDtos;


    }

    private RegistrationRepository registrationRepository;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Override
    public Registration createRegistration(Registration registration) {
        Registration savedEntity = registrationRepository.save(registration);
        return savedEntity;

    }

    @Override
    public void deleteRegistrationById(long id) {
        registrationRepository.deleteById(id);

    }
}
