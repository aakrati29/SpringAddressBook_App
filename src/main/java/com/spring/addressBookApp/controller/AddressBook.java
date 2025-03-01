package com.spring.addressBookApp.controller;

import com.spring.addressBookApp.dto.AddressBookDto;
import com.spring.addressBookApp.model.AddressBookModel;
import com.spring.addressBookApp.services.AddressBookService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/addressbook")
public class AddressBook {
    AddressBookService addressBookService;

    AddressBook(AddressBookService addressBookService){
        this.addressBookService =addressBookService;
    }

    @PostMapping("/add")
    public AddressBookModel add(@RequestBody AddressBookDto addressBookDto){
        return addressBookService.add(addressBookDto);
    }

    @GetMapping("/{id}")
    public AddressBookModel getById(@PathVariable Long id){
        return addressBookService.getById(id);
    }

    @PutMapping("/put/{id}")
    public Optional<AddressBookModel> updateContact(@PathVariable Long id, @RequestBody AddressBookDto addressBookDto){
        return addressBookService.updateContact(id, addressBookDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteContact(@PathVariable Long id){
         addressBookService.deleteContact(id);
    }
}
