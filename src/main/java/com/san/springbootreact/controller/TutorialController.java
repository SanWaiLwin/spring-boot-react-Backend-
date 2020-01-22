package com.san.springbootreact.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.san.springbootreact.model.Tutorial;
import com.san.springbootreact.service.TutorialService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
@RequestMapping("/api/auth/all")
public class TutorialController {

	@Autowired
	private TutorialService tutorialService;

    @GetMapping("/tutorials")
    public ResponseEntity<Iterable<Tutorial>> findAll() {
        return ResponseEntity.ok(tutorialService.findAll());
    }

    @PostMapping("/tutorials")
    public ResponseEntity create(@Valid @RequestBody Tutorial tutorial) {
        return ResponseEntity.ok(tutorialService.save(tutorial));
    }

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> findById(@PathVariable Integer id) {
        Optional<Tutorial> tutorial = tutorialService.findById(id);
        if (!tutorial.isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(tutorial.get());
    }

    @PutMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> update(@PathVariable Integer id, @Valid @RequestBody Tutorial tutorial) {
        if (!tutorialService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(tutorialService.save(tutorial));
    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        if (!tutorialService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }

        tutorialService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
