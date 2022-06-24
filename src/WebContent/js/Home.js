 $('.slider').slick({
    speed:800,//スライドの動きのスピード。初期値は300。
    infinite: true,//スライドをループさせるかどうか。初期値はtrue。
    slidesToShow: 1,//スライドを画面に3枚見せる
    slidesToScroll: 1,//1回のスクロールで3枚の写真を移動して見せる
    arrows: true,//左右の矢印あり
    prevArrow: '<div class="slick-prev"></div>',//矢印部分PreviewのHTMLを変更
    nextArrow: '<div class="slick-next"></div>',//矢印部分NextのHTMLを変更
    dots: true,//下部ドットナビゲーションの表示
        pauseOnFocus: false,//フォーカスで一時停止を無効
        pauseOnHover: false,//マウスホバーで一時停止を無効
        pauseOnDotsHover: false,//ドットナビゲーションをマウスホバーで一時停止を無効
    });

//スマホ用：スライダーをタッチしても止めずにスライドをさせたい場合
$('.slider').on('touchmove', function(event, slick, currentSlide, nextSlide){
    $('.slider').slick('slickPlay');
});

/*function clickSwitch() {
	'use strict';

	var isbusiness = 0; // 現在地判定
	var btnbusiness = document.getElementById('business');
	var btncasual = document.getElementById('casual');
	var divswitch1 = document.getElementById('switch1');
	var divswitch2 = document.getElementById('switch2');

	function setState(isbusiness) {
		btnbusiness.className = (isbusiness == 0) ? 'btn inactive' : 'btn'; // Aのとき非表示
		divswitch1.className = (isbusiness == 0) ? 'boxDisplay' : 'boxNone'; // Aのとき表示
		btncasual.className = (isbusiness == 1) ? 'btn inactive' : 'btn'; // Bのとき非表示
		divswitch2.className = (isbusiness == 1) ? 'boxDisplay' : 'boxNone'; // Bのとき表示
	}
	setState(0);


	btnbusiness.addEventListener('click', function(){
		if (isbusiness == 0) return;
		isbusiness = 0;
		setState(0);
	});

	btncasual.addEventListener('click', function(){
		if (isbusiness == 1) return;
		isbusiness = 1;
		setState(1);
	});
};
//document.addEventListener("DOMContentLoaded", clickSwitch, false);


var toggle = document.getElementById("count_up");
var count_value =0;

toggle.onclick = function (){
	count_value += 1;
};*/