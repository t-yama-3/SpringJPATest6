package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Title;

public interface TitleRepository extends JpaRepository<Title, Long> {
}
