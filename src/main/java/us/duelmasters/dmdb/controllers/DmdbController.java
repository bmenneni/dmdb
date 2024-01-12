package us.duelmasters.dmdb.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import us.duelmasters.dmdb.dto.CardSearchCriteriaDTO;
import us.duelmasters.dmdb.models.Card;
import us.duelmasters.dmdb.repositories.DmdbRepository;
import us.duelmasters.dmdb.services.DmdbService;

@Controller
public class DmdbController {
	
	public static final Logger logger = LoggerFactory.getLogger(DmdbController.class);
	
	private final DmdbService dmdbService;
	
	public DmdbController(DmdbService dmdbService) {
		this.dmdbService = dmdbService;
	}
	
	@Autowired
	private DmdbRepository dmdbRepository;
	
	@GetMapping("/dmdb")
	public String showDmdbForm() {
		return "dmdb";
	}
	
	@GetMapping("/dmdb/search")
	public String getSearchResults(Model model,
								   @RequestParam(required = false) String card_name,
								   @RequestParam(required = false) String card_set,
								   @RequestParam(required = false) String card_type,
								   @RequestParam(required = false) String civilization,
								   @RequestParam(required = false) String race,
								   @RequestParam(required = false) Integer cost,
								   @RequestParam(required = false) String rarity,
								   @RequestParam(required = false) String keywords,
								   @RequestParam(required = false) String categories) {
		
	    //logger.info("Searching for cards with cost: {}", cost);

	    //logger.debug("Executing SQL query with parameters: cost={}", cost);
	    
	    CardSearchCriteriaDTO criteria = new CardSearchCriteriaDTO();
	    
	    if(card_name != null) {
	    	criteria.setCard_name(card_name);
	    }
	    if(card_set != null) {
	    	criteria.setCard_set(card_set);
	    }
	    if(card_type != null) {
	    	criteria.setCard_type(card_type);
	    }
	    if(civilization != null) {
	    	criteria.setCivilization(civilization);
	    }
	    if(race != null) {
	    	criteria.setRace(race);
	    }
	    if(cost != null) {
	    	criteria.setCost(cost);
	    }
	    if(rarity != null) {
	    	criteria.setRarity(rarity);
	    }
	    if(keywords != null) {
	    	criteria.setKeywords(keywords);
	    }
	    if(categories != null) {
	    	criteria.setCategories(categories);
	    }
		
	    List<Card> cardSearchResults = dmdbService.findCards(criteria);
	    
	    //logger.info("Found {} cards.", cardSearchResults.size());

		//searchResults will be added to model, and "results" attribute will be iterated over in the search-results.html...
		//...Thymeleaf template to produce view that displays all search results to user.
		model.addAttribute("results", cardSearchResults);
		return "search-results";
	}
	
//	@GetMapping("/dmdb/test")
//	public String testSearch(Model model) {
//		List<Card> testSearchResults = Arrays.asList(
//				new Card(28, "18/110", "DM-01", "Senatine Jade Tree", 3, "Light", "Creature", "Starlight Tree", 4000, "C", "hi", "okay"),
//				new Card(41, "31/110", "DM-01", "Hunter Fish", 2, "Water", "Creature", "Fish", 3000, "C", "okay", "hi"),
//				new Card(125, "S5/S5", "DM-02", "Fighter Dual Fang", 6, "Nature", "Evolution", "Beast Folk", 8000, "S", "super", "dopey")
//				);
//		
//		model.addAttribute("results", testSearchResults);
//		return "search-results";
//	}
	
	@GetMapping("dmdb/search/all")
	public String getAllCards(Model model) {
		Iterable<Card> cards = dmdbRepository.findAll();
		List<Card> cardList = new ArrayList<>();
		cards.forEach(cardList::add);
		
		model.addAttribute("results", cardList);
		return "search-results";
	}
	
}

