package com.Team5.HotelReservation.Service;


import com.Team5.HotelReservation.model.User;
import org.springframework.data.domain.Page;

public interface UserRequestService {
    Page<User> findPaginated(int pageNumber, int pageSize);
    User findByIdentificationNumber(long id);
    User save(User user);
    boolean deleteAsset(long id);
    User updateHotel(User updateSave);
}
