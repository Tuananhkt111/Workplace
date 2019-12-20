var imgSlide = [
    {
        src: "957020.jpg",
        love: 259,
        download: 123
    },
    {
        src: "952520.jpg",
        love: 310,
        download: 101
    },
    {
        src: "943302.jpg",
        love: 259,
        download: 123
    },
    {
        src: "942761.jpg",
        love: 345,
        download: 340
    },
    {
        src: "952215.png",
        love: 122,
        download: 890
    },
    {
        src: "606670.jpg",
        love: 456,
        download: 100
    },
    {
        src: "942181.jpg",
        love: 345,
        download: 560
    },
];
loadImgSlide();
function loadImgSlide() {
    for (var i = 0; i < imgSlide.length; i++) {

        var d = document.createElement("div");
        d.setAttribute("class", "img-slide");

        var img = document.createElement("img");
        img.src = imgSlide[i].src;
        img.setAttribute("class", "img-slide-src");

        var info = document.createElement("div");
        info.setAttribute("class", "img-slide-info");

        var l = document.createElement("div");
        l.setAttribute("class", "love");
        var hearticon = document.createElement("i");
        hearticon.setAttribute("class", "fa fa-heart");
        l.appendChild(hearticon);
        l.append(imgSlide[i].love);

        var down = document.createElement("div");
        down.setAttribute("class", "download");
        var downicon = document.createElement("i");
        downicon.setAttribute("class", "fa fa-download");
        down.appendChild(downicon);
        down.append(imgSlide[i].download);
        //set child-parent
        info.appendChild(l);
        info.appendChild(down);
        d.appendChild(img);
        d.appendChild(info);
        //put in the container
        var container = document.getElementsByClassName("slide");
        container[0].appendChild(d);
    }
}
var slideIndex2 = 2;
showDiv();

function plusDiv(n) {
    slideIndex2 += n;
    showDiv();
}
function showDiv() {
    var imgSlide = document.getElementsByClassName("img-slide");
    for (var i = 0; i < imgSlide.length; i++) {
        imgSlide[i].style.display = "none";
        imgSlide[i].style.transform = "scale(1, 1)";
    }
    if (slideIndex2 == imgSlide.length) {
        slideIndex2 = 0;
    }
    if (slideIndex2 == -1) {
        slideIndex2 = imgSlide.length - 1;
    }
    if (slideIndex2 == imgSlide.length - 1) {
        imgSlide[imgSlide.length - 3].style.display = "flex";
        imgSlide[imgSlide.length - 2].style.display = "flex";
        imgSlide[imgSlide.length - 1].style.display = "flex";
        imgSlide[0].style.display = "flex";
        imgSlide[1].style.display = "flex";

        imgSlide[imgSlide.length - 3].style.left = "-28vw";
        imgSlide[imgSlide.length - 2].style.left = "1vw";
        imgSlide[imgSlide.length - 1].style.left = "30vw";
        imgSlide[0].style.left = "59vw";
        imgSlide[1].style.left = "88vw";
    }
    else if (slideIndex2 == imgSlide.length - 2) {
        imgSlide[imgSlide.length - 4].style.display = "flex";
        imgSlide[imgSlide.length - 3].style.display = "flex";
        imgSlide[imgSlide.length - 2].style.display = "flex";
        imgSlide[imgSlide.length - 1].style.display = "flex";
        imgSlide[0].style.display = "flex";

        imgSlide[imgSlide.length - 4].style.left = "-28vw";
        imgSlide[imgSlide.length - 3].style.left = "1vw";
        imgSlide[imgSlide.length - 2].style.left = "30vw";
        imgSlide[imgSlide.length - 1].style.left = "59vw";
        imgSlide[0].style.left = "88vw";
    }
    else if (slideIndex2 == 0) {
        imgSlide[imgSlide.length - 2].style.display = "flex";
        imgSlide[imgSlide.length - 1].style.display = "flex";
        imgSlide[0].style.display = "flex";
        imgSlide[1].style.display = "flex";
        imgSlide[2].style.display = "flex";

        imgSlide[imgSlide.length - 2].style.left = "-28vw";
        imgSlide[imgSlide.length - 1].style.left = "1vw";
        imgSlide[0].style.left = "30vw";
        imgSlide[1].style.left = "59vw";
        imgSlide[2].style.left = "88vw";
    }
    else if (slideIndex2 == 1) {
        imgSlide[imgSlide.length - 1].style.display = "flex";
        imgSlide[0].style.display = "flex";
        imgSlide[1].style.display = "flex";
        imgSlide[2].style.display = "flex";
        imgSlide[3].style.display = "flex";

        imgSlide[imgSlide.length - 1].style.left = "-28vw";
        imgSlide[0].style.left = "1vw";
        imgSlide[1].style.left = "30vw";
        imgSlide[2].style.left = "59vw";
        imgSlide[3].style.left = "88vw";
    }
    else {
        imgSlide[slideIndex2 - 2].style.display = "flex";
        imgSlide[slideIndex2 - 1].style.display = "flex";
        imgSlide[slideIndex2].style.display = "flex";
        imgSlide[slideIndex2 + 1].style.display = "flex";
        imgSlide[slideIndex2 + 2].style.display = "flex";

        imgSlide[slideIndex2 - 2].style.left = "-28vw";
        imgSlide[slideIndex2 - 1].style.left = "1vw";
        imgSlide[slideIndex2].style.left = "30vw";
        imgSlide[slideIndex2 + 1].style.left = "59vw";
        imgSlide[slideIndex2 + 2].style.left = "88vw";
    }
    imgSlide[slideIndex2].style.transform = "scale(1.2, 1.2)";
}
var collection = [
    {
        link: "anime.html",
        src: "anime.jpg",
        title: "ANIME",
        info: "Japanese animation wallpapers"
    },
    {
        link: "fantasy.html",
        src: "Fantasy.jpg",
        title: "FANTANSY",
        info: "Fantastic and mystical wallpapers"
    },
    {
        link: "girls.html",
        src: "Girl.jpg",
        title: "GIRLS",
        info: "Professional, cute, and funny girl photos"
    },
    {
        link: "landscape.html",
        src: "Landscape.jpg",
        title: "LANDSCAPE",
        info: "Beautiful trees, lakes, and mountains"
    },
];
loadCategory();
function loadCategory() {
    var container = document.getElementsByClassName("category");
    for(var i = 0; i < collection.length; i++) {
        var link = document.createElement("a");
        link.href = collection[i].link;

        var d= document.createElement("div");

        var img = document.createElement("img");
        img.src = collection[i].src;
        
        var box = document.createElement("div");
        box.setAttribute("class", "viewBox");

        var shape = document.createElement("div");
        shape.setAttribute("class", "shape");

        var title = document.createElement("span");
        title.setAttribute("class", "category-title");
        title.append(collection[i].title);

        var br = document.createElement("br");
        title.appendChild(br);

        var info = document.createElement("span");
        info.setAttribute("class", "category-info");
        info.innerHTML = collection[i].info;
        title.appendChild(info);

        var view = document.createElement("span");
        view.setAttribute("class", "view");
        view.innerHTML = "VIEW";
        //set child-parent
        box.appendChild(shape);
        box.appendChild(title);
        box.appendChild(view);
        d.appendChild(img);
        d.appendChild(box);
        link.appendChild(d);
        container[0].appendChild(link);
    }
}
var imgGrid;