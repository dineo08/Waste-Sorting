package com.enviro.assessment.grad001.dineosebolai.service.impl;

import com.enviro.assessment.grad001.dineosebolai.dto.RecycleTipDto;
import com.enviro.assessment.grad001.dineosebolai.entity.RecycleTip;
import com.enviro.assessment.grad001.dineosebolai.repository.RecycleTipRepository;
import com.enviro.assessment.grad001.dineosebolai.service.RecycleTipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecycleTipServiceImpl implements RecycleTipService {
    private RecycleTipRepository recycleTipRepository;

    @Override
    public List<RecycleTipDto> getAllTips() {
        return recycleTipRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public RecycleTip getTipById(Long id) {
        return recycleTipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recycle Tip not found"));
    }

    @Override
    public RecycleTipDto getRecycleTipById(Long id) {
        RecycleTip recycleTip = recycleTipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RecycleTip not found with id: " + id));
        return mapToDto(recycleTip);
    }

    @Override
    public RecycleTipDto saveRecycleTip(RecycleTipDto recycleTipDto) {
        RecycleTip recycleTip = new RecycleTip();
        recycleTip.setTip(recycleTipDto.getTip());
        RecycleTip savedRecycleTip = recycleTipRepository.save(recycleTip);
        return mapToDto(savedRecycleTip);
    }

    @Override
    public RecycleTipDto updateTip(Long id, RecycleTipDto recycleTipDto) {
        RecycleTip recycleTip = getTipById(id);
        recycleTip.setTip(recycleTipDto.getTip());
        RecycleTip updatedRecycleTip = recycleTipRepository.save(recycleTip);
        return mapToDto(updatedRecycleTip);
    }

    @Override
    public void deleteTip(Long id) {
        recycleTipRepository.deleteById(id);
    }

    private RecycleTipDto mapToDto(RecycleTip recycleTip) {
        RecycleTipDto dto = new RecycleTipDto();
        dto.setId(recycleTip.getId());
        dto.setTip(recycleTip.getTip());
        return dto;
    }
}
