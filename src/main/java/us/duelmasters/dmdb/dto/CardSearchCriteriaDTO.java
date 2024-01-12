package us.duelmasters.dmdb.dto;

public class CardSearchCriteriaDTO {
	
	private String card_name;
	private String card_set;
	private String card_type;
	private String civilization;
	private String race;
	private Integer cost;
	private String rarity;
	private String keywords;
	private String categories;
	
	public String getCard_name() {
		return card_name;
	}
	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}
	public String getCard_set() {
		return card_set;
	}
	public void setCard_set(String card_set) {
		this.card_set = card_set;
	}
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public String getCivilization() {
		return civilization;
	}
	public void setCivilization(String civilization) {
		this.civilization = civilization;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getRarity() {
		return rarity;
	}
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}

}
