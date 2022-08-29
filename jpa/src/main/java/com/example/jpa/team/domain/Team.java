package com.example.jpa.team.domain;

import com.example.jpa.common.domain.BaseEntity;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE team SET deleted = true WHERE id=?")
public class Team extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String place;

    @Column(nullable = false)
    private LocalDateTime startAt;

    @Column(nullable = false, length = 2048)
    private String profileUrl;

    @Column(nullable = false)
    private int interviewerNumber;

    @Column(nullable = false)
    private boolean isClosed;

    @Column(nullable = false)
    private boolean deleted;

    @Embedded
    private Participants participants;
}
