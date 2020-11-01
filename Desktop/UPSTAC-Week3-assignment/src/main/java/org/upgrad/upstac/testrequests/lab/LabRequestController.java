package org.upgrad.upstac.testrequests.lab;


import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.upgrad.upstac.config.security.UserLoggedInService;
import org.upgrad.upstac.exception.AppException;
import org.upgrad.upstac.testrequests.RequestStatus;
import org.upgrad.upstac.testrequests.TestRequest;
import org.upgrad.upstac.testrequests.TestRequestQueryService;
import org.upgrad.upstac.testrequests.TestRequestUpdateService;
import org.upgrad.upstac.testrequests.flow.TestRequestFlowService;
import org.upgrad.upstac.users.User;

import java.util.List;


@RestController
@Getter
@Setter
@RequestMapping("/api/labrequests")
public class LabRequestController {

    Logger log = LoggerFactory.getLogger(LabRequestController.class);




    @Autowired
    private TestRequestUpdateService testRequestUpdateService;

    @Autowired
    private TestRequestQueryService testRequestQueryService;
    @Autowired
    private TestRequestFlowService testRequestFlowService;



    @Autowired
    private UserLoggedInService userLoggedInService;


    //Returns list of test requests having a status of 'INITIATED'
    //Notes stated 'For reference check the method requestHistory() method from TestRequestController class"
    //but i couldn't find the requestHistory() method
    @GetMapping("/to-be-tested")
    @PreAuthorize("hasAnyRole('TESTER')")
    public List<TestRequest> getForTests()  {
                User user = userLoggedInService.getLoggedInUser();
            return testRequestQueryService.findBy(RequestStatus.INITIATED);
    }



    //Returns list of test requests assigned to current tester
    //Notes stated  "For reference check the method getPendingTests() method from TestRequestController class"
    //but I couldnt find getPendingTests method

    @GetMapping
    @PreAuthorize("hasAnyRole('TESTER')")
    public List<TestRequest> getForTester()  {
        User user = userLoggedInService.getLoggedInUser();
        return testRequestQueryService.findByTester(user);

    }


    // Assigns a particular test request to the current tester(logged in user)
    //I cant get doctor consultation to work in the front end
    //**getting error "TypeError: Right side of assignment cannot be destructured rc/consultation/PendingConsultations.js:116"

    @PreAuthorize("hasAnyRole('TESTER')")
    @PutMapping("/assign/{id}")
    public TestRequest assignForLabTest(@PathVariable Long id) {
        try {
                User user = userLoggedInService.getLoggedInUser();
                TestRequest result = testRequestUpdateService.assignForLabTest(id, user);
                return result;
            }  catch (AppException e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
            }

        }



    //Updates the result of the current test request with test results
    //Notes stated "create an object of TestResult class" but i couldnt find a TestResult class
    @PreAuthorize("hasAnyRole('TESTER')")
    @PutMapping("/update/{id}")
    public TestRequest updateLabTest(@PathVariable Long id,@RequestBody CreateLabResult createLabResult) {


        try {
            User user = userLoggedInService.getLoggedInUser();
            TestRequest testrequest = testRequestUpdateService.updateLabTest(id, createLabResult, user );
            return testrequest;
        }  catch (AppException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }





}
