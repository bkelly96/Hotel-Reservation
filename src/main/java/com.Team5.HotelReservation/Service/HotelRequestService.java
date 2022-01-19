package com.Team5.HotelReservation.Service;

import com.Team5.HotelReservation.model.Hotel;
import org.springframework.data.domain.Page;

public interface HotelRequestService {
    Page<Hotel> findPaginated(int pageNumber, int pageSize);
    Hotel findByIdentificationNumber(long id);
    Hotel save(Hotel hotel);
    boolean deleteAsset(long id);
    Hotel updateHotel(Hotel updateSave);

}
