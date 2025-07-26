package com.shikhar.JournalApp.controller;

import com.shikhar.JournalApp.entity.Journal;
import com.shikhar.JournalApp.entity.User;
import com.shikhar.JournalApp.repository.JournalRepository;
import com.shikhar.JournalApp.service.JournalService;
import com.shikhar.JournalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalService journalService;
    @Autowired
    private JournalRepository journalRepository;
    @Autowired
    private UserService userService;

    @PostMapping("/{username}")
    public ResponseEntity<Journal> createEntry(@RequestBody Journal journal, @PathVariable String username){
       try {
           journalService.saveEntry(journal , username);
           return new ResponseEntity<>(journal,HttpStatus.CREATED);
       } catch (Exception e){
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping("{username}")
    public ResponseEntity<List<Journal>> findAllJournalEntriesFromUser(@PathVariable String username){
        User user = userService.findByUserName(username);
        List<Journal> all = user.getJournal();
        if(all!=null && !all.isEmpty()){
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Journal> findById(@PathVariable ObjectId id){
        Optional<Journal> journal = journalService.findbyID(id);
        if(journal.isPresent()){
            return new ResponseEntity<>(journal.get(), HttpStatus.OK);

        }
        return new ResponseEntity<>(journal.get(), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{username}/{id}")
    public ResponseEntity<?> deletejournalById(@PathVariable ObjectId id, @PathVariable String username){
        journalService.deleteById(id, username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{username}/{id}")
    public ResponseEntity<Journal> updateById(
            @PathVariable ObjectId id ,
            @RequestBody Journal newEntry,
            @PathVariable String username
    ){
        Journal old = journalService.findbyID(id).orElse(null);
        if(old!=null){
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
            journalService.saveEntry(old);
            return new ResponseEntity<>(old,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
