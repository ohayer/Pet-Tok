console.log("hello");

function showPopup() {
    document.getElementById("popup").style.display = "block";
}
function hidePopup() {
    document.getElementById("popup").style.display = "none";
}
//zliczanie słów textarea
function countChars() {
    let charNum = document.getElementById('charNum');
    let textLength = document.getElementById('text').value.length;

    charNum.innerHTML = textLength + '/225';

    if (textLength > 225) {
        charNum.style.color = 'red';
        document.getElementById('text').disabled = true;
    } else {
        charNum.style.color = 'black';
        document.getElementById('text').disabled = false;
    }
}
