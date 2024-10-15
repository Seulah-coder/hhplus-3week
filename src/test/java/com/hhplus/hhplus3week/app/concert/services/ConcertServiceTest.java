package com.hhplus.hhplus3week.app.concert.services;

import com.hhplus.hhplus3week.app.concert.models.Concert;
import com.hhplus.hhplus3week.app.concert.repositories.ConcertRepository;
import com.hhplus.hhplus3week.app.concertSchedule.models.ConcertSchedule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ConcertServiceTest {

    @InjectMocks
    private ConcertService concertService;

    @Mock
    private ConcertRepository concertRepository;


    @Test
    @DisplayName("콘서트 저장")
    void saveConcert() {

        Concert concert = Concert.builder()
                    .id(1L)
                    .name("testConcert")
                    .singer("IU")
                    .build();

        when(concertRepository.save(concert)).thenReturn(concert);
        Concert result = concertService.saveConcert(concert);

        assertNotNull(result);
        assertEquals(concert.getId(), result.getId());

        verify(concertRepository).save(concert);

    }

    @Test
    @DisplayName("콘서트 조회")
    void getConcertById() {
        Concert concert = Concert.builder()
                .id(1L)
                .name("testConcert")
                .singer("IU")
                .build();


        when(concertRepository.findById(1L)).thenReturn(Optional.of(concert));

        Concert findConcert = concertService.getConcertById(1L);

        assertNotNull(findConcert);
        assertEquals(concert.getId(), findConcert.getId());

        verify(concertRepository).findById(1L);
    }

    @Test
    @DisplayName("콘서트와 콘서트 스케줄 조회")
    void getConcertWithSchedulesById_existingId_returnsConcertWithSchedules() {
        // Arrange
        Long concertId = 1L;

        ConcertSchedule schedule1 = ConcertSchedule.builder()
                .id(1L)
                .build();

        ConcertSchedule schedule2 = ConcertSchedule.builder()
                .id(2L)
                .build();

        List<ConcertSchedule> scheduleList = new ArrayList<>();
        scheduleList.add(schedule1);
        scheduleList.add(schedule2);

        Concert expectedConcert = Concert.builder()
                .id(concertId)
                .name("test")
                .singer("testSinger")
                .concertSchedules(scheduleList)
                .build();


        when(concertRepository.findByIdWithSchedules(concertId)).thenReturn(expectedConcert);

        // Act
        Concert result = concertService.getConcertWithSchedulesById(concertId);

        for(int i=0; i<result.getConcertSchedules().size(); i++) {
            System.out.println("i = " + result.getConcertSchedules().get(i).getId());
        }

        // Assert
        assertNotNull(result);
        assertEquals(concertId, result.getId());
        assertEquals("test", result.getName());
        assertEquals("testSinger", result.getSinger());
        assertNotNull(result.getConcertSchedules());
        assertFalse(result.getConcertSchedules().isEmpty());

        verify(concertRepository).findByIdWithSchedules(concertId);
    }
}