package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
