package com.enviro.assessment.grad001.dineosebolai.controller;

import com.enviro.assessment.grad001.dineosebolai.dto.WasteCategoryDto;
import com.enviro.assessment.grad001.dineosebolai.entity.WasteCategory;
import com.enviro.assessment.grad001.dineosebolai.service.WasteCategoryService;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class WasteCategoryController {

    private WasteCategoryService wasteCategoryService;

    //Waste category endpoints
    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllCategories() {
        List<WasteCategory> wasteCategories = wasteCategoryService.getAllCategories();

        return ResponseEntity.ok(wasteCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getCategoryById(@PathVariable Long id){
            WasteCategory wasteCategory = wasteCategoryService.getWasteCategoryById(id);
            return ResponseEntity.ok(wasteCategory);
    }

    @PostMapping
    public ResponseEntity<WasteCategory> saveCategory(@RequestBody WasteCategoryDto wasteCategoryDto){
        WasteCategory createdWasteCategory = wasteCategoryService.saveCategory(wasteCategoryDto);

        return new ResponseEntity<>(createdWasteCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateCategory(@PathVariable Long id, @RequestBody WasteCategoryDto wasteCategoryDto){
            WasteCategory updatedWasteCategory = wasteCategoryService.updateCategory(id, wasteCategoryDto);
            return ResponseEntity.ok(updatedWasteCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        try {
            wasteCategoryService.deleteCategory(id);
            return ResponseEntity.ok("Waste category deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
