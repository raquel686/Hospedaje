package com.acme.hospedaje.hospe.api;

import com.acme.hospedaje.hospe.domain.service.HotelService;
import com.acme.hospedaje.hospe.mapping.HotelMapper;
import com.acme.hospedaje.hospe.resource.CreateHotelResource;
import com.acme.hospedaje.hospe.resource.HotelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelMapper mapper;

    @GetMapping
    public List<HotelResource> getAllHotels() {
        return mapper.modelListToResource(hotelService.getAll());
    }

    @GetMapping("{hotelId}")
    public HotelResource getHotelById(@PathVariable("hotelId") Long hotelId) {
        return mapper.toResource(hotelService.getById(hotelId));
    }

    @PostMapping
    public HotelResource createHotel(@RequestBody CreateHotelResource request) {

        return mapper.toResource(hotelService.create(mapper.toModel(request)));
    }



}
