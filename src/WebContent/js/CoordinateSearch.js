'use strict';
document.getElementById("CoordinateSearch").style.display ="none";
const CoordinateSearch = document.getElementById("CoordinateSearch");
const search_button = document.getElementById("search_button");
function SearchButton(){
	CoordinateSearch.style.display ="block";
	search_button.style.display ="none";
}
function CancelButton(){
	CoordinateSearch.style.display ="none";
	search_button.style.display ="block";
}