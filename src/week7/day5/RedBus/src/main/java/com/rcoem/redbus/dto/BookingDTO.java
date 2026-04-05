package com.rcoem.redbus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    private List<Long> passengerIds;
    private LocalDate date;
    private Integer seats;
    public Long bus_id;
}
