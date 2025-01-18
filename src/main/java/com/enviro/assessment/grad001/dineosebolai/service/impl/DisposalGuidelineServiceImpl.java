package com.enviro.assessment.grad001.dineosebolai.service.impl;

import com.enviro.assessment.grad001.dineosebolai.dto.DisposalGuidelineDto;
import com.enviro.assessment.grad001.dineosebolai.entity.DisposalGuideline;
import com.enviro.assessment.grad001.dineosebolai.entity.WasteCategory;
import com.enviro.assessment.grad001.dineosebolai.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.dineosebolai.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.dineosebolai.service.DisposalGuidelineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DisposalGuidelineServiceImpl implements DisposalGuidelineService {
    private DisposalGuidelineRepository disposalGuidelineRepository;
    private WasteCategoryRepository wasteCategoryRepository;

    @Override
    public List<DisposalGuideline> getAllDisposalGuidelines() {
        return disposalGuidelineRepository.findAll();
    }

    @Override
    public DisposalGuideline getGuidelineById(Long id) {
        return disposalGuidelineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disposal Guideline not found with id: " + id));
    }

    @Override
    public DisposalGuideline saveGuideline(DisposalGuidelineDto disposalGuidelineDto) {
        DisposalGuideline disposalGuideline = new DisposalGuideline();
        disposalGuideline.setDescription(disposalGuidelineDto.getDescription());
        WasteCategory wasteCategory = wasteCategoryRepository.findById(disposalGuidelineDto.getWasteCategoryId())
                .orElseThrow(() -> new RuntimeException("Waste Category not found"));

        disposalGuideline.setWasteCategory(wasteCategory);

        return disposalGuidelineRepository.save(disposalGuideline);
    }

    @Override
    public DisposalGuideline updateGuideline(Long id, DisposalGuidelineDto disposalGuidelineDto) {
        DisposalGuideline disposalGuideline = disposalGuidelineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disposal Guideline not found with id: " + id));

        WasteCategory wasteCategory = wasteCategoryRepository.findById(disposalGuidelineDto.getWasteCategoryId())
                .orElseThrow(() -> new RuntimeException("Waste Category not found"));

        disposalGuideline.setWasteCategory(wasteCategory);
        disposalGuideline.setDescription(disposalGuidelineDto.getDescription());

        return disposalGuidelineRepository.save(disposalGuideline);
    }

    @Override
    public void deleteGuideline(Long id) {
        disposalGuidelineRepository.deleteById(id);
    }
}
