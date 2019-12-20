var a = ["952520.jpg", "952521.jpg", "947780.jpg", "607021.jpg", "947849.jpg"];
var b = ["aaaaaaaa", "bbbbbbb", "ccccccc", "ddddddd", "eeeeeee"];
slideIndex = 0;
show();
showNumber();
function prev() {
    if(slideIndex != 0) {
        slideIndex--;
        show();
    }        
}
function next() {
    if(slideIndex != a.length - 1) {
        slideIndex++;
        show();
    }
}
function show() {
    var img = document.getElementById("BigImg");
    img.src = a[slideIndex];
    var p = document.getElementById("Number");
    p.innerHTML = (slideIndex + 1) + " OF " + a.length;
    var p2 = document.getElementById("Description");
    p2.innerHTML = b[slideIndex];
}