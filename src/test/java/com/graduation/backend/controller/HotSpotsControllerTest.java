package com.graduation.backend.controller;

import com.graduation.backend.BackendApplication;
import com.graduation.backend.model.HotSpots;
import com.graduation.backend.service.HotSpotsService;
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

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
@ContextConfiguration(classes={BackendApplication.class})
class HotSpotsControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private HotSpotsService service;
//
//    @Test
//    public void testEndpointGetHotSpots() throws Exception {
//
//        HotSpots hotSpots = new HotSpots("Pyramids");
//        List<HotSpots> allHotSpots = List.of(hotSpots);
//
//        given(service.getHotSpots()).willReturn(allHotSpots);
//
//        mvc.perform(get("/hotspots")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect((ResultMatcher) jsonPath("$[0].name", is("Pyramids")));
//
//    }

}