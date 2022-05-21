package com.cts.employeemicroservice.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import com.cts.employeemicroservice.exception.InvalidUserException;
import com.cts.employeemicroservice.exception.MicroserviceException;
import com.cts.employeemicroservice.model.Employee;
import com.cts.employeemicroservice.service.EmployeeService;

import java.util.ArrayList;

import java.util.HashSet;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EmployeeControllerTest {

    @MockBean
    private EmployeeService employeeService;

    EmployeeController employeeController = new EmployeeController();

    /**
     * Method under test: {@link EmployeeController#viewTopOffers(String, int)}
     */
    @Test
    void testViewTopOffers() throws Exception {
        when(this.employeeService.viewTopOffers((String) any(), anyInt())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee/viewMostLikedOffers/{id}", 1)
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
        MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link EmployeeController#viewTopOffers(String, int)}
     */
    @Test
    void testViewTopOffers2() throws Exception {
        when(this.employeeService.viewTopOffers((String) any(), anyInt())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/employee/viewMostLikedOffers/{id}", 1);
        getResult.contentType("https://example.org/example");
        MockHttpServletRequestBuilder requestBuilder = getResult.header("Authorization",
                "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
        MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link EmployeeController#savePoints(String, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSavePoints() throws InvalidUserException, MicroserviceException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.cts.employeemicroservice.controller.EmployeeController.savePoints(EmployeeController.java:96)
        //   In order to prevent savePoints(String, int)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   savePoints(String, int).
        //   See https://diff.blue/R013 to resolve this issue.

        (new EmployeeController()).savePoints("ABC123", 1);
    }

    /**
     * Method under test: {@link EmployeeController#likeOffer(String, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLikeOffer() throws MicroserviceException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.cts.employeemicroservice.controller.EmployeeController.likeOffer(EmployeeController.java:111)
        //   In order to prevent likeOffer(String, int)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   likeOffer(String, int).
        //   See https://diff.blue/R013 to resolve this issue.

        (new EmployeeController()).likeOffer("ABC123", 123);
    }

    @Test
    @DisplayName("Checking for EmployeeController - if it is loading or not for @GetMapping")
    void employeeControllerNotNullTest() {
        assertThat(employeeController).isNotNull();
    }

    /**
     * Method under test: {@link EmployeeController#getLikedOffers(String)}
     */
    @Test
    void testGetLikedOffers() throws Exception {
        when(this.employeeService.getLikedOffers((String) any())).thenReturn(new HashSet<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee/recentlyLiked")
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
        MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link EmployeeController#getLikedOffers(String)}
     */
    @Test
    void testGetLikedOffers2() throws Exception {
        when(this.employeeService.getLikedOffers((String) any())).thenReturn(new HashSet<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/employee/recentlyLiked");
        getResult.contentType("https://example.org/example");
        MockHttpServletRequestBuilder requestBuilder = getResult.header("Authorization",
                "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
        MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link EmployeeController#viewEmployeeOffers(String, int)}
     */
    @Test
    void testViewEmployeeOffers() throws Exception {
        when(this.employeeService.viewEmpOffers((String) any(), anyInt())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee/viewEmployeeOffers/{id}", 1)
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
        MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link EmployeeController#viewEmployeeOffers(String, int)}
     */
    @Test
    void testViewEmployeeOffers2() throws Exception {
        when(this.employeeService.viewEmpOffers((String) any(), anyInt())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/employee/viewEmployeeOffers/{id}", 1);
        getResult.contentType("https://example.org/example");
        MockHttpServletRequestBuilder requestBuilder = getResult.header("Authorization",
                "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
        MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link EmployeeController#viewProfile(String, int)}
     */
    @Test
    void testViewProfile() throws Exception {
        Employee employee = new Employee();
        employee.setAge(1);
        employee.setContactNumber(1L);
        employee.setDepartment("Department");
        employee.setEmail("jane.doe@example.org");
        employee.setEngagedInOffers(new HashSet<>());
        employee.setGender("Gender");
        employee.setId(1);
        employee.setLikedOffers(new HashSet<>());
        employee.setName("Name");
        employee.setOffers(new HashSet<>());
        employee.setPointsGained(1);
        when(this.employeeService.viewEmployee((String) any(), anyInt())).thenReturn(employee);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee/viewProfile/{id}", 1)
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
        MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"name\":\"Name\",\"department\":\"Department\",\"gender\":\"Gender\",\"age\":1,\"contactNumber\":1,\"email\":"
                                        + "\"jane.doe@example.org\",\"pointsGained\":1,\"offers\":[],\"engagedInOffers\":[],\"likedOffers\":[]}"));
    }

    /**
     * Method under test: {@link EmployeeController#viewProfile(String, int)}
     */
    @Test
    void testViewProfile2() throws Exception {
        Employee employee = new Employee();
        employee.setAge(1);
        employee.setContactNumber(1L);
        employee.setDepartment("Department");
        employee.setEmail("jane.doe@example.org");
        employee.setEngagedInOffers(new HashSet<>());
        employee.setGender("Gender");
        employee.setId(1);
        employee.setLikedOffers(new HashSet<>());
        employee.setName("Name");
        employee.setOffers(new HashSet<>());
        employee.setPointsGained(1);
        when(this.employeeService.viewEmployee((String) any(), anyInt())).thenReturn(employee);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/employee/viewProfile/{id}", 1);
        getResult.contentType("https://example.org/example");
        MockHttpServletRequestBuilder requestBuilder = getResult.header("Authorization",
                "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
        MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"name\":\"Name\",\"department\":\"Department\",\"gender\":\"Gender\",\"age\":1,\"contactNumber\":1,\"email\":"
                                        + "\"jane.doe@example.org\",\"pointsGained\":1,\"offers\":[],\"engagedInOffers\":[],\"likedOffers\":[]}"));
    }

}