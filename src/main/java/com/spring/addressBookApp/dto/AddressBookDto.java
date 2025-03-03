package com.spring.addressBookApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDto {
    private Long id;
    private String name;
    private String phoneNumber;
}
