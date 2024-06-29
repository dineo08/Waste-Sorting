package com.enviro.assessment.grad001.dineosebolai.controller;

import com.enviro.assessment.grad001.dineosebolai.entity.RecycleTip;
import com.enviro.assessment.grad001.dineosebolai.service.RecycleTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recycle-tip")
@Validated
public class RecycleTipController {

    @Autowired
    private RecycleTipService tipService;

    @GetMapping
    public List<RecycleTip> getAllTips(){
        return tipService.getAllTips();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecycleTip> getTipById(@PathVariable Long id){
        Optional<RecycleTip> recycleTip = tipService.getTipById(id);
        return recycleTip.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RecycleTip> saveRecycleTip(@RequestBody RecycleTip recycleTip){
        RecycleTip tip = tipService.saveRecycleTip(recycleTip);
        return ResponseEntity.status(HttpStatus.CREATED).body(tip);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecycleTip> updateRecycleTip(@PathVariable Long id, @RequestBody RecycleTip recycleTip){
        if(tipService.getTipById(id).isPresent()){
            recycleTip.setId(id);
            return ResponseEntity.ok(tipService.updateTip(recycleTip));
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecycleTip(@PathVariable Long id){
        if(tipService.getTipById(id).isPresent()){
            tipService.deleteTip(id);
            return ResponseEntity.noContent().build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }
}
