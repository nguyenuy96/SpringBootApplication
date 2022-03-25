package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "PROFILE")
@Entity
public class ProfileEntity {
    @Id
    private Long id;
}
