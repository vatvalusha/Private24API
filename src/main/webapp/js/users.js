/**
 * Created by new on 19.01.2018.
 */
function disableInput(idUser) {
    console.log("INSIDE");
    var disable = document.getElementById(idUser).disabled;
    console.log(disable);
    if (disable) {
        console.log("true");
        document.getElementById('id1').style.display = "none";
        document.getElementById('id2').style.display = "inline-block";
        document.getElementById(idUser).disabled = false;
    } else {
        console.log("false");
        document.getElementById('id2').style.display = "none";
        document.getElementById('id1').style.display = "inline-block";
        document.getElementById(idUser).disabled = true;
    }
}