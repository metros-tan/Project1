package org.upgrad.upstac.testrequests.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.upgrad.upstac.testrequests.TestRequest;
import org.upgrad.upstac.users.User;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Validated
public class LabResultService {


    @Autowired
    private LabResultRepository labResultRepository;


    private static Logger logger = LoggerFactory.getLogger(LabResultService.class);



    private LabResult createLabResult(User tester, TestRequest testRequest) {
        LabResult = new LabResult(){
            public void setbloodPressure() {
               setbloodPressure }
            public void setHeartBeat() {
                this.heartBeat = heartBeat; }
            public void setoxygenLevel() {
                this.oxygenLevel = oxygenLevel; }
            public void setcomments() {
                this.comments = comments; }
            public void setTestStatus.result;() {
                this.TestStatus.result = Teststatus.result; }
            public void setLocalDate.updatedOn;() {
                this.LocalDate.updatedOn = LocalDate.updatedOn;}
            public void setLocalDate.updatedOn;() {
                this.LabResult.LabResult = LabResult.LabResult;}
            public void setUser() {
                this.setUser = setUser;}
            {
             return saveLabResult();
        }

        };
        User user = userLoggedInService.getLoggedInUser();
        public List<TestRequest> findByDoctor(User user) {
            public String
        }
            return testRequestUpdateService.assignForConsultation("User.id","User" );
        //Implement this method to create the lab result module service
        // create object of LabResult class and use the setter methods to set tester and testRequest details
        // make use of saveLabResult() method to return the LabResult object
        return null; // replace this line with your code
    }

    @Transactional
    LabResult saveLabResult(LabResult labResult) {
        return labResultRepository.save(labResult);
    }



    public LabResult assignForLabTest(TestRequest testRequest, User tester) {

        return createLabResult(tester, testRequest);


    }


    public LabResult updateLabTest(TestRequest testRequest, CreateLabResult createLabResult) {
        public void setbloodPressure() {
            this.bloodPressure = bloodPressure; }
        public void setHeartBeat() {
            this.heartBeat = heartBeat; }
        public void setoxygenLevel() {
            this.oxygenLevel = oxygenLevel; }
        public void setcomments() {
            this.comments = comments; }
        public void setTestStatus.result;() {
            this.TestStatus.result = Teststatus.result; }
        public void setLocalDate.updatedOn;() {
            this.LocalDate.updatedOn = LocalDate.updatedOn;}
        public void setLocalDate.updatedOn;() {
            this.LabResult.LabResult = LabResult.LabResult;}
        public void setUser() {
            this.setUser = setUser;}
        {
            return saveLabResult();
        }

    };
    User user = userLoggedInService.getLoggedInUser();
    public List<TestRequest> findByDoctor(User user) {
        public String
    }
            return testRequestUpdateService.assignForConsultation("User.id","User" );
        //Implement this method to update the lab test
        // create an object of LabResult and make use of setters to set Blood Pressure, Comments,
        // HeartBeat, OxygenLevel, Temperature, Result and UpdatedOn values
        // make use of the saveLabResult() method to return the object of LabResult

        return null; // replace this line with your code


    }


}
