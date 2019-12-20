<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Manager.aspx.cs" Inherits="PracticalWebform.Manager" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:GridView ID="dgvBookList" runat="server" AllowPaging="True" AllowSorting="True" BackColor="White" BorderColor="#CC9966" BorderStyle="None" BorderWidth="1px" CellPadding="4">
                <FooterStyle BackColor="#FFFFCC" ForeColor="#330099" />
                <HeaderStyle BackColor="#990000" Font-Bold="True" ForeColor="#FFFFCC" />
                <PagerStyle BackColor="#FFFFCC" ForeColor="#330099" HorizontalAlign="Center" />
                <RowStyle BackColor="White" ForeColor="#330099" />
                <SelectedRowStyle BackColor="#FFCC66" Font-Bold="True" ForeColor="#663399" />
                <SortedAscendingCellStyle BackColor="#FEFCEB" />
                <SortedAscendingHeaderStyle BackColor="#AF0101" />
                <SortedDescendingCellStyle BackColor="#F6F0C0" />
                <SortedDescendingHeaderStyle BackColor="#7E0000" />
            </asp:GridView>
            <div>
                <asp:Label ID="Label1" runat="server" Text="BookID:"></asp:Label>
                <asp:TextBox ID="txtID" runat="server" style="margin-left: 76px"></asp:TextBox>
                <br />
            </div>
        </div>
            <div>
                <asp:Label ID="Label2" runat="server" Text="BookTitle:"></asp:Label>
                <asp:TextBox ID="txtTitle" runat="server" style="margin-left: 60px"></asp:TextBox>
                <br />
            </div>
            <div>
                <asp:Label ID="Label3" runat="server" Text="BookPrice:"></asp:Label>
                <asp:TextBox ID="txtPrice" runat="server" style="margin-left: 56px"></asp:TextBox>
                <br />
            </div>
            <div>
                <asp:Label ID="Label4" runat="server" Text="BookQuantity:"></asp:Label>
                <asp:TextBox ID="txtQuantity" runat="server" style="margin-left: 30px"></asp:TextBox>
                <br />
            </div>
        <div>
            <asp:Button ID="btnAdd" runat="server" OnClick="btnAdd_Click" Text="Add" Width="72px" />
            <asp:Button ID="btnUpdate" runat="server" style="margin-left: 46px" Text="Update" />
            <asp:Button ID="btnDelete" runat="server" style="margin-left: 63px" Text="Delete" />
        </div>
    </form>
</body>
</html>
