package com.sanish.spring_data_jpa_demo.entities.resource_types;

import com.sanish.spring_data_jpa_demo.entities.Resource;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@DiscriminatorValue("F")
@Entity
public class File extends Resource {
    private String file_type;
}
