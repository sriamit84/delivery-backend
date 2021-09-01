package com.fresure.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {


    private Integer addressId;

    private String addrFirstLine;

    private String addrSecondLine;

    private String locality;

    private String landMark;

    private String city;

    private String pinCode;

}
