package com.app.repository;

import com.app.entity.ProfileEntity;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
    List<ProfileEntity> findByFirstName(String firstName);
    Page<ProfileEntity> findByLastName(String lastName, Pageable pageable);
    @Query(value = "SELECT * FROM PROFILE WHERE LAST_NAME = :lastName ORDER BY ?#{#pageable}", nativeQuery = true)
    Page<ProfileEntity> findByNativeQuerySampleWithPaging(@Param("lastName") String lastName, Pageable pageable);
}
