package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "PROFILE")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ProfileEntity extends CommonEntity {
    @Id
    private Long id;
    private String fullName;
    private String lastName;
    private String phoneNumber;
    private String address;
}
