package com.exercise_2.Exercise2.repository;

import com.exercise_2.Exercise2.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOwnerRepository extends JpaRepository<Owner, Long> {
}