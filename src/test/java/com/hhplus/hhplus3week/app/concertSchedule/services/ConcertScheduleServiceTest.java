package com.hhplus.hhplus3week.app.concertSchedule.services;

import com.hhplus.hhplus3week.app.concertSchedule.dto.ConcertScheduleRequestDTO;
import com.hhplus.hhplus3week.app.concertSchedule.dto.ConcertScheduleSaveDTO;
import com.hhplus.hhplus3week.app.concertSchedule.models.ConcertSchedule;
import com.hhplus.hhplus3week.app.concertSchedule.repositories.ConcertScheduleRepository;
import com.hhplus.hhplus3week.app.seat.models.Seat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConcertScheduleServiceTest {

    @InjectMocks
    private ConcertScheduleService concertScheduleService;

    @Mock
    private ConcertScheduleRepository concertScheduleRepository;

    @Test
    @DisplayName("콘서트 스케줄 저장")
    void saveConcertSchedule() {
        LocalDateTime ticketDate = LocalDateTime.of(2024, 11, 30, 0, 0, 0);
        LocalDateTime releaseDate = LocalDateTime.of(2024, 12, 30, 9, 0 ,0);


        ConcertSchedule concertSchedule = ConcertSchedule.builder()
                .concertPlace("일산 킨텍스")
                .id(1L)
                .ticketOpenDate(ticketDate)
                .concertOpenDate(releaseDate)
                .build();

        ConcertScheduleSaveDTO dto = new ConcertScheduleSaveDTO();
        dto.setConcertId(1L);
        dto.setConcertPlace("일산 킨텍스");
        dto.setTicketOpenDate(ticketDate);
        dto.setConcertOpenDate(releaseDate);
        dto.setTotalSeatNumber(50);

        when(concertScheduleRepository.save(concertSchedule)).thenReturn(concertSchedule);
        ConcertSchedule concertSchedule1 = concertScheduleService.saveConcertSchedule(dto);

        assertNotNull(concertSchedule1);
        assertEquals(concertSchedule1.getId(), concertSchedule.getId());

        verify(concertScheduleRepository).save(concertSchedule);


    }

    @Test
    @DisplayName("콘서트 스케줄 조회")
    void getConcertScheduleById() {

        LocalDateTime ticketDate = LocalDateTime.of(2024, 11, 30, 0, 0, 0);
        LocalDateTime releaseDate = LocalDateTime.of(2024, 12, 30, 9, 0 ,0);


        ConcertSchedule concertSchedule = ConcertSchedule.builder()
                .concertPlace("일산 킨텍스")
                .id(1L)
                .ticketOpenDate(ticketDate)
                .concertOpenDate(releaseDate)
                .build();

        when(concertScheduleRepository.findById(1L)).thenReturn(Optional.ofNullable(concertSchedule));

        ConcertSchedule findConcertSchedule = concertScheduleService.getConcertScheduleById(1L);

        assertNotNull(concertSchedule);
        assertEquals(concertSchedule.getId(), findConcertSchedule.getId());
        assertEquals("일산 킨텍스", findConcertSchedule.getConcertPlace());

        verify(concertScheduleRepository).findById(1L);
    }

    @Test
    @DisplayName("콘서트 스케줄로 좌석 조회")
    void getConcertScheduleByIdWithSeats() {

        LocalDateTime ticketDate = LocalDateTime.of(2024, 11, 30, 0, 0, 0);
        LocalDateTime releaseDate = LocalDateTime.of(2024, 12, 30, 9, 0 ,0);

        Seat seatOne = Seat.builder()
                .seatNumber(1L)
                .price(134000)
                .seatStatus("reserved")
                .id(1L)
                .build();

        Seat seatTwo = Seat.builder()
                .seatNumber(2L)
                .price(134000)
                .seatStatus("reserved")
                .id(2L)
                .build();

        List<Seat> seatList = new ArrayList<>();
        seatList.add(seatOne);
        seatList.add(seatTwo);


        ConcertSchedule concertSchedule = ConcertSchedule.builder()
                .concertPlace("일산 킨텍스")
                .id(1L)
                .ticketOpenDate(ticketDate)
                .concertOpenDate(releaseDate)
                .seatList(seatList)
                .build();

        when(concertScheduleRepository.findByIdWithSeats(1L)).thenReturn(concertSchedule);

        ConcertScheduleRequestDTO dto = new ConcertScheduleRequestDTO();
        dto.setConcertId(1L);
        dto.setToken("test");
        dto.setUserId(1L);
        dto.setSelectedDate(LocalDateTime.of(2024, 10, 17, 0, 0, 0));

        ConcertSchedule concertSchedule1 = concertScheduleService.getConcertScheduleByIdWithAvailableSeats(dto);

        for(int i=0; i<concertSchedule1.getSeatList().size(); i++){
            System.out.println("i = " + concertSchedule1.getSeatList().get(i).getId());
        }

        assertNotNull(concertSchedule1);
        assertEquals(concertSchedule1.getSeatList().get(0).getId(), seatOne.getId());
        assertEquals(concertSchedule1.getSeatList().get(1).getId(), seatTwo.getId());

        verify(concertScheduleRepository).findByIdWithSeats(1L);
    }
}