package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "URL_CONFIGURATION")
public class UrlConfigurationEntity {
    @Id
    private Long id;
    private String requestApi;
    private String requestUrl;
}
