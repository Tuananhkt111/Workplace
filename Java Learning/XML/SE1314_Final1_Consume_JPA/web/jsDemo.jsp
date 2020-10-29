<%-- 
    Document   : jsDemo
    Created on : Oct 20, 2020, 2:57:31 PM
    Author     : tranh
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
                update();
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
                    var parser = new DOMParser();
                    xmlDOM = parser.parseFromString(tmp, "application/xml");
                    getAll(xmlDOM, tmpTableName);
                }
            }
        </script>
    </head>
    <body>
        <h1>Marshaller combine JS Demo</h1>
        <form name="myForm">
            <input type="button" value="GetAll"
                   onclick="traversalDOMTree('dataTable')"/>
        </form>
        <table border="1" id="dataTable">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Username</th>
                    <th>Fullname</th>
                    <th>Role</th>
                </tr>
            </thead>
        </table>
    </body>
</html>
