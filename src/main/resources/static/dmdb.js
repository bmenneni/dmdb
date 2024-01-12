function submitSearch() {
	console.log("Successful click of submit button.");
	
	var civilization = document.getElementById("civ").value;
	var card_type = document.getElementById("type").value;
	var keywords = document.getElementById("keyword").value;
	var categories = document.getElementById("category").value;
	var cost = document.getElementById("cost").value;
	var rarity = document.getElementById("rarity").value;
	var card_set = document.getElementById("set").value;
	
	var url;
	
	if(window.location.href.includes("search")) {
		url = "search?";
	}
	else url = "dmdb/search?";
	
	if(civilization && civilization !== "Select Civilization" && civilization !== "all_civs") {
		url += "civilization=" + civilization + "&";
	}
	
	if(cost && cost !== "Select Cost" && cost !== "all_costs") {
		url += "cost=" + cost + "&";
	}
	
	if(keywords && keywords !== "Select Keyword" && keywords !== "all_keywords") {
		url += "keywords=" + keywords + "&";
	}

	if(categories && categories !== "Select Category" && categories !== "all_categories") {
		url += "categories=" + categories + "&";
	}
	
	if(card_set && card_set !== "Select Set" && card_set !== "all_sets") {
		url += "card_set=" + card_set + "&";
	}
	
	if(card_type && card_type !== "Select Type" && card_type !== "all_types") {
		url += "card_type=" + card_type + "&";
	}

	if(rarity && rarity !== "Select Rarity" && rarity !== "all_rarities") {
		url += "rarity=" + rarity + "&";
	}
	
	window.location.href = url;
}

function openCardImage(rowElement) {
	var card_id = rowElement.getAttribute('data-card-id');
	if(card_id<10) {
		card_id = "00" + card_id;
	}
	else if(card_id<100) {
		card_id = "0" + card_id;
	}
	var imageUrl = "/images/cards/" + card_id + ".jpg";
	window.open(imageUrl, '_blank');
}