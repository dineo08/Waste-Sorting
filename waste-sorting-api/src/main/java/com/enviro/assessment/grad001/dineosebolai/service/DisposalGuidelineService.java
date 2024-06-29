package com.enviro.assessment.grad001.dineosebolai.service;

import com.enviro.assessment.grad001.dineosebolai.entity.DisposalGuideline;
import com.enviro.assessment.grad001.dineosebolai.repository.DisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisposalGuidelineService {

    @Autowired
    private DisposalGuidelineRepository guidelineRepository;

    //disposal guideline methods
    public List<DisposalGuideline> getAllDisposalGuidelines(){
        return guidelineRepository.findAll();
    }

    public Optional<DisposalGuideline> getGuidelineById(Long id){
        return guidelineRepository.findById(id);
    }

    public DisposalGuideline saveGuideline(DisposalGuideline disposalGuideline){
        return guidelineRepository.save(disposalGuideline);
    }

    public DisposalGuideline updateGuideline(DisposalGuideline disposalGuideline){
        return guidelineRepository.save(disposalGuideline);
    }

    public void deleteGuideline(Long id){
        guidelineRepository.deleteById(id);
    }
}
