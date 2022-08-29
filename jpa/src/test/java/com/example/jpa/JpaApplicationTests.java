package com.example.jpa;

import com.example.jpa.member.domain.Member;
import com.example.jpa.member.domain.MemberRepository;
import com.example.jpa.team.application.TeamService;
import com.example.jpa.team.domain.Participant;
import com.example.jpa.team.domain.Participants;
import com.example.jpa.team.domain.Team;
import com.example.jpa.team.domain.TeamRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
class JpaApplicationTests {

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Commit
    @Test
    @DisplayName("테스트")
    void test() {
        // given
        final Member rick = memberRepository.save(new Member("릭", 111, "릭.com"));
        final Member roma = memberRepository.save(new Member("로마", 222, "로마.com"));
        final Member alien = memberRepository.save(new Member("알린", 333, "알린.com"));

        final Participants participants = new Participants(List.of(new Participant(rick, true, false),
                new Participant(roma, false, false),
                new Participant(alien, false, true)
        ));
        final Team team = new Team("hello", "hello - place", LocalDateTime.now(), "hello - profile", 1, false, false,
                participants);
        teamRepository.save(team);

        // when
        teamService.findAll();

        // then

    }
}
