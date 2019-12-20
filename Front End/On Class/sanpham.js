var a = [{
    id: "GI123",
    name: "Giay lau bep",
    path: "2.jpg",
    price: 25000,
    des: "<br>xuat xu:VN. <br>Nguyen lieu: Vai. <br> Cong dung: Lau chui 🙂."
},
{
    id: "Be333",
    name: "Bep tu",
    path: "3.jpg",
    price: 5000000,
    des: "<br>xuat xu:Malai. <br>Nguyen lieu: Nhua. <br> Cong dung: Nau 🙂."
},
];

function loadproduct(id) {
    var container = document.getElementById(id);
    for (var i = 0; i < a.length; i++) {
        var d = document.createElement("div");

        var anh = document.createElement("img");
        anh.src = a[i].path;
        anh.id = a[i].id;
        anh.addEventListener("click", showdetail);

        var p1 = document.createElement("p");
        p1.innerHTML = a[i].name;

        var p2 = document.createElement("p");
        p2.innerHTML = a[i].price;

        d.appendChild(anh);
        d.appendChild(p1);
        d.appendChild(p2);

        container.appendChild(d);
    }
}

function findproduct(ma) {
    for (var i = 0; i < a.length; i++) {
        if (a[i].id == ma)
            return i;
    }
    return -1;
}

function showdetail() {
    var ma = event.target.id;
    var kq = findproduct(ma);
    if (kq != -1) {
        var anh = document.getElementById("img");
        anh.src = a[kq].path;

        var p1 = document.getElementById("des");
        p1.innerHTML = "Description:" + a[kq].des;

        var p2 = document.getElementById("id");
        p2.innerHTML = "ID:" + a[kq].id;

        var p3 = document.getElementById("name");
        p3.innerHTML = "Name:" + a[kq].name;

        var p4 = document.getElementById("price");
        p4.innerHTML = "Price:" + a[kq].price;

        document.getElementById("detail").style.display = "block";
    }
}

function closedetail() {
    document.getElementById("detail").style.display = "none";
}

//Hàm này để check xem mã sp có trong localStorage hay chưa
function check(ma) {
    for (var i = 0; i < window.localStorage.length; i++) {
        var key = window.localStorage.key(i);
        if (key != null && key == ma)
            return i;
    }
    return -1;
}


function addproduct(id) {
    var the_p = document.getElementById(id);
    var tam = the_p.innerHTML.split(":");
    //cắt nội dung thẻ p thành 2 chuỗi con cách nhau bởi dấu :, mã nằm ở vị trí 1
    var ma = tam[1];
    var kq = check(ma);
    if (kq == -1) { //ma nay chua co thi add vao localStorage
        window.localStorage.setItem(ma, 1);
        window.alert("added!!!");
    } else { //da co, chi tang value
        var v = window.localStorage.getItem(ma);
        v++;
        window.localStorage.setItem(ma, v);
        window.alert("Updated!!!");
    }
}

function xemgiohang() {
    var sum = 0;
    var s = "<table>";
    s = s + "<tr>";
    s = s + "<th>product</th>";
    s = s + "<th>your option</th>";
    s = s + "<th>price</th>";
    s = s + "</tr>";

    for (var i = 0; i < window.localStorage.length; i++) {
        var ma = window.localStorage.key(i);
        if (ma != null) {
            var pos = findproduct(ma);
            if (pos != -1) {
                s = s + "<tr>";
                s = s + "<td>";
                s = s + "<img src='" + a[pos].path + "'>";
                s = s + a[pos].name + "</td>";
                s = s + "<td><input type='number' value='" + window.localStorage.getItem(ma) + "' min='1' max='10' onchange = 'update(\""
                    + a[pos].id + "\",this.value)'></td>";
                s = s + "<td>" + a[pos].price;
                s = s + "<br><a href='#' onclick = 'xoa(\"" + a[pos].id + "\")'>remove</a></td>";
                s = s + "</tr>";
                sum = sum + window.localStorage.getItem(ma) * a[pos].price;
            }
        }
    }


    s = s + "</table>";

    s = s + "<p>Tong tien can thanh toan: " + sum + "VND</p>";
    var thediv = document.getElementById("giohang");
    thediv.innerHTML = s;
}
function update(masp, soluong) {
    var i = check(masp);
    if (i != -1) {
        window.localStorage.setItem(masp, soluong);
        window.alert("Updated!");
        xemgiohang();
    }
}
function xoa(masp) {
    var i = check(masp);
    if (i != -1) {
        var kq = window.confirm("are u sure?");
        if (kq == true) {
            window.localStorage.removeItem(masp);
            xemgiohang();
        }

    }
}
function checkout(id1, id2) {
    var t1 = document.getElementById("id1");
    var t2 = document.getElementById("id2");
    if (t1.value == "" || t2.value == "") {
        window.alert("Vui long cho biet ten va dien thoai");
    }
    else {
        window.alert("cam on. Chung toi se lien he voi ban");
        window.localStorage.clear();
        window.open("sanpham.html");
    }
}