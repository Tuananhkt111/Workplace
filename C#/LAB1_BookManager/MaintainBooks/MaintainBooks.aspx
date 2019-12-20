<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="MaintainBooks.aspx.cs" Inherits="MaintainBooks.MaintainBooks" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:Label ID="Label1" runat="server" Text="BookID:"></asp:Label>
            <asp:TextBox ID="txtID" runat="server" style="margin-left: 83px"></asp:TextBox>
        <div>
            <asp:Label ID="Label2" runat="server" Text="BookTitle:"></asp:Label>
            <asp:TextBox ID="txtTitle" runat="server" style="margin-left: 64px"></asp:TextBox>
        </div>
        </div>
        <div>
            <asp:Label ID="Label3" runat="server" Text="BookPrice:"></asp:Label>
            <asp:TextBox ID="txtPrice" runat="server" style="margin-left: 60px"></asp:TextBox>
        </div>
        <div>
            <asp:Label ID="Label4" runat="server" Text="BookQuantity:"></asp:Label>
            <asp:TextBox ID="txtQuantity" runat="server" style="margin-left: 33px"></asp:TextBox>
            <div>
                <asp:Button ID="btnAdd" runat="server" OnClick="btnAdd_Click" Text="Add" Width="91px" />
                <asp:Button ID="btnUpdate" runat="server" OnClick="btnUpdate_Click" style="margin-left: 41px; margin-right: 49px" Text="Update" Width="91px" />
                <asp:Button ID="btnDelete" runat="server" OnClick="btnDelete_Click" Text="Delete" Width="91px" />
                <asp:GridView ID="dgvBookList" runat="server" AutoGenerateSelectButton="True" OnSelectedIndexChanging="dgvBookList_SelectedIndexChanging">
                </asp:GridView>
            </div>
        </div>
    </form>
</body>
</html>
