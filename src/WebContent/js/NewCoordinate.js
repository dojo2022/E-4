var table = document.getElementById("searchimage");
var tbody = document.getElementById("search-tbody");
var itemimage = document.getElementById("itemimage");
var selectitem = document.getElementById("selectitems");
var rowtbl = searchimage.rows.length;//縦
var celltbl = searchimage.rows[1].cells.length;//横
var num = [];
var numcnt=1;
var list = [];
var category = [];
var item_id = [];
var templist;
let macthcnt = 0;

for (i = 0; i < rowtbl; i++) {
    list[i] = [];
    num[i] = [];
    for (j = 0; j < celltbl; j++) {
    	numcnt = numcnt.toString();
        templist = table.rows[i].cells[j];
        if (templist !== undefined) { //全件取り終わるまで
        	num[i].push(numcnt);
            list[i].push(templist.children['itemimage'].attributes['src'].nodeValue); //画像パスが入っている（例 ././白シャツ.jpg)
            category.push(templist.children[1].attributes['value'].nodeValue); //カテゴリーが入っている（例 トップス）
            item_id.push(templist.children[0].attributes['value'].nodeValue);
        }
        numcnt++;
    }
}



/*[1]クリック時に実行する関数*/
function selectItem (e) {
    var imagename = e.target.getAttribute("name")

	var imagenameint = parseInt(imagename,10);
	console.log("選択した番号："+imagenameint);

	if(imagenameint%3==0){
		var imagevertical = Math.floor(imagenameint/3-1);
	}else{
		var imagevertical = Math.floor(imagenameint/3);
	}
	console.log("縦："+imagevertical);

	var imagebeside;
	switch(imagenameint%3){
		case 0:
			imagebeside = 2;
			break;
		case 1:
			imagebeside = 0;
			break;
		case 2:
			imagebeside = 1;
			break;
	}
	console.log("横："+imagebeside);

	var selectimage = list[imagevertical][imagebeside];
	selectitem.innerHTML += '<img src=' + selectimage + ' id = "itemimage">';

}
/*[2]IMG要素をすべてセレクト*/
var img = document.querySelectorAll("#itemimage");
img.forEach((imgElm) => {
    /*[3]要素のクリックイベントにイベントリスナーをひもづける*/
    imgElm.addEventListener('click', selectItem);
})

function itemsearch() {
    var checkcategory = []; //チェックボックスにチェックが入っている物の値をpushする配列
    var chk1 = document.coordinateregister.search_category; //form内のすべてのチェックボックスの情報

    for (let i = 0; i < chk1.length; i++) { //チェックボックスの数だけループ
        if (chk1[i].checked) { //(chk1[i].checked === true)と同じ。チェックボックスにチェックがある場合if文に入る
            checkcategory.push(chk1[i].value);//cheakcategoryにチェックが入っているもののvalueをpush
        }
    }

    document.querySelector('tbody').innerHTML = ""; //tbodyの中を全消去
    var html = ""; //innerHTMLの文を完成させるための変数
    var categorycnt = 0; //categryはiとjを使うと数字がおかしくなるためcategoryを紐づけるためのcount変数

    if (checkcategory.length == 0) { //何も選択がない場合、全アイテムを表示
        for (i = 0; i < list.length; i++) { //配列の行の数ループ（縦）
            for (j = 0; j < list[i].length; j++) { //配列の列の数ループ（横）
                if (j == 0) { //tableを三列ずつにしたいので j == 0
                    html += '<tr>';
                }

                html += '<td>';
                html += '<input type="hidden" value=' + item_id[categorycnt] + ' id = itemimage' + item_id[categorycnt] + '>';
                html += '<input type="hidden" value=' + category[categorycnt] + '>';
                html += '<img src=' + list[i][j] + ' id = "itemimage" name='+num[i][j]+'>';
                html += '</td>';

                if (j == 2) { //3列分で</tr>で次の行へ
                    html += '</tr>';
                }
                categorycnt++; //画像と対応させるため忘れずに+1
            }
        }
        tbody.innerHTML += html; //完成したinnerHTMLをする文をtbodyに挿入
        html = ""; //３列分ずつtbodyに挿入しているので中を空に
    }




    for (i = 0; i < list.length; i++) { //配列の行の数ループ（縦）
        for (j = 0; j < list[i].length; j++) { //配列の列の数ループ（横）
            if (macthcnt % 0) { //tableを三列ずつにしたいので j == 0
                html += '<tr>';
            }
            //次回はここにカテゴリーが選択された場合を書く
            if (checkcategory.includes('tops') == true) {
                if (category[categorycnt] == 'トップス') {
                    html += '<td>';
                    html += '<input type="hidden" value=' + item_id[categorycnt] + ' id = itemimage' + item_id[categorycnt] + '>';
                    html += '<input type="hidden" value=' + category[categorycnt] + '>';
                    html += '<img src=' + list[i][j] + ' id = "itemimage" name='+num[i][j]+'>';
                    html += '</td>';
                    macthcnt++;
                }
            }

            if (checkcategory.includes('outer') == true) {
                if (category[categorycnt] == 'アウター') {
                    html += '<td>';
                    html += '<input type="hidden" value=' + item_id[categorycnt] + ' id = itemimage' + item_id[categorycnt] + '>';
                    html += '<input type="hidden" value=' + category[categorycnt] + '>';
                    html += '<img src=' + list[i][j] + ' id = "itemimage" name='+num[i][j]+'>';
                    html += '</td>';
                    macthcnt++;
                }
            }

            if (checkcategory.includes('pants') == true) {
                if (category[categorycnt] == 'パンツ') {
                    html += '<td>';
                    html += '<input type="hidden" value=' + item_id[categorycnt] + ' id = itemimage' + item_id[categorycnt] + '>';
                    html += '<input type="hidden" value=' + category[categorycnt] + '>';
                    html += '<img src=' + list[i][j] + ' id = "itemimage" name='+num[i][j]+'>' ;
                    html += '</td>';
                    macthcnt++;
                }
            }

            if (checkcategory.includes('skirt') == true) {
                if (category[categorycnt] == 'スカート') {
                    html += '<td>';
                    html += '<input type="hidden" value=' + item_id[categorycnt] + ' id = itemimage' + item_id[categorycnt] + '>';
                    html += '<input type="hidden" value=' + category[categorycnt] + '>';
                    html += '<img src=' + list[i][j] + ' id = "itemimage" name='+num[i][j]+'>';
                    html += '</td>';
                    macthcnt++;
                }
            }

            if (checkcategory.includes('onepiece') == true) {
                if (category[categorycnt] == 'ワンピース') {
                    html += '<td>';
                    html += '<input type="hidden" value=' + item_id[categorycnt] + ' id = itemimage' + item_id[categorycnt] + '>';
                    html += '<input type="hidden" value=' + category[categorycnt] + '>';
                    html += '<img src=' + list[i][j] + ' id = "itemimage" name='+num[i][j]+'>';
                    html += '</td>';
                    macthcnt++;
                }
            }

            if (checkcategory.includes('shoes') == true) {
                if (category[categorycnt] == '靴') {
                    html += '<td>';
                    html += '<input type="hidden" value=' + item_id[categorycnt] + ' id = itemimage' + item_id[categorycnt] + '>';
                    html += '<input type="hidden" value=' + category[categorycnt] + '>';
                    html += '<img src=' + list[i][j] + ' id = "itemimage" name='+num[i][j]+'>';
                    html += '</td>';
                    macthcnt++;
                }
            }

            if (checkcategory.includes('accessories') == true) {
                if (category[categorycnt] == '小物') {
                    html += '<td>';
                    html += '<input type="hidden" value=' + item_id[categorycnt] + ' id = itemimage' + item_id[categorycnt] + '>';
                    html += '<input type="hidden" value=' + category[categorycnt] + '>';
                    html += '<img src=' + list[i][j] + ' id = "itemimage" name='+num[i][j]+'>';
                    html += '</td>';
                    macthcnt++;
                }
            }

            if (macthcnt == 3) { //3列分で</tr>で次の行へ
                html += '</tr>';
                tbody.innerHTML += html; //完成したinnerHTMLをする文をtbodyに挿入
                html = "";
                macthcnt = 0;
            }
            categorycnt++; //画像と対応させるため忘れずに+1
        }
    }
    tbody.innerHTML += html; //完成したinnerHTMLをする文をtbodyに挿入
    html = ""; //３列分ずつtbodyに挿入しているので中を空に
    html += '</tr>'; //一番最後に</tr>を
    tbody.innerHTML += html;
    macthcnt = 0;
    var img = document.querySelectorAll("#itemimage");

	img.forEach((imgElm) => {
    /*[3]要素のクリックイベントにイベントリスナーをひもづける*/
    imgElm.addEventListener('click', selectItem);
})
}





