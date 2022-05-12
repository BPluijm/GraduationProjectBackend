//package com.graduation.backend;
//
//import com.graduation.backend.model.Users;
//import com.graduation.backend.repository.UsersRepository;
//import com.graduation.backend.service.UsersService;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ContextConfiguration;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest()
//@ContextConfiguration(classes= {BackendApplication.class})
//public class UsersServiceTest {
//
//        @Autowired
//        UsersService service;
//
//        @MockBean
//        UsersRepository repos;
//
//        @Mock
//        Users users;
//
//        @Test
//        public void testAddCustomer(){
//
//            Users user = new Users();
//            user.username("Bart");
//            user.password("pannenkoek");
//            user.firstname("Bart");
//            user.lastname("Bartjes");
//            user.email("info@bart.nl");
//            user.street("Rijksweg");
//            user.housenumber("23");
//            user.zipcode("2636KB");
//            user.city("Rotterdam");
//            user.setId(12L);
//
//            Mockito
//                    .when(repos.save(user))
//                    .thenReturn(user);
//
//            Long expect = user.getId();
//            Long found = service.createUsers(user);
//
//            assertEquals(expect, found);
//        }
//
//}
