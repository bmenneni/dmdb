package us.duelmasters.dmdb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import us.duelmasters.dmdb.models.Card;

@Repository
public interface DmdbRepository extends CrudRepository<Card, Integer> {

//	@Query("SELECT * FROM CARD WHERE card_id = :card_id AND " +
//		   "card_set = :card_set AND " +
//		   "card_name = :card_name AND " +
//		   "cost = :cost AND " +
//		   "civilization = :civilization AND " +
//		   "card_type = :card_type AND " +
//		   "(:race IS NULL OR race = :race) AND " +
//		   "(:power IS NULL OR power = :power) AND " +
//		   "rarity = :rarity AND " +
//		   "(:keywords IS NULL OR keywords LIKE '%'||:keywords||'%') AND " +
//		   "(:categories IS NULL OR categories LIKE '%'||:categories||'%')")
//	List<Card> findCards(@Param("card_id") Integer card_id,
//						 @Param("card_set") String card_set,
//						 @Param("card_name") String card_name,
//						 @Param("cost") Integer cost,
//						 @Param("civilization") String civilization,
//						 @Param("card_type") String card_type,
//						 @Param("race") String race,
//						 @Param("power") Integer power,
//						 @Param("rarity") String rarity,
//						 @Param("keywords") String keywords,
//						 @Param("categories") String categories);
	
}
