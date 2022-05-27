package com.graduation.backend.service;

import com.graduation.backend.dto.TravelTipsDto;
import com.graduation.backend.model.TravelTips;
import java.io.IOException;
import java.util.List;

public interface TravelTipsService {
    List<TravelTipsDto> getTravelTips();
    TravelTipsDto getTravelTipsById(Long id);
    TravelTips createTravelTips(TravelTipsDto ttdt) throws IOException;
    String updateTravelTips(TravelTipsDto ti, Long id) throws IOException;
    String deleteTravelTips(Long id);
}
