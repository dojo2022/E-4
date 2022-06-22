'use strict';

let formObj = document.getElementById('login_form');
let errorMessageObj = document.getElementById('error_message');
formObj.onsubmit = function() {
	if (formObj.user_id.value === "" || formObj.password.value === "") {
		errorMessageObj.textContent = '※IDとパスワードを入力してください！'
		return false;
  }
	errorMessageObj.textContent = null;
};
formObj.onreset = function() {
	errorMessageObj.textContent = null;
};
