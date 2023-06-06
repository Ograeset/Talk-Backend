package com.ograeset.talkbackend.service;

import com.ograeset.talkbackend.model.Entry;
import com.ograeset.talkbackend.repository.EntryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EntryService {

    private final EntryRepository entryRepository;

    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }


    public ResponseEntity<Entry> addNewEntry(Entry entry) {
        Entry newEntry = new Entry();
        EntryRepository.save(newEntry);

        return new ResponseEntity<Entry>(entry, HttpStatus.OK);

    }
}
