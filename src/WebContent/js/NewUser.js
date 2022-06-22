'use strict';


/*function CheckPassword(confirm){
	// 入力値取得
	var input1 = password.value;
	var input2 = confirm.value;
	// パスワード比較
	if(input1 != input2){
		confirm.setCustomValidity("入力値が一致しません。");
	}else{
		confirm.setCustomValidity('');
	}
}*/

//.validationForm を指定した（最初の）要素を取得
const validationForm = document.querySelector('.validationForm');
//equal-to クラスを指定された要素の集まり
const equalToElems = document.querySelectorAll('.equal-to');

//form 要素の submit イベントを使った送信時の処理
validationForm.addEventListener('submit', (e) => {
  //エラーの初期化
  const errorElems = e.currentTarget.querySelectorAll('.error');
  errorElems.forEach( (elem) => {
    elem.remove();
  });

  //.equal-to を指定した要素を検証
  equalToElems.forEach( (elem) => {
    //比較対象の要素の id
    const equalToId = elem.getAttribute('data-equal-to');
    //または const equalToId = elem.dataset.equalTo;
    //比較対象の要素
    const equalToElem = document.getElementById(equalToId);
    //値が空でなければ
    if(elem.value.trim() !=='' && equalToElem.value.trim() !==''){
      //2つの値（value）が一致しなければエラーを表示して送信を中止
      if(equalToElem.value !== elem.value) {
        createError(elem, '入力された値が異なります');
        e.preventDefault();
      }
    }
  });
});

//エラーメッセージを表示する span 要素を生成して親要素に追加する関数
const createError = (elem, errorMessage) => {
  const errorSpan = document.createElement('span');
  errorSpan.classList.add('error');
  errorSpan.setAttribute('aria-live', 'polite');
  errorSpan.textContent = errorMessage;
  elem.parentNode.appendChild(errorSpan);
}

