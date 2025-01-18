package com.enviro.assessment.grad001.dineosebolai.service;

import com.enviro.assessment.grad001.dineosebolai.dto.DisposalGuidelineDto;
import com.enviro.assessment.grad001.dineosebolai.entity.DisposalGuideline;

import java.util.List;

public interface DisposalGuidelineService {

    //disposal guideline methods
    List<DisposalGuideline> getAllDisposalGuidelines();

    DisposalGuideline getGuidelineById(Long id);

    DisposalGuideline saveGuideline(DisposalGuidelineDto disposalGuidelineDto);

    DisposalGuideline updateGuideline(Long id, DisposalGuidelineDto disposalGuidelineDto);

    void deleteGuideline(Long id);
}
