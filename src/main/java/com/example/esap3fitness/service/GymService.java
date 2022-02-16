package com.example.esap3fitness.service;

import com.example.esap3fitness.model.Gym;
import com.example.esap3fitness.model.SeasonPass;
import com.example.esap3fitness.repository.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GymService {
    @Autowired
    GymRepository gymRepository;

    public void create(Gym gym) {
        gymRepository.save(gym);
    }

    public Gym get(Long id) {
        return gymRepository.findById(id).get();
    }

    public List<Gym> getAll() {
        return gymRepository.findAll().stream().sorted(Comparator.comparing(Gym::getAddress)).collect(Collectors.toList());
    }

    public void update(Long id, Gym newGym) {
        Gym gym = gymRepository.findById(id).get();
        gym.setGymNum(newGym.getGymNum());
        gym.setAddress(newGym.getAddress());
        gym.setOpenTime(newGym.getOpenTime());
        gymRepository.save(gym);
        // не умеем ставить id так бы покороче было бы
    }

    public void delete(Long id) {
        gymRepository.deleteById(id);
    }

    public List<SeasonPass> getSeasonPasses(Long id) {
        Gym gym = gymRepository.findById(id).get();
        return gym.getPasses().stream().sorted(Comparator.comparing(SeasonPass::getFullName)).collect(Collectors.toList());
    }
}
