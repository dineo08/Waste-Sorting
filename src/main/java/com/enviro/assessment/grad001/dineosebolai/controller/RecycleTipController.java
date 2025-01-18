package com.enviro.assessment.grad001.dineosebolai.controller;

import com.enviro.assessment.grad001.dineosebolai.dto.RecycleTipDto;
import com.enviro.assessment.grad001.dineosebolai.entity.RecycleTip;
import com.enviro.assessment.grad001.dineosebolai.service.RecycleTipService;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class RecycleTipController {

    private RecycleTipService tipService;

    @GetMapping
    public ResponseEntity<List<RecycleTipDto>> getAllRecycleTips() {
        List<RecycleTipDto> recycleTips = tipService.getAllTips();

        return ResponseEntity.ok(recycleTips);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecycleTipDto> getTipById(@PathVariable Long id){
        RecycleTipDto recycleTipDto = tipService.getRecycleTipById(id);

        return new ResponseEntity<>(recycleTipDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RecycleTipDto> saveRecycleTip(@RequestBody RecycleTipDto recycleTipDto){
        RecycleTipDto savedTip = tipService.saveRecycleTip(recycleTipDto);

        return new ResponseEntity<>(savedTip, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecycleTipDto> updateRecycleTip(@PathVariable Long id, @RequestBody RecycleTipDto recycleTipDto){
        RecycleTipDto updatedTip = tipService.updateTip(id, recycleTipDto);

        return  ResponseEntity.ok(updatedTip);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecycleTip(@PathVariable Long id){
        try {
            tipService.deleteTip(id);

            return ResponseEntity.ok("Recycle tip deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
