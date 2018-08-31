package com.ragul.springbootmongodemo;

import com.ragul.springbootmongodemo.model.Address;
import com.ragul.springbootmongodemo.model.Hotel;
import com.ragul.springbootmongodemo.model.Review;
import com.ragul.springbootmongodemo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    //    @Autowired
    private HotelRepository hotelRepository;

    public DbSeeder(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Hotel hotel1 = new Hotel(
                "hotel1",
                130,
                new Address("jaffna", "Sri Lanka"),
                Arrays.asList(
                        new Review("R1", 8, false),
                        new Review("R2", 4, false)
                )
        );
        Hotel hotel2 = new Hotel(
                "hotel2",
                110,
                new Address("jaffna1", "Sri Lanka"),
                Arrays.asList(
                        new Review("R1", 1, false),
                        new Review("R2", 7, false)
                )
        );
        Hotel hotel3 = new Hotel(
                "hotel2",
                180,
                new Address("jaffna2", "Sri Lanka"),
                new ArrayList<>()
        );
        this.hotelRepository.deleteAll();
        List<Hotel> hotels =Arrays.asList(hotel1,hotel2,hotel3);
        hotelRepository.saveAll(hotels);

    }
}
