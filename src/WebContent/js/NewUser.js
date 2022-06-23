'use strict';

let formObj = document.getElementById('newregistration_form');
  let errorMessageObj = document.getElementById('warning');


  formObj.onsubmit = function(event) {
    if (formObj.pass1.value === "" || formObj.pass2.value === "" || formObj.user_id.value === "") {
      errorMessageObj.textContent = '※全ての欄を入力してください';
      return false;
     }

    if (formObj.pass1.value != formObj.pass2.value ) {
      errorMessageObj.textContent = '※Passwordが一致しません';
      return false;
     }
      errorMessageObj.textContent = null;

  };
