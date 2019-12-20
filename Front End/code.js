function validateForm() {
  var passrpt = document.getElementById("psw-rpt");
  var pass = document.getElementById("psw");
  if (passrpt.value == "") {
    passrpt.setCustomValidity("Please fill out this field.");
  }
  else if (passrpt.value != pass.value) {
    passrpt.setCustomValidity("Password not match.");
  }
  else {
    passrpt.setCustomValidity("");
  }
}
var slideIndex = 0;
autoSlide();
function autoSlide() {
  var i;
  var x = document.getElementsByClassName("header-slide");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";
  }
  slideIndex++;
  if (slideIndex == x.length) { slideIndex = 0 };
  x[slideIndex].style.display = "block";
  setTimeout(autoSlide, 5000);
}
function loadImgGrid() {
  var container = document.getElementsByClassName("gallery");
  for (var i = 0; i < 3; i++) {
    var col = document.createElement("div");
    col.setAttribute("class", "column");
    for (var j = 0; j < imgGrid.length / 3; j++) {
      var m = document.createElement("div");
      m.setAttribute("class", "img-grid");

      var img = document.createElement("img");
      img.setAttribute("class", "img-grid-src");
      img.src = imgGrid[5 * i + j].src;

      var info = document.createElement("div");
      info.setAttribute("class", "img-info");

      var l = document.createElement("div");
      l.setAttribute("class", "love");
      var hearticon = document.createElement("i");
      hearticon.setAttribute("class", "fa fa-heart");
      l.appendChild(hearticon);
      l.append(imgGrid[5 * i + j].love);

      var d = document.createElement("div");
      d.setAttribute("class", "download");
      var downicon = document.createElement("i");
      downicon.setAttribute("class", "fa fa-download");
      d.appendChild(downicon);
      d.append(imgGrid[5 * i + j].download);

      //set child-parent
      info.appendChild(l);
      info.appendChild(d);
      m.appendChild(img);
      m.appendChild(info);
      col.appendChild(m);
    }
    //put in the container

    container[0].appendChild(col);
  }
}
if (imgGrid !== undefined) {
  loadImgGrid();
}
var modal = document.getElementById("openImg");
var modalImg = document.getElementById("modalImg-src");
var imgSrc = document.getElementsByClassName("img-grid-src");
var imgSrc2 = document.getElementsByClassName("img-slide-src");

function openImage() {
  modal.style.display = "flex";
  modalImg.src = this.src;
  var x = document.getElementById("download-link");
  x.href = this.src;
}
for (var i = 0; i < imgSrc.length; i++) {
  imgSrc[i].onclick = openImage;
}
for (var i = 0; i < imgSrc2.length; i++) {
  imgSrc2[i].onclick = openImage;
}

window.onclick = function (event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}

window.onscroll = scrollFunction;
function scrollFunction() {
  if (document.body.scrollTop > 62 || document.documentElement.scrollTop > 62) {
    document.getElementsByClassName("primary-navigation")[0].style.background = "linear-gradient(rgba(0, 0, 0, 1), rgba(0, 0, 0, 0.7))";
  } else {
    document.getElementsByClassName("primary-navigation")[0].style.background = "black";
  }
}







