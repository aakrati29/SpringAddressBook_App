package com.spring.addressBookApp.services;

import com.spring.addressBookApp.dto.AddressBookDto;
import com.spring.addressBookApp.model.AddressBookModel;
import com.spring.addressBookApp.repository.AddressBookRepo;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {
    final AddressBookRepo addressBookRepo;
    AddressBookService(AddressBookRepo addressBookRepo){
        this.addressBookRepo = addressBookRepo;
    }

    public AddressBookModel add(AddressBookDto addressBookDto){
        AddressBookModel addressBook = new AddressBookModel();
        addressBook.setName(addressBookDto.getName());
        addressBook.setPhoneNumber(addressBookDto.getPhoneNumber());
        return addressBookRepo.save(addressBook);
    }

    public List<AddressBookModel> getAllContacts(){
        return addressBookRepo.findAll();
    }

    public AddressBookModel getById(Long id){
        return addressBookRepo.findById(id).orElseThrow(()-> new RuntimeException("Exception Handle"));
    }

    public Optional<AddressBookModel> updateContact(Long id, AddressBookDto addressBookDto) {
        return addressBookRepo.findById(id).map(contact -> {
            contact.setName(addressBookDto.getName());
            contact.setPhoneNumber(addressBookDto.getPhoneNumber());
            return addressBookRepo.save(contact);
        });
    }

    public Optional<AddressBookModel> getContactById(Long id) {
        return addressBookRepo.findById(id);
    }

    public boolean deleteContact(Long id){
        if(addressBookRepo.existsById(id)){
            addressBookRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
