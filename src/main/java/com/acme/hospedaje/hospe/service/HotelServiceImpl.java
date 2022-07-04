package com.acme.hospedaje.hospe.service;

import com.acme.hospedaje.hospe.domain.model.entity.Hotel;
import com.acme.hospedaje.hospe.domain.persistence.HotelRepository;
import com.acme.hospedaje.hospe.domain.service.HotelService;
import com.acme.hospedaje.shared.exception.ResourceNotFoundException;
import com.acme.hospedaje.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class HotelServiceImpl implements HotelService {

    private static final String ENTITY = "Hotel";

    private final HotelRepository hotelRepository;

    private final Validator validator;

    public HotelServiceImpl(HotelRepository hotelRepository, Validator validator) {
        this.hotelRepository = hotelRepository;
        this.validator = validator;
    }


    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Page<Hotel> getAll(Pageable pageable) {
        return hotelRepository.findAll(pageable);
    }

    @Override
    public Hotel getById(Long hotelId) {
        return hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, hotelId));
    }

    @Override
    public Hotel create(Hotel request) {
        Set<ConstraintViolation<Hotel>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return hotelRepository.save(request);
    }

    @Override
    public Hotel update(Long hotelId, Hotel request) {

        Set<ConstraintViolation<Hotel>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return hotelRepository.findById(hotelId).map(hotel ->
                hotelRepository.save(
                    hotel.withTitle(request.getTitle())
                        .withDescription(request.getDescription())
                        .withContent(request.getContent()))
            ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, hotelId));
    }

    @Override
    public ResponseEntity<?> delete(Long hotelId) {
        return hotelRepository.findById(hotelId).map(hotel -> {
                hotelRepository.delete(hotel);
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, hotelId));
    }
}
