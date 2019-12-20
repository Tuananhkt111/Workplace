﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

// 
// This source code was auto-generated by Microsoft.VSDesigner, Version 4.0.30319.42000.
// 
#pragma warning disable 1591

namespace MaintainBooks.localhost {
    using System;
    using System.Web.Services;
    using System.Diagnostics;
    using System.Web.Services.Protocols;
    using System.Xml.Serialization;
    using System.ComponentModel;
    using System.Data;
    
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.3752.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Web.Services.WebServiceBindingAttribute(Name="BookServiceSoap", Namespace="http://tempuri.org/")]
    public partial class BookService : System.Web.Services.Protocols.SoapHttpClientProtocol {
        
        private System.Threading.SendOrPostCallback GetBookListOperationCompleted;
        
        private System.Threading.SendOrPostCallback AddBookOperationCompleted;
        
        private System.Threading.SendOrPostCallback DeleteBookOperationCompleted;
        
        private System.Threading.SendOrPostCallback UpdateBookOperationCompleted;
        
        private bool useDefaultCredentialsSetExplicitly;
        
        /// <remarks/>
        public BookService() {
            this.Url = global::MaintainBooks.Properties.Settings.Default.MaintainBooks_localhost_BookService;
            if ((this.IsLocalFileSystemWebService(this.Url) == true)) {
                this.UseDefaultCredentials = true;
                this.useDefaultCredentialsSetExplicitly = false;
            }
            else {
                this.useDefaultCredentialsSetExplicitly = true;
            }
        }
        
        public new string Url {
            get {
                return base.Url;
            }
            set {
                if ((((this.IsLocalFileSystemWebService(base.Url) == true) 
                            && (this.useDefaultCredentialsSetExplicitly == false)) 
                            && (this.IsLocalFileSystemWebService(value) == false))) {
                    base.UseDefaultCredentials = false;
                }
                base.Url = value;
            }
        }
        
        public new bool UseDefaultCredentials {
            get {
                return base.UseDefaultCredentials;
            }
            set {
                base.UseDefaultCredentials = value;
                this.useDefaultCredentialsSetExplicitly = true;
            }
        }
        
        /// <remarks/>
        public event GetBookListCompletedEventHandler GetBookListCompleted;
        
        /// <remarks/>
        public event AddBookCompletedEventHandler AddBookCompleted;
        
        /// <remarks/>
        public event DeleteBookCompletedEventHandler DeleteBookCompleted;
        
        /// <remarks/>
        public event UpdateBookCompletedEventHandler UpdateBookCompleted;
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/GetBookList", RequestNamespace="http://tempuri.org/", ResponseNamespace="http://tempuri.org/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public System.Data.DataSet GetBookList() {
            object[] results = this.Invoke("GetBookList", new object[0]);
            return ((System.Data.DataSet)(results[0]));
        }
        
        /// <remarks/>
        public void GetBookListAsync() {
            this.GetBookListAsync(null);
        }
        
        /// <remarks/>
        public void GetBookListAsync(object userState) {
            if ((this.GetBookListOperationCompleted == null)) {
                this.GetBookListOperationCompleted = new System.Threading.SendOrPostCallback(this.OnGetBookListOperationCompleted);
            }
            this.InvokeAsync("GetBookList", new object[0], this.GetBookListOperationCompleted, userState);
        }
        
        private void OnGetBookListOperationCompleted(object arg) {
            if ((this.GetBookListCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.GetBookListCompleted(this, new GetBookListCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/AddBook", RequestNamespace="http://tempuri.org/", ResponseNamespace="http://tempuri.org/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public void AddBook(int BookID, string BookTitle, float BookPrice, int BookQuantity) {
            this.Invoke("AddBook", new object[] {
                        BookID,
                        BookTitle,
                        BookPrice,
                        BookQuantity});
        }
        
        /// <remarks/>
        public void AddBookAsync(int BookID, string BookTitle, float BookPrice, int BookQuantity) {
            this.AddBookAsync(BookID, BookTitle, BookPrice, BookQuantity, null);
        }
        
        /// <remarks/>
        public void AddBookAsync(int BookID, string BookTitle, float BookPrice, int BookQuantity, object userState) {
            if ((this.AddBookOperationCompleted == null)) {
                this.AddBookOperationCompleted = new System.Threading.SendOrPostCallback(this.OnAddBookOperationCompleted);
            }
            this.InvokeAsync("AddBook", new object[] {
                        BookID,
                        BookTitle,
                        BookPrice,
                        BookQuantity}, this.AddBookOperationCompleted, userState);
        }
        
        private void OnAddBookOperationCompleted(object arg) {
            if ((this.AddBookCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.AddBookCompleted(this, new System.ComponentModel.AsyncCompletedEventArgs(invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/DeleteBook", RequestNamespace="http://tempuri.org/", ResponseNamespace="http://tempuri.org/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public void DeleteBook(int BookID) {
            this.Invoke("DeleteBook", new object[] {
                        BookID});
        }
        
        /// <remarks/>
        public void DeleteBookAsync(int BookID) {
            this.DeleteBookAsync(BookID, null);
        }
        
        /// <remarks/>
        public void DeleteBookAsync(int BookID, object userState) {
            if ((this.DeleteBookOperationCompleted == null)) {
                this.DeleteBookOperationCompleted = new System.Threading.SendOrPostCallback(this.OnDeleteBookOperationCompleted);
            }
            this.InvokeAsync("DeleteBook", new object[] {
                        BookID}, this.DeleteBookOperationCompleted, userState);
        }
        
        private void OnDeleteBookOperationCompleted(object arg) {
            if ((this.DeleteBookCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.DeleteBookCompleted(this, new System.ComponentModel.AsyncCompletedEventArgs(invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/UpdateBook", RequestNamespace="http://tempuri.org/", ResponseNamespace="http://tempuri.org/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public void UpdateBook(int BookID, string BookTitle, float BookPrice, int BookQuantity) {
            this.Invoke("UpdateBook", new object[] {
                        BookID,
                        BookTitle,
                        BookPrice,
                        BookQuantity});
        }
        
        /// <remarks/>
        public void UpdateBookAsync(int BookID, string BookTitle, float BookPrice, int BookQuantity) {
            this.UpdateBookAsync(BookID, BookTitle, BookPrice, BookQuantity, null);
        }
        
        /// <remarks/>
        public void UpdateBookAsync(int BookID, string BookTitle, float BookPrice, int BookQuantity, object userState) {
            if ((this.UpdateBookOperationCompleted == null)) {
                this.UpdateBookOperationCompleted = new System.Threading.SendOrPostCallback(this.OnUpdateBookOperationCompleted);
            }
            this.InvokeAsync("UpdateBook", new object[] {
                        BookID,
                        BookTitle,
                        BookPrice,
                        BookQuantity}, this.UpdateBookOperationCompleted, userState);
        }
        
        private void OnUpdateBookOperationCompleted(object arg) {
            if ((this.UpdateBookCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.UpdateBookCompleted(this, new System.ComponentModel.AsyncCompletedEventArgs(invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        public new void CancelAsync(object userState) {
            base.CancelAsync(userState);
        }
        
        private bool IsLocalFileSystemWebService(string url) {
            if (((url == null) 
                        || (url == string.Empty))) {
                return false;
            }
            System.Uri wsUri = new System.Uri(url);
            if (((wsUri.Port >= 1024) 
                        && (string.Compare(wsUri.Host, "localHost", System.StringComparison.OrdinalIgnoreCase) == 0))) {
                return true;
            }
            return false;
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.3752.0")]
    public delegate void GetBookListCompletedEventHandler(object sender, GetBookListCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.3752.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class GetBookListCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal GetBookListCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public System.Data.DataSet Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((System.Data.DataSet)(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.3752.0")]
    public delegate void AddBookCompletedEventHandler(object sender, System.ComponentModel.AsyncCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.3752.0")]
    public delegate void DeleteBookCompletedEventHandler(object sender, System.ComponentModel.AsyncCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.3752.0")]
    public delegate void UpdateBookCompletedEventHandler(object sender, System.ComponentModel.AsyncCompletedEventArgs e);
}

#pragma warning restore 1591