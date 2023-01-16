package com.example.myanimelistdemo1.repos;

import com.example.myanimelistdemo1.entity.Title;
import com.example.myanimelistdemo1.entity.enums.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TitleDAO extends JpaRepository<Title, Long> {
    @Override
    Page<Title> findAll(Pageable pageable);

    @Query(value = "SELECT rating_list FROM user_rating_list where rating_list_key = ?1",nativeQuery = true)
    List<Double> reviewsByTitle(Long titleId);

    Page<Title> findAllByGenreOrderByRatingDesc(Genre genre, Pageable pageable);

    Optional<Title> findTitleByName(String name);

    @Query("select t from Title t where upper(t.name) like upper(concat('%', ?1, '%'))")
    Page<Title> findTitlesByNameContainingIgnoreCase(String name, Pageable pageable);
}
