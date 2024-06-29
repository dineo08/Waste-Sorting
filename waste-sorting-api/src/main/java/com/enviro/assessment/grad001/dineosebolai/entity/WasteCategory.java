package com.enviro.assessment.grad001.dineosebolai.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class WasteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String category;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    private DisposalGuideline disposalGuideline;

    public WasteCategory() {
    }

    public WasteCategory(Long id, String category, DisposalGuideline disposalGuideline) {
        this.id = id;
        this.category = category;
        this.disposalGuideline = disposalGuideline;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DisposalGuideline getDisposalGuideline() {
        return disposalGuideline;
    }

    public void setDisposalGuideline(DisposalGuideline disposalGuideline) {
        this.disposalGuideline = disposalGuideline;
    }
}

