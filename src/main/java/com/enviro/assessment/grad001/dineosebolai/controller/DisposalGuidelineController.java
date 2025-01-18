package com.enviro.assessment.grad001.dineosebolai.controller;

import com.enviro.assessment.grad001.dineosebolai.dto.DisposalGuidelineDto;
import com.enviro.assessment.grad001.dineosebolai.entity.DisposalGuideline;
import com.enviro.assessment.grad001.dineosebolai.service.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/guidelines")
@Validated
public class DisposalGuidelineController {

    @Autowired
    private DisposalGuidelineService disposalGuidelineService;

    @GetMapping
    public ResponseEntity<List<DisposalGuideline>> getAllGuidelines(){
        List<DisposalGuideline> disposalGuidelines = disposalGuidelineService.getAllDisposalGuidelines();

        return ResponseEntity.ok(disposalGuidelines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getGuidelineById(@PathVariable Long id){
            DisposalGuideline disposalGuideline = disposalGuidelineService.getGuidelineById(id);
            return ResponseEntity.ok(disposalGuideline);
    }

    @PostMapping
    public ResponseEntity<DisposalGuideline> saveGuideline(@RequestBody DisposalGuidelineDto disposalGuidelineDto){
        DisposalGuideline createdDisposalGuideline = disposalGuidelineService.saveGuideline(disposalGuidelineDto);
        return new ResponseEntity<>(createdDisposalGuideline, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuideline> updateGuideline(@PathVariable Long id, @RequestBody DisposalGuidelineDto disposalGuidelineDto){
            DisposalGuideline updatedDisposalGuideline = disposalGuidelineService.updateGuideline(id, disposalGuidelineDto);
            return ResponseEntity.ok(updatedDisposalGuideline);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGuideline(@PathVariable Long id){
        try {
            disposalGuidelineService.deleteGuideline(id);
            return ResponseEntity.ok("Disposal guideline deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
