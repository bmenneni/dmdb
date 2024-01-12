package us.duelmasters.dmdb.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import us.duelmasters.dmdb.models.Card;

public class CardRowMapper implements RowMapper<Card>{

	public Card mapRow(ResultSet rs, int rowNum) throws SQLException {
		Card card = new Card();
		card.setCard_id(rs.getInt("card_id"));
		card.setCard_name(rs.getString("card_name"));
		card.setCard_set(rs.getString("card_set"));
		card.setCard_type(rs.getString("card_type"));
		card.setColl_num(rs.getString("coll_num"));
		card.setCost(rs.getInt("cost")); //cost cannot be null
		card.setCivilization(rs.getString("civilization"));
		card.setRarity(rs.getString("rarity"));
		card.setRace(rs.getString("race")); //race can be null
		if(!(card.getCard_type().equals("Spell"))) {
			card.setPower(rs.getInt("power")); //power can be null
		}
		card.setKeywords(rs.getString("keywords")); //keywords can be null
		card.setCategories(rs.getString("categories")); //categories can be null
		return card;
	}
	
}
