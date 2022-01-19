package com.Team5.HotelReservation.Service;

import com.Team5.HotelReservation.model.Hotel;
import com.Team5.HotelReservation.repository.HotelPaginatedRepository;
import com.Team5.HotelReservation.repository.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelRequestServiceImplementation implements HotelRequestService {

    @Autowired
    private  final HotelRepository hotelRepository;

    @Autowired
    private final HotelPaginatedRepository paginatedRepository;

    public HotelRequestServiceImplementation(HotelRepository hotelRepository, HotelPaginatedRepository paginatedRepository) {
        this.hotelRepository = hotelRepository;
        this.paginatedRepository = paginatedRepository;
    }

    //refine this to be more specific, potentially
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Page<Hotel> findPaginated(int pageNumber, int pageSize) {
        Pageable paging = PageRequest.of(pageNumber,pageSize);
        return paginatedRepository.findAll(paging);
    }

    @Override
    public Hotel findByIdentificationNumber(long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    @Override
    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public boolean deleteAsset(long id) {
        Hotel hotel = this.hotelRepository.findById(id).orElse(null);
        if(hotel == null){
            return false;
        }else{
            this.hotelRepository.delete(hotel);
            return true;
        }
    }

    @Override
    public Hotel updateHotel(Hotel updateSave) {
        return hotelRepository.save(updateSave);
    }
}


