package com.example.demo.dao;

import com.example.demo.pojo.EnvoiEntry;
import com.mongodb.WriteResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class EnvoiEntryRepositoryImpl implements EnvoiEntryRepositoryCustom {

	private MongoTemplate mongoTemplate;

	public EnvoiEntryRepositoryImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override public int customUpdate(String envoiId, EnvoiEntry envoiEntry) {
		Query query = new Query();
		CriteriaDefinition criteriaDefinition = Criteria.where("_id").is(envoiId);
		query.addCriteria(criteriaDefinition);

		Update update = new Update();
		update.set("recipients", envoiEntry.getRecipients());
		WriteResult result = mongoTemplate.updateFirst(query, update, EnvoiEntry.class);
		return result.getN();
	}
}
