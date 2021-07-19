package com.renanmateus.comic.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renanmateus.comic.domain.model.Comics;

@Repository
public interface ComicRepository extends JpaRepository<Comics, Long> {

}
