package com.samuelHCB.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    private String orderNumber;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<OrderLineItems> orderLineItems = new ArrayList<>();

}
