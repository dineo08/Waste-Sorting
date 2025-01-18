package com.enviro.assessment.grad001.dineosebolai.service.impl;

import com.enviro.assessment.grad001.dineosebolai.dto.WasteCategoryDto;
import com.enviro.assessment.grad001.dineosebolai.entity.WasteCategory;
import com.enviro.assessment.grad001.dineosebolai.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.dineosebolai.service.WasteCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WasteCategoryServiceImpl implements WasteCategoryService {
    private WasteCategoryRepository wasteCategoryRepository;

    @Override
    public List<WasteCategory> getAllCategories() {
        return wasteCategoryRepository.findAll();
    }

    @Override
    public WasteCategory getWasteCategoryById(Long id) {
        return wasteCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Waste Category not found with id: " + id));
    }

    @Override
    public WasteCategory saveCategory(WasteCategoryDto wasteCategoryDto) {
        WasteCategory wasteCategory = new WasteCategory();
        wasteCategory.setCategory(wasteCategoryDto.getCategory());
        return wasteCategoryRepository.save(wasteCategory);
    }

    @Override
    public WasteCategory updateCategory(Long id, WasteCategoryDto wasteCategoryDto) {
        WasteCategory wasteCategory = wasteCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Waste Category not found with id: " + id));
        wasteCategory.setCategory(wasteCategoryDto.getCategory());
        return wasteCategoryRepository.save(wasteCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        wasteCategoryRepository.deleteById(id);
    }
}
