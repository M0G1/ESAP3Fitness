package com.example.esap3fitness.repository;

import com.example.esap3fitness.model.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymRepository extends JpaRepository<Gym,Long> {
}
