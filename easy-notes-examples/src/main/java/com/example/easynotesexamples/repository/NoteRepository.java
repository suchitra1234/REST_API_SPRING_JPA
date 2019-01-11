package com.example.easynotesexamples.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.easynotesexamples.model.Notes;

@Repository
public interface NoteRepository extends JpaRepository<Notes,Long>{

}
