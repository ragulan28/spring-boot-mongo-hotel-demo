package com.ragul.springbootmongodemo.controller;

import com.ragul.springbootmongodemo.model.Hotel;
import com.ragul.springbootmongodemo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private HotelRepository hotelRepository;

    @Autowired
    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/")
    public List<Hotel> getAll() {
        List<Hotel> hotels = this.hotelRepository.findAll();

        return hotels;
    }

    @PutMapping
    public void insert(@RequestBody Hotel hotel) {
        this.hotelRepository.insert(hotel);

    }

    @PostMapping
    public void update(@RequestBody Hotel hotel) {
        this.hotelRepository.save(hotel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.hotelRepository.deleteById(id);
    }

    @GetMapping("{id}")
    public Optional<Hotel> findById(@PathVariable String id) {
        Optional<Hotel> hotel = this.hotelRepository.findById(id);
        return hotel;
    }

    @GetMapping("/price/{maxPrice}")
    public List<Hotel> findByPricePerNightLessThan(@PathVariable int maxPrice) {
        List<Hotel> hotels = this.hotelRepository.findByPricePerNightLessThan(maxPrice);
        return hotels;
    }

    @GetMapping("/address/{city}")
    public List<Hotel> findByCity(@PathVariable String city) {
        List<Hotel> hotels = this.hotelRepository.findByCity(city);
        return hotels;
    }
}
