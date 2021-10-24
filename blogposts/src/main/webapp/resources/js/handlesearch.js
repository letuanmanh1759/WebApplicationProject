
const $text = document.querySelector(".text");
const $button = document.querySelector(".button");
$text.addEventListener("keyup",searchHandle);
$button.addEventListener("click",clickBtn);

function searchHandle(event){
    if(event.key=="Enter"){
        if($text.value.trim()==""){
            window.alert("You must enter at least one character !");
        }
        else{
            clickBtn();
        }
    }
}
function clickBtn(){
    if($text.value.trim()==""){
        window.alert("You must enter at least one character !");
    }
    else{
        document.getElementById("searching").innerHTML="seaching...";
        setTimeout(clear,3000);
    }
    
}
function clear(event){
    document.getElementById("searching").innerHTML=null;
    $text.value=null;
}