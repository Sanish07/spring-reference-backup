package com.sanish.spring_data_jpa_demo.entities.embedded;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_tbl")
public class Order {

    @EmbeddedId
    private OrderId id;

    private String orderInfo;

    @Embedded
    private Address address;
}
