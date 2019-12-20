<%-- 
    Document   : index
    Created on : Aug 30, 2019, 7:48:54 PM
    Author     : tuana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script src="https://unpkg.com/react@16/umd/react.production.min.js"></script>
        <script src="https://unpkg.com/react-dom@16/umd/react-dom.production.min.js"></script>
        <script src="https://unpkg.com/babel-standalone@6.15.0/babel.min.js"></script>
        <h1>Hello World!</h1>
        <div id="mydiv"></div>
        <script type="text/babel">
            class Hello extends React.Component {
                render() {
                    return <h1>Hello World!</h1>
                }
            }
            ReactDOM.render(<Hello/>, document.getElementById("mydiv"))
        </script>

    </body>
</html>
