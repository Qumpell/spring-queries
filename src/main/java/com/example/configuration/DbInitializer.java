package com.example.configuration;

import com.example.model.Address;
import com.example.model.Client;
import com.example.repository.AddressRepository;
import com.example.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

import static com.example.repository.ClientRepository.*;



@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
@AllArgsConstructor
//@Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
public class DbInitializer implements CommandLineRunner {
    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;

    @Override
    public void run(String... args) throws Exception {
        Client client1 = new Client("Adam", "Kowalski","012345678");
        Client client2 = new Client("Jane","Zabsaw","12345678");
        Client client3 = new Client("Max","Zabsaw","012345679");
        Client client4 = new Client("Steve","Wonder","98765432");
        Client client5 = new Client("Steve","Wonder","67693232");


        Address address1 = new Address("Poland");
        Address address2 = new Address("Belgium");
        Address address3 = new Address("Netherlands");
        Address address4 = new Address("Germany");
        Address address5 = new Address("USA");
        Address address6 = new Address("Canada");
        Address address7 = new Address("Spain");
//        client1.setAddress(address1);
//        client2.setAddress(address2);
//        client3.setAddress(address3);
//        address1.setClient(client1);
//        address2.setClient(client2);
//        address3.setClient(client3);
        client1.setAddressSet(Set.of(address1,address2));
        client2.setAddressSet(Set.of(address3));
        client3.setAddressSet(Set.of(address4,address5));
        client4.setAddressSet(Set.of(address6));
        client5.setAddressSet(Set.of(address7));

//        addressRepository.saveAll(List.of(address1, address2, address3, address4, address5));
        clientRepository.saveAll(List.of(client1, client2, client3,client4,client5));

//        clientRepository.findAll().forEach(c -> System.out.println(c.getAddressSet()));
//        addressRepository.deleteById(1L);

//        clientRepository.deleteById(1L);
   //     System.out.println(clientRepository.findAll());
//        client1.setAddressSet(Collections.emptySet());
//        clientRepository.delete(client1);
//        System.out.println(clientRepository.findById(6L));
//        addressRepository.deleteById(1L);
//        System.out.println(clientRepository.findAll());

     //   System.out.println(clientRepository.findAllUsersByName("Jane"));

       // System.out.println(clientRepository.findAll(hasName("Steve").and(hasSurname("Wonder").and(hasPesel("67693232")))));

        var onePesel = clientRepository.exists(hasName("Steve"));
        System.out.println(onePesel);

     //   System.out.println(clientRepository.findAll(hasCountry("Poland")));
    }
}