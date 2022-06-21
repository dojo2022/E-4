//open-meteoのURL
var url = "https://api.open-meteo.com/v1/forecast?latitude=35.6785&longitude=139.6823&daily=weathercode,temperature_2m_max,temperature_2m_min,snowfall_sum&timezone=Asia%2FTokyo";
var jsondata;//open-meteoのデータを入れる変数
var max; //最高気温
var weatherposition = document.getElementById("weather");//htmlのdiv取得
var min; //最低気温
var weather; //ウェザーコード（天気判断材料）
var weatherimage; //天気の絵文字
var weathertext; //天気の説明

//fetchを使ってopen-meteoのデータをjson形式で取得
fetch(url).then(data => data.json())
    .then(json => {
        jsondata = JSON.parse(JSON.stringify(json));//jsonデータを解析して必要なデータを取り出せるようにする
        min = jsondata['daily']['temperature_2m_min'][0];//jsonデータから最低気温を取得
        max = jsondata['daily']['temperature_2m_max'][0];//jsonデータから最高気温を取得
        weather = jsondata['daily']['weathercode'][0];//jsonデータからウェザーコードを取得
    }
    )

    function weatherset(){ //ウェザーコードに応じた画像をHTMLに挿入するfunction
        if(weather === 0){
            weathertext = "快晴";
            weatherposition.innerHTML += "<div class = 'ten'><img src='././image/快晴.png' alt = '天気マーク' id = 'mark'></div>";
        }else if(weather === 1){
            weathertext = "晴れ";
            weatherposition.innerHTML += "<div class = 'ten'><img src='././image/晴れ.png' alt = '天気マーク' id = 'mark'></div>";
        }else if(weather === 2){
            weathertext = "一部曇";
            weatherposition.innerHTML += "<div class = 'ten'><img src='././image/一部曇り.png' alt = '天気マーク' id = 'mark'></div>";
        }else if(weather === 3){
            weathertext = "曇り";
            weatherposition.innerHTML += "<div class = 'ten'><img src='././image/曇り.png' alt = '天気マーク' id = 'mark'></div>";
        }else if(weather <= 49){
            weathertext = "霧";
            weatherposition.innerHTML += "<div class = 'ten'><img src='././image/霧.png' alt = '天気マーク' id = 'mark'></div>";
        }else if(weather <= 59){
            weathertext = "小雨";
            weatherposition.innerHTML += "<div class = 'ten'><img src='././image/小雨1.png' alt = '天気マーク' id = 'mark'></div>";
        }else if(weather <= 69){
            weathertext = "雨";
            weatherposition.innerHTML += "<div class = 'ten'><img src='././image/雨.png' alt = '天気マーク' id = 'mark'></div>";
        }else if(weather <= 79){
            weathertext = "雪";
            weatherposition.innerHTML += "<div class = 'ten'><img src='././image/雪.png' alt = '天気マーク' id = 'mark'></div>";
        }else if(weather <= 84){
            weathertext = "小雨";
            weatherposition.innerHTML += "<div class = 'ten'><img src='././image/小雨.png' alt = '天気マーク' id = 'mark'></div>";
        }else if(weather <= 94){
            weathertext = "雪・雹";
            weatherposition.innerHTML += "<div class = 'ten'><img src='././image/雹.png' alt = '天気マーク' id = 'mark'></div>";
        }else if(weather <= 99){
            weathertext = "雷雨";
            weatherposition.innerHTML += "<div class = 'ten'><img src='././image/雷雨.png' alt = '天気マーク' id = 'mark'></div>";
        }else{
            weathertext = "不明";
            weatherposition.innerHTML += "<div class = 'ten'><img src='././image/不明.png' alt = '天気マーク'></div>";
        }
    }

function afterloading(){
    weatherset();//weatherset呼び出し
    weatherposition.innerHTML += "<p class=ten id=weathertext>"+"/"+weathertext+"</p>"+"<br>";//天気が何かをHTMLに挿入
    weatherposition.innerHTML += "<p class=num id=max>"+max+'/'+"</p>";//最高気温をHTMLに挿入
    weatherposition.innerHTML += "<p class=num id=min>"+min+"</p>";//最低気温をHTMLに挿入
}
//fetchに時間がかかりopen-meteoのデータがロードよりも早く実行してしまうためsettimeoutで実行を遅らせる
setTimeout(afterloading,1000);//1000ミリ秒(1秒後)にafterloading呼び出し

//写真アップロードのためのfunction
function upimage(upimage){
    var fileData = new FileReader();
    fileData.onload = (function() {
      //id属性が付与されているimgタグのsrc属性に、fileReaderで取得した値の結果を入力することで
      //プレビュー表示している
    document.getElementById('uploadimage').src = fileData.result;
    });
    fileData.readAsDataURL(upimage.files[0]);
}