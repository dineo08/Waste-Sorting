package com.enviro.assessment.grad001.dineosebolai.service;

import com.enviro.assessment.grad001.dineosebolai.entity.RecycleTip;
import com.enviro.assessment.grad001.dineosebolai.repository.RecycleTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecycleTipService {

    @Autowired
    private RecycleTipRepository tipRepository;

    //recycle tip methods
    public List<RecycleTip> getAllTips(){
        return tipRepository.findAll();
    }

    public Optional<RecycleTip> getTipById(Long id){
        return tipRepository.findById(id);
    }

    public RecycleTip saveRecycleTip(RecycleTip recycleTip){
        return tipRepository.save(recycleTip);
    }

    public RecycleTip updateTip(RecycleTip recycleTip){
        return tipRepository.save(recycleTip);
    }

    public void deleteTip(Long id){
        tipRepository.deleteById(id);
    }
}
