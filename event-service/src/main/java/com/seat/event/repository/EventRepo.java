package com.seat.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.seat.event.model.EventEntity;

import java.sql.Date;
import java.util.List;

@Repository

public interface EventRepo extends JpaRepository<EventEntity, String>{
    EventEntity findByEventId(String eventId);

    List<EventEntity> findByCategoryName(String categoryName);
    EventEntity findByTitleAndCategoryName(String title, String categoryName);

    @Query("select distinct e FROM EventEntity e left join e.venues v left join v.slots s " + 
    "where (:title is null or lower(e.title) like lower(concat('%', :title, '%'))) " +
    "and (:language is null or lower(e.language) = lower(:language)) " +
    "and (:venueName is null or lower(v.venueName) = lower(:venueName)) " +
    "and (:location is null or lower(v.location) = lower(:location)) " +
    "and (:date is null OR s.date = :date)"+
    "and (:categoryName is null or lower(e.categoryName) = lower(:categoryName))")

    List<EventEntity> findFilteredEvents(
        @Param("title") String title,
        @Param("language") String language,
        @Param("venueName") String venueName,
        @Param("location") String location,
        @Param("date") Date date,
        @Param("categoryName") String categoryName
);
}
