package com.sanish.spring_data_jpa_demo.entities.resource_types;


import com.sanish.spring_data_jpa_demo.entities.Resource;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
//@DiscriminatorValue("V") - Only for Single table strategy
@PrimaryKeyJoinColumn(name = "video_id") //- Only for joined strategy
@Entity
public class Video extends Resource {
    private Integer video_length;
}
