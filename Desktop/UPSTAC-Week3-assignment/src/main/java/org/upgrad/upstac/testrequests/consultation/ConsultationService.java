package org.upgrad.upstac.testrequests.consultation;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.upgrad.upstac.testrequests.RequestStatus;
import org.upgrad.upstac.testrequests.TestRequest;
import org.upgrad.upstac.users.User;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Getter
@Setter
@Validated
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    private static Logger logger = LoggerFactory.getLogger(ConsultationService.class);


    @Transactional
    public Consultation assignForConsultation( TestRequest testRequest, User doctor) {
        // Method to assign the consultation service
        Consultation consultation = new Consultation();
        consultation.setSuggestion(consultation.getSuggestion());
        consultation.setComments(consultation.getComments());
        testRequest.setCreated(LocalDate.now());
        testRequest.setName(testRequest.getName());
        testRequest.setStatus(RequestStatus.INITIATED);
        testRequest.setAge(testRequest.getAge());
        testRequest.setEmail(testRequest.getEmail());
        testRequest.setPhoneNumber(testRequest.getPhoneNumber());
        testRequest.setPinCode(testRequest.getPinCode());
        testRequest.setAddress(testRequest.getAddress());
        testRequest.setGender(testRequest.getGender());
        return consultationRepository.save(consultation);


    }

    public Consultation updateConsultation(TestRequest testRequest , CreateConsultationRequest createConsultationRequest) {
        // Method to update the consultation
        Consultation consultation = new Consultation();
        consultation.setSuggestion(consultation.getSuggestion());
        consultation.setComments(consultation.getComments());
        testRequest.setCreated(LocalDate.now());
        return consultationRepository.save(consultation);
    }


}
