package com.example.jpa.team.domain;

import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Participants {

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "participant",
            joinColumns = @JoinColumn(name = "team_id", nullable = false, foreignKey = @ForeignKey(name = "fk_team_participant")))
    private List<Participant> value;
}
