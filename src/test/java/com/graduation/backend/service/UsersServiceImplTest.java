package com.graduation.backend.service;

import com.graduation.backend.BackendApplication;
import com.graduation.backend.dto.TravelTipsDto;
import com.graduation.backend.dto.UsersDto;
import com.graduation.backend.exceptions.RecordNotFoundException;
import com.graduation.backend.model.Users;
import com.graduation.backend.repository.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@ContextConfiguration(classes = {BackendApplication.class})
class UsersServiceImplTest {


    @Autowired
    private UsersService service;

    @MockBean
    private UsersRepository repos;


    @Mock
    UsersDto usersDto;

    @Mock
    Users users;

    @Mock
    TravelTipsDto tipsDto;



//    @Test
//    void createUsers() {
//        Mockito
//                .when(repos.save(users))
//                .thenReturn(users);
//
//        UsersDto expected = usersDto;
//
//        UsersDto found = service.createUsers(usersDto);
//
//        assertEquals(expected, found);
//    }

//    @Test
//    void getUsers() {
//        Mockito
//                .when(repos.findAll())
//                .thenReturn(List.of(users));
//
//        List<UsersDto> expected = new ArrayList<>();
//        expected.add(usersDto);
//
//        List<UsersDto> found = service.getUsers();
//
//        assertEquals(expected, found);
//    }

//    @Test
//    void testFindUsersByIdAndReturnUsersDto() {
//        Mockito
//                .when(repos.findById(usersDto.getId()))
//                .thenReturn(Optional.of(users));
//
//
//
//        Long id = 1001L;
//        UsersDto expected = usersDto;
//        RecordNotFoundException expectedError = new RecordNotFoundException("user not found");
//
//        UsersDto found =  service.getUsersById(id);
//
//
//        assertEquals(expected, found);
//
//    }
//
//    @Test
//    void getTravelTips() {
//        List<TravelTipsDto> tdto = new ArrayList<>();
//        TravelTipsDto tips1 = new TravelTipsDto(1083L, 'Test', 'Test country', 'Test ville', 'Testing goes bananas');
//        TravelTipsDto tips2 = new TravelTipsDto(1084L, 'Testing', 'Testille', 'Testeratos', 'Testing is not my thing, need to have more time to understand');
//        tdto.add(tips1);
//        tdto.add(tips2);
//
//        Mockito
//                .when(repos.findById(usersDto.getId()))
//                .thenReturn(Optional.of(users));
//
//        Long id = 1083L;
//        List<TravelTipsDto> expected = tdto;
//
//        List<TravelTipsDto> found = service.getTravelTips(1001L);
//    }

//    @Test
//    void updateUsers() {
//        UsersDto user = new UsersDto(2001L, "Frits", "Smeets", "frits@info.nl", "Rijksweg", 44, "6121RE", "Maastricht", null);
//
//        Mockito
//                .when(repos.findById(usersDto.getId()))
//                .thenReturn(Optional.of(users));
//
//        UsersDto expected = user;
//        UsersDto found = service.updateUsers(user, usersDto.getId());
//        assertEquals(expected.getFirstname(), found.getFirstname());
//        assertEquals(expected.getLastname(), found.getLastname());
//        assertEquals(expected.getEmail(), found.getEmail());
//        assertEquals(expected.getStreet(), found.getStreet());
//        assertEquals(expected.getHousenumber(), found.getHousenumber());
//        assertEquals(expected.getZipcode(), found.getZipcode());
//        assertEquals(expected.getCity(), found.getCity());
//        assertEquals(expected.getFavorites(), found.getFavorites());
//    }

    @Test
    void deleteUsers() {
        Mockito
                .when(repos.findById(usersDto.getId()))
                .thenReturn(Optional.of(users));
        UsersDto expected = usersDto;
        UsersDto found = service.deleteUsers(usersDto.getId());

        assertEquals(expected.getFavorites(), found.getFavorites());
    }
}