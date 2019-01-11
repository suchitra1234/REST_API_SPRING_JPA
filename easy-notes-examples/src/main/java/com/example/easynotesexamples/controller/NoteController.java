package com.example.easynotesexamples.controller;

import com.example.easynotesexamples.exceptions.ResourceNotFoundException;
import com.example.easynotesexamples.model.Notes;
import com.example.easynotesexamples.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {
	
	@Autowired
	NoteRepository noteRepository;
	
	//Get  all Notes
	@GetMapping ("/notes")
	public List<Notes> getAllNotes(){
		
		return noteRepository.findAll();
	}
	
	//Create a new Note
	@PostMapping("/notes")
	public Notes createNotes(@Valid @RequestBody Notes note){
		return noteRepository.save(note);
	}
	
	// Get a Single Note
	@GetMapping("/notes/{id}")
	public Notes getNoteById(@PathVariable(value = "id") Long noteId) {
	    return noteRepository.findById(noteId)
	            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
	}
	
	// Update a Note
	@PutMapping("/notes/{id}")
	public Notes updateNote(@PathVariable(value = "id") Long noteId,
	                                        @Valid @RequestBody Notes noteDetails) {

	    Notes note = noteRepository.findById(noteId)
	            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

	    note.setTitle(noteDetails.getTitle());
	    note.setContent(noteDetails.getContent());

	    Notes updatedNote = noteRepository.save(note);
	    return updatedNote;
	}
	
	// Delete a Note
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
	    Notes note = noteRepository.findById(noteId)
	            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

	    noteRepository.delete(note);

	    return ResponseEntity.ok().build();
	}
	
	// EXTERNAL TOMCAT TEST METHOD
	   @RequestMapping("/external-tomcat")
	   public String printMessage() {
	        return "Hey, I am from external tomcat";
	   }
	
}
