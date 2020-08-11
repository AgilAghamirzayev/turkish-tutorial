package com.example.datajpa.service.impl;

import com.example.datajpa.dto.PersonDTO;
import com.example.datajpa.entity.Address;
import com.example.datajpa.entity.Person;
import com.example.datajpa.repository.AddressRepository;
import com.example.datajpa.repository.PersonRepository;
import com.example.datajpa.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public PersonDTO save(PersonDTO personDTO) {
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setLastName(personDTO.getLastName());
        Person save = personRepository.save(person);

        List<Address> list = new ArrayList<>();

        personDTO.getAddresses().forEach(item -> {
                    Address address = new Address();
                    address.setAddress(item);
                    address.setAddressTip(Address.AddressTip.OTHER);
                    address.setActive(true);
                    address.setPerson(save);
                    list.add(address);
                });

        addressRepository.saveAll(list);
        personDTO.setId(person.getId());

        return personDTO;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<PersonDTO> getAll() {
        List<Person> people = personRepository.findAll();
        List<PersonDTO> personDTOS = new ArrayList<>();

        people.forEach( item -> {
                    PersonDTO persondto = new PersonDTO();
                    persondto.setId(item.getId());
                    persondto.setName(item.getName());
                    persondto.setLastName(item.getLastName());
                    persondto.setAddresses(item.getAddresses().stream().map(Address::getAddress)
                    .collect(Collectors.toList()));
                    personDTOS.add(persondto);
                });

        System.out.println(personDTOS);

        return personDTOS;
    }

    @Override
    public Page<PersonDTO> getAll(Pageable pageable) {
        return null;
    }
}
