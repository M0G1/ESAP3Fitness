package com.example.esap3fitness.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class SeasonPass {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator", sequenceName = "season_pass_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "duration_m")
    private Integer durationM;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;


    public Gym getGym() {
        return gym;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getDurationM() {
        return durationM;
    }

    public void setDurationM(Integer durationM) {
        this.durationM = durationM;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    public Long getId() {
        return id;
    }

    public SeasonPass() {
    };

    public SeasonPass(String fullName, Integer durationM) {
        this.durationM = durationM;
        this.fullName = fullName;
    };
}
