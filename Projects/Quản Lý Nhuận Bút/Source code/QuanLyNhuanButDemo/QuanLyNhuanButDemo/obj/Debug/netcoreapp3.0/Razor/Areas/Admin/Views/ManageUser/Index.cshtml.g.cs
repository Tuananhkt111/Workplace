#pragma checksum "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Areas\Admin\Views\ManageUser\Index.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "c581f82105e068a21c42977dc1b8551fa564a0e7"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Areas_Admin_Views_ManageUser_Index), @"mvc.1.0.view", @"/Areas/Admin/Views/ManageUser/Index.cshtml")]
namespace AspNetCore
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Mvc;
    using Microsoft.AspNetCore.Mvc.Rendering;
    using Microsoft.AspNetCore.Mvc.ViewFeatures;
#nullable restore
#line 1 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Areas\Admin\Views\ManageUser\Index.cshtml"
using Microsoft.AspNetCore.Identity;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Areas\Admin\Views\ManageUser\Index.cshtml"
using QuanLyNhuanButDemo.DTOs;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"c581f82105e068a21c42977dc1b8551fa564a0e7", @"/Areas/Admin/Views/ManageUser/Index.cshtml")]
    public class Areas_Admin_Views_ManageUser_Index : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<ManageUserViewModel>
    {
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_0 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("src", new global::Microsoft.AspNetCore.Html.HtmlString("~/lib/datatables/jquery.dataTables.js"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_1 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("src", new global::Microsoft.AspNetCore.Html.HtmlString("~/lib/datatables/dataTables.bootstrap4.js"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_2 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("src", new global::Microsoft.AspNetCore.Html.HtmlString("~/lib/bootstrap-select/bootstrap-select.min.js"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_3 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("src", new global::Microsoft.AspNetCore.Html.HtmlString("~/lib/bootstrap-select/defaults-vi_VN.js"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_4 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("src", new global::Microsoft.AspNetCore.Html.HtmlString("~/lib/moment/moment.min.js"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_5 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("src", new global::Microsoft.AspNetCore.Html.HtmlString("~/lib/datatables/datetime-moment.js"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_6 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("src", new global::Microsoft.AspNetCore.Html.HtmlString("~/js/user.js"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        #line hidden
        #pragma warning disable 0649
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperExecutionContext __tagHelperExecutionContext;
        #pragma warning restore 0649
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperRunner __tagHelperRunner = new global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperRunner();
        #pragma warning disable 0169
        private string __tagHelperStringValueBuffer;
        #pragma warning restore 0169
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager __backed__tagHelperScopeManager = null;
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager __tagHelperScopeManager
        {
            get
            {
                if (__backed__tagHelperScopeManager == null)
                {
                    __backed__tagHelperScopeManager = new global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager(StartTagHelperWritingScope, EndTagHelperWritingScope);
                }
                return __backed__tagHelperScopeManager;
            }
        }
        private global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.UrlResolutionTagHelper __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper;
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
#nullable restore
#line 4 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Areas\Admin\Views\ManageUser\Index.cshtml"
  
    ViewData["Title"] = "QuanLyTaiKhoan";
    Layout = "~/Views/Shared/_Layout.cshtml";

#line default
#line hidden
#nullable disable
            WriteLiteral(@"<ol class=""breadcrumb"">
    <li class=""breadcrumb-item"">
        <i class=""fas fa-plus-square""></i>
        Tạo mới tài khoản
    </li>
</ol>
<form id=""form-register"" method=""POST"">
    <div class=""row"">
        <div class=""col-md-8"">
            <div class=""form-group"">
                <label for=""UsernameRg""><strong>Tên đăng nhập</strong></label>
                <input type=""text"" class=""form-control"" name=""UsernameRg"" id=""UsernameRg"" pattern=""(\d|\w){1,30}"" onkeyup=""checkUsernameExisted()"">
                <p class=""error"" id=""Username-exist""></p>
            </div>
        </div>
        <div class=""col-md-4"">
            <div class=""form-group"">
                <label for=""RoleRg""><strong>Chức vụ</strong></label>
                <select class=""form-control"" id=""RoleRg"">
");
#nullable restore
#line 27 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Areas\Admin\Views\ManageUser\Index.cshtml"
                     foreach (var item in Model.IdentityRoles)
                    {

#line default
#line hidden
#nullable disable
            WriteLiteral("                        <option");
            BeginWriteAttribute("value", " value=\"", 1118, "\"", 1136, 1);
#nullable restore
#line 29 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Areas\Admin\Views\ManageUser\Index.cshtml"
WriteAttributeValue("", 1126, item.Name, 1126, 10, false);

#line default
#line hidden
#nullable disable
            EndWriteAttribute();
            WriteLiteral(">");
#nullable restore
#line 29 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Areas\Admin\Views\ManageUser\Index.cshtml"
                                              Write(item.Name);

#line default
#line hidden
#nullable disable
            WriteLiteral("</option>\r\n");
#nullable restore
#line 30 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Areas\Admin\Views\ManageUser\Index.cshtml"
                    }

#line default
#line hidden
#nullable disable
            WriteLiteral(@"                </select>
            </div>
        </div>
    </div>
    <div class=""row"" id=""departmentInput"">
        <div class=""col-md-6"">
            <label for=""DepartmentRg""><strong>Đơn vị</strong><small style=""color:blue"">* Bạn cần chọn đơn vị nếu bạn là phóng viên</small></label>
            <select class=""form-control selectpicker"" id=""DepartmentRg"" name=""DepartmentRg"" data-show-subtext=""true"" data-live-search=""true"">
");
#nullable restore
#line 39 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Areas\Admin\Views\ManageUser\Index.cshtml"
                 if (Model.Departments.Count() == 0)
                {

#line default
#line hidden
#nullable disable
            WriteLiteral("                    <option");
            BeginWriteAttribute("value", " value=\"", 1724, "\"", 1732, 0);
            EndWriteAttribute();
            WriteLiteral(">Không có đơn vị nào có sẵn</option>\r\n");
#nullable restore
#line 42 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Areas\Admin\Views\ManageUser\Index.cshtml"
                }
                else
                    foreach (var item in Model.Departments)
                    {

#line default
#line hidden
#nullable disable
            WriteLiteral("                        <option data-subtext=\"");
#nullable restore
#line 46 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Areas\Admin\Views\ManageUser\Index.cshtml"
                                         Write(item.DepartmentType);

#line default
#line hidden
#nullable disable
            WriteLiteral("\"");
            BeginWriteAttribute("value", " value=\"", 1963, "\"", 1989, 1);
#nullable restore
#line 46 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Areas\Admin\Views\ManageUser\Index.cshtml"
WriteAttributeValue("", 1971, item.DepartmentId, 1971, 18, false);

#line default
#line hidden
#nullable disable
            EndWriteAttribute();
            WriteLiteral(">");
#nullable restore
#line 46 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Areas\Admin\Views\ManageUser\Index.cshtml"
                                                                                          Write(item.DepartmentName);

#line default
#line hidden
#nullable disable
            WriteLiteral("</option>\r\n");
#nullable restore
#line 47 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Areas\Admin\Views\ManageUser\Index.cshtml"
                    }

#line default
#line hidden
#nullable disable
            WriteLiteral(@"            </select>
            <p class=""error"" id=""DepartmentAdd-exist""></p>
        </div>
        <div class=""col-md-6"">
            <label for=""NickNameRg""><strong>Bút danh</strong></label>
            <input type=""text"" class=""form-control"" name=""NickNameRg"" id=""NickNameRg"" pattern="".{1,40}"">
        </div>
    </div>
    <!--  row   -->
    <div class=""row"">
        <div class=""col-md-12"">
            <div class=""form-group"">
                <label for=""NameRg""><strong>Tên</strong></label>
                <input type=""text"" class=""form-control"" name=""NameRg"" id=""NameRg"" pattern="".{1,40}"">
            </div>
        </div>
    </div>
    <div class=""row"">
        <div class=""col-md-6"">
            <div class=""form-group"">
                <label for=""PasswordRg""><strong>Mật khẩu</strong></label>
                <input type=""password"" class=""form-control"" name=""PasswordRg"" id=""PasswordRg"" pattern=""(?=.*[A-Z])(?=.*[a-z])[A-Za-z0-9]{8,16}"">
            </div>
        </div>
       ");
            WriteLiteral(@" <!--  col-md-6   -->
        <div class=""col-md-6"">
            <div class=""form-group"">
                <label for=""RepPassRg""><strong>Nhập lại mật khẩu</strong></label>
                <input type=""password"" class=""form-control"" name=""RepPassRg"" id=""RepPassRg"" pattern=""(?=.*[A-Z])(?=.*[a-z])[A-Za-z0-9]{8,16}"">
            </div>
        </div>
        <!--  col-md-6   -->
    </div>
    <button type=""submit"" class=""btn btn-success mb-3"">Tạo mới</button>
</form>
<!-- DataTables Example -->
<div class=""card mb-3"">
    <div class=""card-header"">
        <i class=""fas fa-table""></i>
        Danh sách tài khoản
    </div>
    <div class=""card-body"">
        <div class=""table-responsive"">
            <table class=""table table-bordered table-hover animated fadeIn"" id=""dataTable"" width=""100%"" cellspacing=""0"">
                <thead>
                    <tr>
                        <th>Tên đăng nhập</th>
                        <th></th>
                        <th></th>
                    ");
            WriteLiteral(@"    <th>Tên</th>
                        <th>Chức vụ</th>
                        <th></th>
                        <th>Đơn vị</th>
                        <th>Trạng thái</th>
                        <th>Ngày cập nhật</th>
                        <th>Chỉnh sửa</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>Tên đăng nhập</th>
                        <th></th>
                        <th></th>
                        <th>Tên</th>
                        <th>Chức vụ</th>
                        <th></th>
                        <th>Đơn vị</th>
                        <th>Trạng thái</th>
                        <th>Ngày cập nhật</th>
                        <th>Chỉnh sửa</th>
                    </tr>
                </tfoot>
                <tbody id=""dataTable-body"">
                </tbody>
            </table>
        </div>
    </div>
    <div class=""card-footer small text-muted"">Cập nhật lúc ");
#nullable restore
#line 125 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Areas\Admin\Views\ManageUser\Index.cshtml"
                                                      Write(DateTime.Now.ToString("dd/MM/yyyy hh:mm tt"));

#line default
#line hidden
#nullable disable
            WriteLiteral(@"</div>
</div>
<div class=""modal fade"" id=""modalUpdtAccForm"" role=""dialog"" aria-labelledby=""myModalLabel"" aria-hidden=""true"">
    <div class=""modal-dialog modal-lg"" role=""document"">
        <div class=""modal-content"">
            <div class=""row ml-auto mr-2 mt-2"">
                <button type=""button"" id=""myBtn"" class=""close"" data-dismiss=""modal""><i class=""fas fa-times-circle""></i></button>
            </div>
            <h3 class=""text-center mt-2"" style=""color: #00cc33"">Chỉnh sửa tài khoản</h3>
            <form class=""modal-body"" id=""form-acc-updt"">
                <div class=""row"">
                    <div class=""col-lg-12"">
                        <div class=""form-group"">
                            <label for=""UsernameUpdt""><strong>Tên đăng nhập</strong></label>
                            <input type=""text"" class=""form-control"" name=""UsernameUpdt"" id=""UsernameUpdt"" disabled>
                        </div>
                    </div>
                </div>
                <!--  row   --");
            WriteLiteral(@">
                <div class=""row"">
                    <div class=""col-lg-12"">
                        <div class=""form-group"">
                            <label for=""NameUpdt""><strong>Tên</strong></label>
                            <input type=""text"" class=""form-control"" name=""NameUpdt"" id=""NameUpdt"" pattern="".{1,40}"">
                        </div>
                    </div>
                </div>
                <div class=""row"">
                    <div class=""col-lg-6"">
                        <div class=""form-group"">
                            <label for=""RoleUpdt""><strong>Chức vụ</strong></label>
                            <select class=""form-control"" id=""RoleUpdt"">
");
#nullable restore
#line 157 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Areas\Admin\Views\ManageUser\Index.cshtml"
                                 foreach (var item in Model.IdentityRoles)
                                {

#line default
#line hidden
#nullable disable
            WriteLiteral("                                    <option");
            BeginWriteAttribute("value", " value=\"", 7038, "\"", 7056, 1);
#nullable restore
#line 159 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Areas\Admin\Views\ManageUser\Index.cshtml"
WriteAttributeValue("", 7046, item.Name, 7046, 10, false);

#line default
#line hidden
#nullable disable
            EndWriteAttribute();
            WriteLiteral(">");
#nullable restore
#line 159 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Areas\Admin\Views\ManageUser\Index.cshtml"
                                                          Write(item.Name);

#line default
#line hidden
#nullable disable
            WriteLiteral("</option>\r\n");
#nullable restore
#line 160 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Areas\Admin\Views\ManageUser\Index.cshtml"
                                }

#line default
#line hidden
#nullable disable
            WriteLiteral(@"                            </select>
                        </div>
                    </div>
                    <div class=""col-lg-6"">
                        <div class=""form-group"">
                            <label for=""IsDeletedUpdt""><strong>Trạng thái</strong></label>
                            <select class=""form-control"" id=""IsDeletedUpdt"">
                                <option value=true>Đã vô hiệu hóa</option>
                                <option value=false>Có thể sử dụng</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class=""row departmentInput2"">
                    <div class=""col-md-12"">
                        <label for=""NickNameUpdt""><strong>Bút danh</strong></label>
                        <input type=""text"" class=""form-control"" name=""NickNameUpdt"" id=""NickNameUpdt"" pattern="".{1,40}"">
                    </div>
                </div>
                <div class=""r");
            WriteLiteral(@"ow departmentInput2"">
                    <div class=""col-md-12"">
                        <label for=""DepartmentUpdt""><strong>Đơn vị</strong><small style=""color:blue"">* Bạn cần chọn đơn vị nếu bạn là phóng viên</small></label>
                        <select class=""form-control selectpicker"" id=""DepartmentUpdt"" name=""DepartmentUpdt"" data-show-subtext=""true"" data-live-search=""true"">
");
#nullable restore
#line 184 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Areas\Admin\Views\ManageUser\Index.cshtml"
                             foreach (var item in Model.Departments)
                            {

#line default
#line hidden
#nullable disable
            WriteLiteral("                                <option data-subtext=\"");
#nullable restore
#line 186 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Areas\Admin\Views\ManageUser\Index.cshtml"
                                                 Write(item.DepartmentType);

#line default
#line hidden
#nullable disable
            WriteLiteral("\"");
            BeginWriteAttribute("value", " value=\"", 8703, "\"", 8729, 1);
#nullable restore
#line 186 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Areas\Admin\Views\ManageUser\Index.cshtml"
WriteAttributeValue("", 8711, item.DepartmentId, 8711, 18, false);

#line default
#line hidden
#nullable disable
            EndWriteAttribute();
            WriteLiteral(">");
#nullable restore
#line 186 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Areas\Admin\Views\ManageUser\Index.cshtml"
                                                                                                  Write(item.DepartmentName);

#line default
#line hidden
#nullable disable
            WriteLiteral("</option>\r\n");
#nullable restore
#line 187 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Areas\Admin\Views\ManageUser\Index.cshtml"
                            }

#line default
#line hidden
#nullable disable
            WriteLiteral(@"                        </select>
                        <p class=""error"" id=""DepartmentUpdt-exist""></p>
                    </div>
                </div>
                <div class=""text-center mt-2"">
                    <button type=""submit"" class=""btn btn-success mb-3 m-auto"">Cập nhật</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class=""modal fade"" id=""modalUpdtPassForm"" role=""dialog"" aria-labelledby=""myModalLabel"" aria-hidden=""true"">
    <div class=""modal-dialog modal-lg"" role=""document"">
        <div class=""modal-content"">
            <div class=""row ml-auto mr-2 mt-2"">
                <button type=""button"" id=""myBtn"" class=""close"" data-dismiss=""modal""><i class=""fas fa-times-circle""></i></button>
            </div>
            <h3 class=""text-center mt-2"" style=""color: #00cc33"">Thay đổi mật khẩu</h3>
            <form class=""modal-body"" id=""form-pass-updt"">
                <div class=""row"">
                    <div class=""col-md-12"">
     ");
            WriteLiteral(@"                   <div class=""form-group"">
                            <label for=""UsernameUpdtPass""><strong>Tên đăng nhập</strong></label>
                            <input type=""text"" class=""form-control"" name=""UsernameUpdtPass"" id=""UsernameUpdtPass"" disabled>
                        </div>
                    </div>
                </div>
                <div class=""row"">
                    <div class=""col-md-12"">
                        <div class=""form-group"">
                            <label for=""PasswordUpdt""><strong>Mật khẩu</strong></label>
                            <input type=""password"" class=""form-control"" name=""PasswordUpdt"" id=""PasswordUpdt"" pattern=""(?=.*[A-Z])(?=.*[a-z])[A-Za-z0-9]{8,16}"">
                        </div>
                    </div>
                </div>
                <!--  col-md-6   -->
                <div class=""row"">
                    <div class=""col-md-12"">
                        <div class=""form-group"">
                            <label for=");
            WriteLiteral(@"""RepPassUpdt""><strong>Nhập lại mật khẩu</strong></label>
                            <input type=""password"" class=""form-control"" name=""RepPassUpdt"" id=""RepPassUpdt"" pattern=""(?=.*[A-Z])(?=.*[a-z])[A-Za-z0-9]{8,16}"">
                        </div>
                    </div>
                </div>
                <div class=""text-center mt-2"">
                    <button type=""submit"" class=""btn btn-success mb-3 m-auto"">Cập nhật</button>
                </div>
            </form>
        </div>
    </div>
</div>
");
            DefineSection("QuanLyTaiKhoan", async() => {
                WriteLiteral("\r\n    active\r\n");
            }
            );
            DefineSection("Scripts", async() => {
                WriteLiteral("\r\n    ");
                __tagHelperExecutionContext = __tagHelperScopeManager.Begin("script", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "c581f82105e068a21c42977dc1b8551fa564a0e724409", async() => {
                }
                );
                __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.UrlResolutionTagHelper>();
                __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper);
                __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_0);
                await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
                if (!__tagHelperExecutionContext.Output.IsContentModified)
                {
                    await __tagHelperExecutionContext.SetOutputContentAsync();
                }
                Write(__tagHelperExecutionContext.Output);
                __tagHelperExecutionContext = __tagHelperScopeManager.End();
                WriteLiteral("\r\n    ");
                __tagHelperExecutionContext = __tagHelperScopeManager.Begin("script", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "c581f82105e068a21c42977dc1b8551fa564a0e725509", async() => {
                }
                );
                __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.UrlResolutionTagHelper>();
                __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper);
                __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_1);
                await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
                if (!__tagHelperExecutionContext.Output.IsContentModified)
                {
                    await __tagHelperExecutionContext.SetOutputContentAsync();
                }
                Write(__tagHelperExecutionContext.Output);
                __tagHelperExecutionContext = __tagHelperScopeManager.End();
                WriteLiteral("\r\n    ");
                __tagHelperExecutionContext = __tagHelperScopeManager.Begin("script", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "c581f82105e068a21c42977dc1b8551fa564a0e726609", async() => {
                }
                );
                __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.UrlResolutionTagHelper>();
                __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper);
                __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_2);
                await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
                if (!__tagHelperExecutionContext.Output.IsContentModified)
                {
                    await __tagHelperExecutionContext.SetOutputContentAsync();
                }
                Write(__tagHelperExecutionContext.Output);
                __tagHelperExecutionContext = __tagHelperScopeManager.End();
                WriteLiteral("\r\n    ");
                __tagHelperExecutionContext = __tagHelperScopeManager.Begin("script", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "c581f82105e068a21c42977dc1b8551fa564a0e727709", async() => {
                }
                );
                __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.UrlResolutionTagHelper>();
                __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper);
                __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_3);
                await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
                if (!__tagHelperExecutionContext.Output.IsContentModified)
                {
                    await __tagHelperExecutionContext.SetOutputContentAsync();
                }
                Write(__tagHelperExecutionContext.Output);
                __tagHelperExecutionContext = __tagHelperScopeManager.End();
                WriteLiteral("\r\n    ");
                __tagHelperExecutionContext = __tagHelperScopeManager.Begin("script", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "c581f82105e068a21c42977dc1b8551fa564a0e728809", async() => {
                }
                );
                __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.UrlResolutionTagHelper>();
                __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper);
                __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_4);
                await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
                if (!__tagHelperExecutionContext.Output.IsContentModified)
                {
                    await __tagHelperExecutionContext.SetOutputContentAsync();
                }
                Write(__tagHelperExecutionContext.Output);
                __tagHelperExecutionContext = __tagHelperScopeManager.End();
                WriteLiteral("\r\n    ");
                __tagHelperExecutionContext = __tagHelperScopeManager.Begin("script", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "c581f82105e068a21c42977dc1b8551fa564a0e729909", async() => {
                }
                );
                __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.UrlResolutionTagHelper>();
                __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper);
                __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_5);
                await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
                if (!__tagHelperExecutionContext.Output.IsContentModified)
                {
                    await __tagHelperExecutionContext.SetOutputContentAsync();
                }
                Write(__tagHelperExecutionContext.Output);
                __tagHelperExecutionContext = __tagHelperScopeManager.End();
                WriteLiteral("\r\n    ");
                __tagHelperExecutionContext = __tagHelperScopeManager.Begin("script", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "c581f82105e068a21c42977dc1b8551fa564a0e731009", async() => {
                }
                );
                __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.UrlResolutionTagHelper>();
                __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper);
                __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_6);
                await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
                if (!__tagHelperExecutionContext.Output.IsContentModified)
                {
                    await __tagHelperExecutionContext.SetOutputContentAsync();
                }
                Write(__tagHelperExecutionContext.Output);
                __tagHelperExecutionContext = __tagHelperScopeManager.End();
                WriteLiteral("\r\n");
            }
            );
            WriteLiteral("\r\n\r\n\r\n");
        }
        #pragma warning restore 1998
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.ViewFeatures.IModelExpressionProvider ModelExpressionProvider { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IUrlHelper Url { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IViewComponentHelper Component { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IJsonHelper Json { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<ManageUserViewModel> Html { get; private set; }
    }
}
#pragma warning restore 1591
