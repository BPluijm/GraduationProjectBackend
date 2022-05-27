package com.graduation.backend.controller;

import com.graduation.backend.BackendApplication;
import com.graduation.backend.model.FutureTravels;
import com.graduation.backend.service.FutureTravelsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.BDDAssumptions.given;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ContextConfiguration(classes={BackendApplication.class})
class FutureTravelsControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private FutureTravelsService service;

    @Test
    public void testEndpointGetFutureTravels() throws Exception {

//        FutureTravels future = new FutureTravels("Costa Rica");
//        List<FutureTravels> allFutureTravels = Arrays.asList(future);
//
//        given(service.getFutureTravels()).willReturn(allFutureTravels);
//
//        mvc.perform(get("/future-travels")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect((ResultMatcher) jsonPath("$", hasSize(1)))
//                .andExpect((jsonPath("$[0].", is("Costa Rica")));
//
    }

}