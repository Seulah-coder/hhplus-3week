
package com.hhplus.hhplus3week.app.concert.models;

import com.hhplus.hhplus3week.app.concertSchedule.models.ConcertSchedule;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "concert")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Concert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=100)
    private String name;

    @Column(length=100)
    private String singer;

    @OneToMany(mappedBy = "concert", fetch = FetchType.LAZY)
    private List<ConcertSchedule> concertSchedules;
}
