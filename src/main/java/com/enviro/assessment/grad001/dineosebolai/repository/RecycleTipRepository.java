package com.enviro.assessment.grad001.dineosebolai.repository;

import com.enviro.assessment.grad001.dineosebolai.entity.RecycleTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecycleTipRepository extends JpaRepository<RecycleTip, Long> {
}
