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

    charNum.innerHTML = textLength + '/255';

    if (textLength > 255) {
        charNum.style.color = 'red';
        document.getElementById('text').disabled = true;
    } else {
        charNum.style.color = 'black';
        document.getElementById('text').disabled = false;
    }
}
function incrementRating(petId) {
    $.ajax({
        type: "POST",
        url: "/pets/" + petId + "/increment-rating",
        success: function(newRating) {
            $("#rating").text(newRating);
        },
        error: function() {
            alert("Wystąpił błąd. Spróbuj ponownie później.");
        }
    });
}

