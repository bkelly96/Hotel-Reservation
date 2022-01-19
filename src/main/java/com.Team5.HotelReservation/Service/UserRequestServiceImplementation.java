package com.Team5.HotelReservation.Service;

import com.Team5.HotelReservation.model.User;
import com.Team5.HotelReservation.repository.UserPaginatedRepository;
import com.Team5.HotelReservation.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserRequestServiceImplementation implements UserRequestService {

    @Autowired
    private  final UserRepository userRepository;

    @Autowired
    private final UserPaginatedRepository userPaginatedRepository;

    public UserRequestServiceImplementation(UserRepository userRepository, UserPaginatedRepository userPaginatedRepository) {
        this.userRepository = userRepository;
        this.userPaginatedRepository = userPaginatedRepository;
    }

/*    public User getUserById(long id){
        return userRepository.findById(id).orElse(null);
        }*/

    @Override
    public Page<User> findPaginated(int pageNumber, int pageSize) {
        Pageable paging = PageRequest.of(pageNumber,pageSize);
        return userPaginatedRepository.findAll(paging);
    }

    @Override
    public User findByIdentificationNumber(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean deleteAsset(long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user == null){
            return false;
        }else{
            userRepository.delete(user);
            return true;
        }
    }

    @Override
    public User updateHotel(User updateSave) {
        return userRepository.save(updateSave);
    }
}


