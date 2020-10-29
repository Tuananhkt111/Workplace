<%-- 
    Document   : liveSearch
    Created on : Oct 27, 2020, 1:03:58 PM
    Author     : tuana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            var count = 0;
            var xmlDOM = null;
            var xmlHttp;
            var client_XMLDOM = null;
            var tmpTableName;
            var cells = [];
            function addRow(tableId, cells) {
                var tableElem = document.getElementById(tableId);
                var newRow = tableElem.insertRow(tableElem.rows.length);
                var newCell;
                for (var i = 0; i < cells.length; i++) {
                    newCell = newRow.insertCell(newRow.cells.length);
                    newCell.innerHTML = cells[i];
                }
                return newRow;
            }
            function deleteRow(tableId, rowNumber) {
                var tableElem = document.getElementById(tableId);
                if (rowNumber > 0 && rowNumber < tableElem.rows.length) {
                    tableElem.deleteRow(rowNumber);
                } else {
                    alert("Failed")
                }
            }
            function traversalDOMTree(tableName) {
                var tableElem = document.getElementById(tableName);
                var i = 1;
                while (i < tableElem.rows.length) {
                    deleteRow(tableName, i);
                }
                count = 0;
                tmpTableName = tableName;
                client_XMLDOM = null;
                searchNode(xmlDOM, myForm.txtSearch.value);
                if(client_XMLDOM == null) {
                    searchDB();
                }
                update();
            }
            
            function searchDB() {
                xmlHttp = GetXmlHttpObject();
                if(xmlHttp == null) {
                    alert("Your browser dose not support AJAX");
                    return;
                }
                var url = "SearchController?txtSearch=" + myForm.txtSearch.value;
                xmlHttp.onreadystatechange = handleStateChange;
                xmlHttp.open("POST", url, true);
                xmlHttp.send(null);
            }
            
            searchNode(node, strSearch) {
                if(node == null) {
                    return;
                }
                //newDTOes
                //description - id - link - pubDate - title
                if(node.tagName == "description") {
                    var title = node.nextSibling.nextSibling.nextSibling.firstChild.nodeValue;
                    if(title.indexOf(txtSearch, 0) > 0) {
                        client_XMLDOM += "<newsDTO>";
                        count++;
                        cells[0] = count;
                        var id = node.nextSibling;
                        var link = id.nextSibling;
                        var pubDate = link.nextSibling;
                        cells[1] = title;
                        cells[2] = link.firstChild.nodeValue;
                        cells[3] = pubDate.firstChild.nodeValue;
                        client_XMLDOM += "<description>" + node.firstChild.nodeValue + "</description>";
                        client_XMLDOM += "<id>" + id.firstChild.nodeValue + "</id>";
                        client_XMLDOM += "<link>" + cells[2] + "</link>";
                        client_XMLDOM += "<pubdate>" + cells[3] + "</pubdate>";
                        client_XMLDOM += "<title>" + title + "</title></newsDTO>";
                        addRow(tmpTableName);
                    }
                }
                var childs = node.childNodes;
                for(var i = 0; i< childs.length; i++) {
                    searchNode(childs[i], strSearch);
                }
            }

            function getAll(node, tableName) {
                if (node == null)
                    return;
                if (node.tagName == "fullname") {
                    count++;
                    cells[0] = count;
                    cells[2] = node.firstChild.nodeValue;
                    var role = node.nextSibling.nextSibling;
                    cells[3] = role.firstChild.nodeValue;
                    var username = role.nextSibling;
                    cells[1] = username.firstChild.nodeValue;
                    addRow(tableName, cells);
                }
                var childs = node.childNodes;
                for (var i = 0; i < childs.length; i++) {
                    getAll(childs[i], tableName);
                }
            }
            function GetXmlHttpObject() {
                var xmlHttp = null;
                try { // Firefox, Opera, Safari
                    xmlHttp = new XMLHttpRequest();
                } catch (e) { // IE
                    try {
                        xmlHttp = new ActiveXObject("Msxml12.XMLHTTP");
                    } catch (e) {
                        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                    }
                }
                return xmlHttp;
            }
            function update() {
                xmlHttp = GetXmlHttpObject();
                if (xmlHttp == null) {
                    alert("Your browser does not support AJAX");
                    return;
                }
                var url = "TestController";
                xmlHttp.onreadystatechange = handleStateChange;
                xmlHttp.open("POST", url, true);
                xmlHttp.send(null);
            }
            function handleStateChange() {
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                    var tmp = xmlHttp.responseText;
                    alert(tmp);
                    if(tmp != "") {
                        var parser = new DOMParser();
                        xmlDOM = parser.parseFromString(tmp, "application/xml");
                        searchNode(xmlDOM, myForm.txtSearch.value);
                    } else {
                        alert("Server danh bo tay");
                    }  
                } 
            }
        </script>
    </head>
    <body>
        <h1>Live Search Demo</h1>
        <form name="myForm" method="POST">
            Title: <input type="text" name="txtSearch"/><br/>
            <input type="button" value="Search" onclick="traversalDOMTree('dataTable')"/>
        </form>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Title</th>
                    <th>Link</th>
                    <th>PubDate</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
