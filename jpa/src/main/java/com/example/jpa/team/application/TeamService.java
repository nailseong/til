package com.example.jpa.team.application;

import com.example.jpa.team.domain.Team;
import com.example.jpa.team.domain.TeamRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public List<Team> findAll() {
        return teamRepository.findAll();
    }
}
