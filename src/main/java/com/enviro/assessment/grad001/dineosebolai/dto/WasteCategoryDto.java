package com.enviro.assessment.grad001.dineosebolai.dto;

import com.enviro.assessment.grad001.dineosebolai.entity.DisposalGuideline;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WasteCategoryDto {
    @NotNull
    private Long id;
    @NotBlank
    private String category;
}
