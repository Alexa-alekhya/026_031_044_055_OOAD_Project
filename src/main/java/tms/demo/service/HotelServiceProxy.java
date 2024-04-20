package tms.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import tms.demo.model.Hotel;

@Service
@CacheConfig(cacheNames = "hotelsCache")
public class HotelServiceProxy implements HotelService {

    private final HotelService hotelService;

    @Autowired
    public HotelServiceProxy(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @Override
    @Cacheable(key = "'allHotels'")
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }
}