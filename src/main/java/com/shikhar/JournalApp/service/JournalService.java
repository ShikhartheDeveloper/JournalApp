package com.shikhar.JournalApp.service;

import com.shikhar.JournalApp.entity.Journal;
import com.shikhar.JournalApp.entity.User;
import com.shikhar.JournalApp.repository.JournalRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(Journal journal , String username){
        try{
            User user = userService.findByUserName(username);
            journal.setDate(LocalDateTime.now());
            Journal saved = journalRepository.save(journal);
            user.getJournal().add(saved);
            userService.saveUser(user);
        } catch(Exception e){
            System.out.println(e);
            throw new RuntimeException("An error occur while saving the entry");
        }

    }

    public void saveEntry(Journal journal){
        journalRepository.save(journal);
    }

    public List<Journal> getAll(){
        return journalRepository.findAll();
    }

    public Optional<Journal> findbyID(ObjectId id){
       return journalRepository.findById(id);
    }

    public void deleteById(ObjectId id, String username){
        User user = userService.findByUserName(username);
        user.getJournal().removeIf(x-> x.getId().equals(id));
        userService.saveUser(user);
        journalRepository.deleteById(id);
    }

}
