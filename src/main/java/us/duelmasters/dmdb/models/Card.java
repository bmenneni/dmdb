package us.duelmasters.dmdb.models;

import org.springframework.data.annotation.Id;

public class Card {
	
	@Id
	private int card_id;
	
	private String coll_num;
	private String card_set;
	private String card_name;
	private int cost;
	private String civilization;
	private String card_type;
	private String race; //can be null
	private Integer power; //can be null
	private String rarity;
	private String keywords; //can be null
	private String categories; //can be null
	
	//default no-args constructor
		public Card() {
		
	}
	
	//test constructor (no keywords or categories) 
		public Card(int card_id, String coll_num, String card_set, String card_name, int cost, String civilization,
				String card_type, String race, Integer power, String rarity) {
			this.card_id = card_id;
			this.coll_num = coll_num;
			this.card_set = card_set;
			this.card_name = card_name;
			this.cost = cost;
			this.civilization = civilization;
			this.card_type = card_type;
			this.race = race;
			this.power = power;
			this.rarity =  rarity;
	}

	//constructor for card types with no race or power value, e.g. spells
		public Card(int card_id, String coll_num, String card_set, String card_name, int cost, 
				String civilization, String card_type, String rarity, String keywords, String categories) {
			this.card_id = card_id;
			this.coll_num = coll_num;
			this.card_set = card_set;
			this.card_name = card_name;
			this.cost = cost;
			this.civilization = civilization;
			this.card_type = card_type;
			this.rarity = rarity;
			this.keywords = keywords;
			this.categories = categories;
	}
		
	//standard constructor for most cards
		public Card(int card_id, String coll_num, String card_set, String card_name, int cost, 
				String civilization, String card_type, String race, Integer power, String rarity,
				String keywords, String categories) {
			this.card_id = card_id;
			this.coll_num = coll_num;
			this.card_set = card_set;
			this.card_name = card_name;
			this.cost = cost;
			this.civilization = civilization;
			this.card_type = card_type;
			this.race = race;
			this.rarity = rarity;
			this.power = power;
			this.keywords = keywords;
			this.categories = categories;
	}
	
	public int getCard_id() {
		return card_id;
	}
	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}
	public String getColl_num() {
		return coll_num;
	}
	public void setColl_num(String coll_num) {
		this.coll_num = coll_num;
	}
	public String getCard_set() {
		return card_set;
	}
	public void setCard_set(String card_set) {
		this.card_set = card_set;
	}
	public String getCard_name() {
		return card_name;
	}
	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getCivilization() {
		return civilization;
	}
	public void setCivilization(String civilization) {
		this.civilization = civilization;
	}
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public Integer getPower() {
		return power;
	}
	public void setPower(Integer power) {
		this.power = power;
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
