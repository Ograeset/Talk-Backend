package com.ograeset.talkbackend.controller;

import com.ograeset.talkbackend.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RestController
@RequestMapping("/entry")
public class EntryController {

    private final EntryService entryService;



    @Autowired
    public EntryController (EntryService entryService) {
        this.entryService = entryService;;




    }
}


