package com.example.esap3fitness.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator",  sequenceName = "course_id_seq", allocationSize = 1)
    private Long id;

    private String address;

    @Column(name = "open_time")
    private String openTime;


    @OneToMany(mappedBy = "gym", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<SeasonPass> passes = new HashSet<>();

    @OneToMany(mappedBy = "gym", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Training> trainings = new HashSet<>();

    public Gym(){};

    public Gym(String address,String openTime){
        this.address = address;
        this.openTime = openTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public Set<SeasonPass> getPasses() {
        return passes;
    }

    public void setPasses(Set<SeasonPass> passes) {
        this.passes = passes;
    }

    public Set<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(Set<Training> trainings) {
        this.trainings = trainings;
    }

    public Long getId() {
        return id;
    }
}
