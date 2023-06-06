package com.ograeset.talkbackend.repository;

import com.ograeset.talkbackend.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Long> {
}
