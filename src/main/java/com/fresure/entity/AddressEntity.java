package com.fresure.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id",updatable = false, nullable = false)
    private Integer addressId;

    @Column(name = "addr_first_line")
    private String addrFirstLine;

    @Column(name = "addr_second_line")
    private String addrSecondLine;

    @Column(name = "locality")
    private String locality;

    @Column(name = "landmark")
    private String landMark;

    @Column(name = "city")
    private String city;

    @Column(name = "pincode")
    private String pinCode;

}
