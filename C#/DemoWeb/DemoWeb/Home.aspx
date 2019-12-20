<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Home.aspx.cs" Inherits="DemoWeb.Home" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        Nhap ten nguoi dung:
        <div>
            <asp:GridView runat="server" ID="gvBook"></asp:GridView>
            <asp:Button ID="btnLoad" runat="server" Text="ViewBook" />
        </div>
    </form>
</body>
</html>
