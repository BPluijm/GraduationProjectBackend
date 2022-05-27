package com.graduation.backend.controller;

import com.graduation.backend.BackendApplication;
import com.graduation.backend.model.TravelTips;
import com.graduation.backend.service.TravelsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;


@WebMvcTest
@ContextConfiguration(classes={BackendApplication.class})
class TravelTipsControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private TravelsService service;

    @Test
    public void testEndpointGetTravelTips() throws Exception {

//        TravelTips travelTips = new TravelTips("Frikandellen");
//        List<TravelTips> allTravelTips = List.of(travelTips);
//
//    @Test
//    void deleteTravelTips() {
//    }
    }
}