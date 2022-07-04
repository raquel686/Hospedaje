package com.acme.hospedaje.hospe.domain.service;

import com.acme.hospedaje.hospe.domain.model.entity.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HotelService {
    List<Hotel> getAll();
    Page<Hotel> getAll(Pageable pageable);
    Hotel getById(Long hotelId);
    Hotel create(Hotel hotel);
    Hotel update(Long hotelId, Hotel request);
    ResponseEntity<?> delete(Long hotelId);
}
