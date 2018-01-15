/**
 * Created by new on 15.01.2018.
 */
var modal = document.getElementById('id01');
var singIn = document.getElementById('id02');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
    if (event.target == singIn) {
        singIn.style.display = "none";
    }
}