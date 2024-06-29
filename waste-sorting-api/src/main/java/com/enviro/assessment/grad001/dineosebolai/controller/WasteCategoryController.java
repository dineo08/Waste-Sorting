package com.enviro.assessment.grad001.dineosebolai.controller;

import com.enviro.assessment.grad001.dineosebolai.entity.WasteCategory;
import com.enviro.assessment.grad001.dineosebolai.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/waste-categories")
@Validated
public class WasteCategoryController {

    @Autowired
    private WasteCategoryService categoryService;

    //Waste category endpoints
    @GetMapping
    public List<WasteCategory> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getCategoryById(@PathVariable Long id){
        Optional<WasteCategory> wasteCategory = categoryService.getWasteCategoryById(id);
        return  wasteCategory.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<WasteCategory> saveCategory(@RequestBody WasteCategory wasteCategory){
        WasteCategory category = categoryService.saveCategory(wasteCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateCategory(@PathVariable Long id, @RequestBody WasteCategory wasteCategory){
        Optional<WasteCategory> category = categoryService.getWasteCategoryById(id);
        if(category.isPresent()){
            wasteCategory.setId(id);
            return ResponseEntity.ok(categoryService.updateCategory(wasteCategory));
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        if(categoryService.getWasteCategoryById(id).isPresent()){
            categoryService.deleteCategory(id);
            return ResponseEntity.noContent().build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }
}
