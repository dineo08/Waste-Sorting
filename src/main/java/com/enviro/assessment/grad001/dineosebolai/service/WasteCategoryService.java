package com.enviro.assessment.grad001.dineosebolai.service;

import com.enviro.assessment.grad001.dineosebolai.dto.WasteCategoryDto;
import com.enviro.assessment.grad001.dineosebolai.entity.WasteCategory;

import java.util.List;

public interface WasteCategoryService {
    //waste category methods
    List<WasteCategory> getAllCategories();

    WasteCategory getWasteCategoryById(Long id);

    WasteCategory saveCategory(WasteCategoryDto wasteCategoryDto);

    WasteCategory updateCategory(Long id, WasteCategoryDto wasteCategoryDto);

    void deleteCategory(Long id);
}
