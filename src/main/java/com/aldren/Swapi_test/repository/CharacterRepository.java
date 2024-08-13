package com.aldren.Swapi_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aldren.Swapi_test.model.CharacterEntity;

public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {

}
