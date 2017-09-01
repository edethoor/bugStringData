package com.example.demo.dao;

import com.example.demo.pojo.EnvoiEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnvoiEntryRepository extends MongoRepository<EnvoiEntry, String>, EnvoiEntryRepositoryCustom {
}
