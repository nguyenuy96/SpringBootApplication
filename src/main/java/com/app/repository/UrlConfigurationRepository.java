package com.app.repository;

import com.app.entity.UrlConfigurationEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlConfigurationRepository extends JpaRepository<UrlConfigurationEntity, Long> {
    Optional<UrlConfigurationEntity> findByRequestApi(String requestApi);
}
