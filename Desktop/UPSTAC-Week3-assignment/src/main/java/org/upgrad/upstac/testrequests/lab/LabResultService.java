package org.upgrad.upstac.testrequests.lab;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.upgrad.upstac.testrequests.TestRequest;
import org.upgrad.upstac.users.User;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Validated
@Getter
@Setter
public class LabResultService {


    @Autowired
    private LabResultRepository labResultRepository;


    private static Logger logger = LoggerFactory.getLogger(LabResultService.class);


    //The lab result module service - getters and setters to update lab results
    private LabResult createLabResult(User tester, TestRequest testRequest) {
        LabResult labResult = new LabResult();
        labResult.setTester(testRequest.getCreatedBy());
        labResult.setUpdatedOn(LocalDate.now());
        testRequest.setStatus(testRequest.getStatus());
        testRequest.setName(testRequest.getName());
        testRequest.setGender(testRequest.getGender());
        testRequest.setAddress(testRequest.getAddress());
        testRequest.setAge(testRequest.getAge());
        testRequest.setEmail(testRequest.getEmail());
        testRequest.setPhoneNumber(testRequest.getPhoneNumber());
        testRequest.setPinCode(testRequest.getPinCode());
        testRequest.setConsultation(testRequest.getConsultation());
        testRequest.setLabResult(testRequest.getLabResult());
        return saveLabResult(labResult);
    }

    private TestRequest request;



    @Transactional
    LabResult saveLabResult(LabResult labResult) {
        return labResultRepository.save(labResult);
    }



    public LabResult assignForLabTest(TestRequest testRequest, User tester) {

        return createLabResult(tester, testRequest);


    }


    public LabResult updateLabTest(TestRequest testRequest, CreateLabResult createLabResult) {

        //Method to update the lab test
        LabResult labResult = new LabResult();
        labResult.setBloodPressure(createLabResult.getBloodPressure());
        labResult.setComments(createLabResult.getComments());
        labResult.setHeartBeat(createLabResult.getHeartBeat());
        labResult.setOxygenLevel(createLabResult.getOxygenLevel());
        labResult.setTemperature(createLabResult.getTemperature());
        labResult.setResult(createLabResult.getResult());
        labResult.setUpdatedOn(LocalDate.now());
        return saveLabResult(labResult);


    }


}
