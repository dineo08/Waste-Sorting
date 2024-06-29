package com.enviro.assessment.grad001.dineosebolai.service;

import com.enviro.assessment.grad001.dineosebolai.entity.WasteCategory;
import com.enviro.assessment.grad001.dineosebolai.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WasteCategoryService {

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    //waste category methods
    public List<WasteCategory> getAllCategories() {
        return wasteCategoryRepository.findAll();
    }

    public Optional<WasteCategory> getWasteCategoryById(Long id){
        return wasteCategoryRepository.findById(id);
    }

    public WasteCategory saveCategory(WasteCategory wasteCategory){
        return wasteCategoryRepository.save(wasteCategory);
    }

    public WasteCategory updateCategory(WasteCategory wasteCategory){
        return  wasteCategoryRepository.save(wasteCategory);
    }

    public void deleteCategory(Long id){
        wasteCategoryRepository.deleteById(id);
    }
}
