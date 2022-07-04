package com.acme.hospedaje.hospe.mapping;

import com.acme.hospedaje.hospe.domain.model.entity.Hotel;
import com.acme.hospedaje.hospe.resource.CreateHotelResource;
import com.acme.hospedaje.hospe.resource.HotelResource;
import com.acme.hospedaje.hospe.resource.UpdateHotelResource;
import com.acme.hospedaje.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class HotelMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public HotelResource toResource(Hotel model) {
        return mapper.map(model, HotelResource.class);
    }

    public Page<HotelResource> modelListToPage(List<Hotel> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, HotelResource.class), pageable, modelList.size());
    }

    public List<HotelResource> modelListToResource(List<Hotel> modelList){return mapper.mapList(modelList, HotelResource.class); }

    public Hotel toModel(CreateHotelResource resource) {
        return mapper.map(resource, Hotel.class);
    }

    public Hotel toModel(UpdateHotelResource resource) {
        return mapper.map(resource, Hotel.class);
    }
}
