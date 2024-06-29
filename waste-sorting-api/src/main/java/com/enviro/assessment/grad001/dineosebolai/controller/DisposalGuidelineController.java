package com.enviro.assessment.grad001.dineosebolai.controller;

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
    private DisposalGuidelineService guidelineService;

    @GetMapping
    public List<DisposalGuideline> getAllGuidelines(){
        return guidelineService.getAllDisposalGuidelines();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getGuidelineById(@PathVariable Long id){
        Optional<DisposalGuideline> guideline = guidelineService.getGuidelineById(id);
        return guideline.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DisposalGuideline> saveGuideline(@RequestBody DisposalGuideline disposalGuideline){
        DisposalGuideline guideline = guidelineService.saveGuideline(disposalGuideline);
        return ResponseEntity.status(HttpStatus.CREATED).body(guideline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuideline> updateGuideline(@PathVariable Long id, @RequestBody DisposalGuideline disposalGuideline){
        Optional<DisposalGuideline> guideline = guidelineService.getGuidelineById(id);
        if(guideline.isPresent()){
            disposalGuideline.setId(id);
            return ResponseEntity.ok(guidelineService.updateGuideline(disposalGuideline));
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuideline(@PathVariable Long id){
        if(guidelineService.getGuidelineById(id).isPresent()){
            guidelineService.deleteGuideline(id);
            return ResponseEntity.noContent().build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }
}
