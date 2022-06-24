var table = document.getElementById("searchimage");
var tbody = document.getElementById("search-tbody");
var itemimage = document.getElementById("itemimage");
var rowtbl = searchimage.rows.length;//縦
var celltbl = searchimage.rows[1].cells.length;//横
var list = [];
var category = [];
var templist;
let macth=[];
for(i=0; i<rowtbl; i++){
	list[i] = [];
	for(j=0; j<celltbl; j++){
		templist = table.rows[i].cells[j];
		if(templist!==undefined){
			list[i].push(templist.children['itemimage'].attributes['src'].nodeValue);
			category.push(templist.children[0].attributes['value'].nodeValue);
		}
		 //console.log(templist.children[0].attributes['value'].nodeValue);
	}
}



function itemsearch(){
    document.querySelector('tbody').innerHTML="";
    var html="";
    var categorycnt=0;
	//var search_category = document.coordinateregister.search_category;
    for(i=0;i<list.length;i++){
    	for(j=0;j<list[i].length;j++){
	        if(j%3==0){
	        	html+='<tr>';
	        }
	        html+='<td>';
	        html+='<input type="hidden" value=' + category[categorycnt] + '>';
	        html+='<img src=' + list[i][j] + ' id = "itemimage">';
	        html+='</td>';
		    if((j+1)%3==0){
		    	if(j!=0){
		        	html+='</tr>';
		        }
	        }
	        categorycnt++;

	    }
	    		    tbody.innerHTML += html;
		        	console.log(html);
		        	html = "";
    }
    html+='</tr>';
		//tbody.innerHTML += html;
}