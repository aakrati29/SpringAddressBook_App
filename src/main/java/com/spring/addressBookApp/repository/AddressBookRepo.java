package com.spring.addressBookApp.repository;

import com.spring.addressBookApp.model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepo extends JpaRepository<AddressBookModel, Long> {
}
