package com.enviro.assessment.grad001.dineosebolai.service;

import com.enviro.assessment.grad001.dineosebolai.dto.RecycleTipDto;
import com.enviro.assessment.grad001.dineosebolai.entity.RecycleTip;

import java.util.List;

public interface RecycleTipService {
    //recycle tip methods
    public List<RecycleTipDto> getAllTips();

    RecycleTip getTipById(Long id);

    RecycleTipDto getRecycleTipById(Long id);

    RecycleTipDto saveRecycleTip(RecycleTipDto recycleTipDto);

    RecycleTipDto updateTip(Long id, RecycleTipDto recycleTipDto);

    void deleteTip(Long id);
}
