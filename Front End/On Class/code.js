function vidu1() {
    window.alert('toi la viruss');
}
var MAX = 100;
function vidu2() {
    var a = 5;
    var b = 10.5;
    var c = true;
    var d = "anh yeu em";
    var e = [1,2,3,4,5];
    var f = [id = '1', name = 'hieu', gender = 'female'];
    window.document.write("<p style = 'color: red; '>" + typeof(a) + "</p>");
    window.document.write("<p style = 'color: red; '>" + typeof(b) + "</p>");
    window.document.write("<p style = 'color: red; '>" + typeof(c) + "</p>");
    window.document.write("<p style = 'color: red; '>" + typeof(d) + "</p>");
    window.document.write("<p style = 'color: red; '>" + typeof(e) + "</p>");
    window.document.write("<p style = 'color: red; '>" + typeof(f) + "</p>"); 
}
function vidu3() {
    var x = 5;
    if(x === "5")
        window.document.bgColor="black";
    else
        window.document.bgColor="pink";
}
function vidu4() {
    var x=window.prompt("Nhap so thu 1");
    var y=window.prompt("Nhap so thu 2");
    var z=window.prompt("Nhap +-*/:");
    //x = new Number(x)
    if(window.isNaN(x) == true || window.isNaN(y) == true)
        window.alert("sao lam duoc");
    else{
        x = window.parseFloat(x);
        y = window.parseFloat(y);
        switch(z)
        {
            case "+": window.alert("result=" + (x + y)); break;
        }
    }
}
function vidu5() {
    var x=window.confirm("em co thich frontend khong?");
    if(x == true)
        document.title="pass mon";
    else 
        document.title="fail";
}
function vidu6() {
    var tenhinh = window.prompt("Nhap ten hinh co phan mo rong");
    var h = window.prompt("nhap height:");
    var w= window.prompt("nhap width:");
    var masp = window.prompt("nha ma sp:");
    var s = "<table border='1' width='50%' >";
    s += "<tr><th>MASP</th>";
    s +=     "<th>Hinh</th></tr>";
    s += "<tr>";
    s += "<td>" + masp + "</td>";
    s += "<td><img src='" + tenhinh + "' width='" + w + "' height='" + h + "'></td></tr>";
    s += "</table>"
    document.write(s);
}
// var x = new Object();
// x.id = "Tl111";
// x.name = "SSS";
// x.price = 2500;
//cach 2:
    //constructor with parameters
    function Product(id, name, price)
    {
        //Property
        this.id = id;
        this.name = name;
        this.price = price;
        //Methods
        this.display = function()
        {
            window.alert(this.id + "-" + this.name + "-" + this.price);
        };
    }
    function demo()
    {
        var x = new Product("Tv111", "Tv Sony", 1000);
        x.display();
        x.show();
    }
