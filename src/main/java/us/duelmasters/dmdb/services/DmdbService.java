package us.duelmasters.dmdb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import us.duelmasters.dmdb.dto.CardSearchCriteriaDTO;
import us.duelmasters.dmdb.models.Card;
import us.duelmasters.dmdb.repositories.CardRowMapper;
import us.duelmasters.dmdb.repositories.DmdbRepository;

@Service
public class DmdbService {
	
	@Autowired
	private final DmdbRepository dmdbRepository;
	private final NamedParameterJdbcTemplate jdbcTemplate;
	
	public DmdbService(DmdbRepository repository, NamedParameterJdbcTemplate template) {
		dmdbRepository = repository;
		jdbcTemplate = template;
	}
	
	public List<Card> findCards(CardSearchCriteriaDTO criteria) {
		List<String> whereClauses = new ArrayList<>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		if(criteria.getCard_name() != null) {
			whereClauses.add("card_name LIKE '%'||:card_name||'%'");
			parameters.addValue("card_name", criteria.getCard_name());
		}
		if(criteria.getCard_set() != null) {
			whereClauses.add("card_set = :card_set");
			parameters.addValue("card_set", criteria.getCard_set());
		}
		if(criteria.getCard_type() != null) {
			whereClauses.add("card_type = :card_type");
			parameters.addValue("card_type", criteria.getCard_type());
		}
		if(criteria.getCivilization() != null) {
			whereClauses.add("civilization = :civilization");
			parameters.addValue("civilization", criteria.getCivilization());
		}
		if(criteria.getRace() != null) {
			whereClauses.add("race = :race");
			parameters.addValue("race", criteria.getRace());
		}
		if(criteria.getCost() != null) {
			whereClauses.add("cost = :cost");
			parameters.addValue("cost", criteria.getCost());
		}
		if(criteria.getRarity() != null) {
			whereClauses.add("rarity = :rarity");
			parameters.addValue("rarity", criteria.getRarity());
		}
		if(criteria.getKeywords() != null) {
			whereClauses.add("keywords LIKE '%'||:keywords||'%'");
			parameters.addValue("keywords", criteria.getKeywords());
		}
		if(criteria.getCategories() != null) {
			whereClauses.add("categories LIKE '%'||:categories||'%'");
			parameters.addValue("categories", criteria.getCategories());
		}
		
		String baseSQLquery = "SELECT * FROM CARD";
		String whereClause = String.join(" AND ", whereClauses);
		String finalSQLquery = whereClauses.isEmpty() ? baseSQLquery : baseSQLquery + " WHERE " + whereClause;
		
		return jdbcTemplate.query(finalSQLquery, parameters, new CardRowMapper());
	}
	
	//using Crud Repository for basic "Find All" operation
	public Iterable<Card> getAllCards() {
		return dmdbRepository.findAll();
	}
	
}
