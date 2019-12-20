<%@ Control Language="C#" CodeBehind="ForeignKey.ascx.cs" Inherits="HuyNQ_Project.ForeignKeyField" %>

<asp:HyperLink ID="HyperLink1" runat="server"
    Text="<%# GetDisplayString() %>"
    NavigateUrl="<%# GetNavigateUrl() %>"  />

