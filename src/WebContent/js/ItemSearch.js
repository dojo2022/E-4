'use strict';
document.getElementById("ItemSearch").style.display ="none";
const ItemSearch = document.getElementById("ItemSearch");
const search_button = document.getElementById("search_button");
function SearchButton(){
	ItemSearch.style.display ="block";
	search_button.style.display ="none";
}
function CancelButton(){
	ItemSearch.style.display ="none";
	search_button.style.display ="block";
}