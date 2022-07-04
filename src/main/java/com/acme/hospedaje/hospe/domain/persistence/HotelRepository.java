package com.acme.hospedaje.hospe.domain.persistence;

import com.acme.hospedaje.hospe.domain.model.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
