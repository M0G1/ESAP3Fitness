package com.example.esap3fitness.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator", sequenceName = "training_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "traning_name")
    private String trainingName;

    @Column(name = "traner_name")
    private String trainerName;

    private Integer minutes;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;


    public Training() {
    }

    ;

    public Training(String trainingName, String trainerName, Integer minutes) {
        this.trainingName = trainingName;
        this.trainerName = trainerName;
        this.minutes = minutes;
    }

    ;

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public Long getId() {
        return id;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }
}
