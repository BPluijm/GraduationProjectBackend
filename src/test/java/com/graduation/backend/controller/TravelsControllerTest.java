package com.graduation.backend.controller;

import com.graduation.backend.BackendApplication;
import com.graduation.backend.model.Travels;
import com.graduation.backend.service.TravelsService;
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

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ContextConfiguration(classes={BackendApplication.class})
class TravelsControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private TravelsService service;

    @Test
    public void testEndpointGetTravels() throws Exception {

//        Travels travels = new Travels("Australia");
//        List<Travels> allTravels = Arrays.asList(travels);
//
//        given(service.getTravels()).willReturn(allTravels);
//
//        mvc.perform(get("/travels")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect((ResultMatcher) jsonPath("$[0].country", is("Australia")));
//
    }
}