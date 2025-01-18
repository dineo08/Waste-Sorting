package com.enviro.assessment.grad001.dineosebolai.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DisposalGuidelineDto {
    @NotNull
    private Long id;
    @NotBlank
    private String description;
    @NotNull
    private Long wasteCategoryId;
}
