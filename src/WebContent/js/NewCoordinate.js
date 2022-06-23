var image = document.getElementById("uploadimage");
var imageError1 = document.getElementById("imageError");
var imageplace = document.getElementById("imageplace");
var div1 = document.getElementById("div1");

function imageError(){
	var src = uploadimage.getAttribute("src");
	if(src === "././image/白.jpg"){
		document.querySelector('#error2').remove();
		imageError1.innerHTML += "<div class = imageError><p id = error2>画像を挿入してください</p></div>"

	}
}

function buttonClick(){
	const div1 = document.getElementById("div1");
	if(!div1.hasChildNobes()){
		div11.innerHTML += "<div class = imageError><p id = error2>画像を挿入してください</p></div>"
	}
}


