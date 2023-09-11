//package com.example.integration;
//
//import com.example.model.Address;
//import com.example.model.Client;
//import com.example.repository.AddressRepository;
//import com.example.repository.ClientRepository;
//import com.example.service.impl.ClientServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.Optional;
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//public class ClientServiceTest {
//    @Autowired
//    private ClientServiceImpl clientService;
//    @Autowired
//    private ClientRepository clientRepository;
//    @Autowired
//    private AddressRepository addressRepository;
//    private Client client1;
//    private Address address1;
//    private Address address2;
//
//    @BeforeEach
//    void setUp() {
//        address1 = Address.builder().country("Poland").build();
//        address2 = address1.toBuilder().build();
//
//
//        client1 = Client.builder()
//                .name("Adam")
//                .surname("Kowalski")
//                .peselNumber("012345678")
//                .build();
//        client1.setAddressSet(Set.of(address1, address2));
//        clientRepository.save(client1);
//    }
//
//    @Test
//    public void testAddressDeletionFromClient() {
//        //given
//
//        //when
////        when(clientRepository.findById(client1.getId())).thenReturn();
//        //then
//        clientService.removeAddressFromClient(client1.getId(), address1.getId());
//        clientRepository.findById(client1.getId()).ifPresent(updatedClient -> assertEquals(1, updatedClient.getAddressSet().size()));
//    }
//    @Test
//    public void whenAddressIsRemovedFromClient_ThenAddressIsRemovedFromDatabase() {
//        //given
//        //when
//        clientService.removeAddressFromClient(client1.getId(), address1.getId());
//        //then
//        Optional<Address> addressFromDatabase = addressRepository.findById(address1.getId());
//        assertTrue(addressFromDatabase.isEmpty());
//    }
//
//}