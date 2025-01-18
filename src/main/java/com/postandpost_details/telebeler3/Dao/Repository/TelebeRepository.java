package com.postandpost_details.telebeler3.Dao.Repository;

import com.postandpost_details.telebeler3.Dao.Entity.TelebeEntity;
import com.postandpost_details.telebeler3.Model.Enum.TelebeStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TelebeRepository extends CrudRepository<TelebeEntity,Long> {
    Optional<TelebeEntity> findById(Long id);

}
