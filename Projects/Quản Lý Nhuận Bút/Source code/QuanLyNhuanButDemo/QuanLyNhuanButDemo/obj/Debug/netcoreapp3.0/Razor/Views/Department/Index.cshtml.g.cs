#pragma checksum "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Views\Department\Index.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "6ab234f1a48f2bc77d095fd37160252427cd4873"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Department_Index), @"mvc.1.0.view", @"/Views/Department/Index.cshtml")]
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
#line 1 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Views\_ViewImports.cshtml"
using QuanLyNhuanButDemo;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Views\_ViewImports.cshtml"
using QuanLyNhuanButDemo.Models;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Views\Department\Index.cshtml"
using QuanLyNhuanButDemo.DTOs;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"6ab234f1a48f2bc77d095fd37160252427cd4873", @"/Views/Department/Index.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"21678921482bc67a76470b8c561aaa177e12d4c0", @"/Views/_ViewImports.cshtml")]
    public class Views_Department_Index : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<List<DepartmentTypeDTO>>
    {
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_0 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("id", new global::Microsoft.AspNetCore.Html.HtmlString("form-department-add"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_1 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("method", "POST", global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_2 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("class", new global::Microsoft.AspNetCore.Html.HtmlString("modal-body"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_3 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("id", new global::Microsoft.AspNetCore.Html.HtmlString("form-acc-updt"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_4 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("src", new global::Microsoft.AspNetCore.Html.HtmlString("~/lib/datatables/jquery.dataTables.js"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_5 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("src", new global::Microsoft.AspNetCore.Html.HtmlString("~/lib/datatables/dataTables.bootstrap4.js"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_6 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("src", new global::Microsoft.AspNetCore.Html.HtmlString("~/lib/moment/moment.min.js"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_7 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("src", new global::Microsoft.AspNetCore.Html.HtmlString("~/lib/datatables/datetime-moment.js"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_8 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("src", new global::Microsoft.AspNetCore.Html.HtmlString("~/lib/jquery/jquery.masknumber.js"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_9 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("src", new global::Microsoft.AspNetCore.Html.HtmlString("~/js/department.js"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
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
        private global::Microsoft.AspNetCore.Mvc.TagHelpers.FormTagHelper __Microsoft_AspNetCore_Mvc_TagHelpers_FormTagHelper;
        private global::Microsoft.AspNetCore.Mvc.TagHelpers.RenderAtEndOfFormTagHelper __Microsoft_AspNetCore_Mvc_TagHelpers_RenderAtEndOfFormTagHelper;
        private global::Microsoft.AspNetCore.Mvc.TagHelpers.OptionTagHelper __Microsoft_AspNetCore_Mvc_TagHelpers_OptionTagHelper;
        private global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.UrlResolutionTagHelper __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper;
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
#nullable restore
#line 1 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Views\Department\Index.cshtml"
  
    ViewData["Title"] = "Quản lý đơn vị";

#line default
#line hidden
#nullable disable
            WriteLiteral("<ol class=\"breadcrumb\">\r\n    <li class=\"breadcrumb-item\">\r\n        <i class=\"fas fa-plus-square\"></i>\r\n        Tạo mới dơn vị\r\n    </li>\r\n</ol>\r\n");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("form", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "6ab234f1a48f2bc77d095fd37160252427cd48737913", async() => {
                WriteLiteral(@"
    <div class=""row"">
        <div class=""col-md-6"">
            <div class=""form-group"">
                <label for=""DepartmentTypeAdd""><strong>Loại đơn vị</strong></label>
                <select class=""form-control"" id=""DepartmentTypeAdd"" name=""DepartmentTypeAdd"">
");
#nullable restore
#line 18 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Views\Department\Index.cshtml"
                     foreach (var item in Model)
                    {

#line default
#line hidden
#nullable disable
                WriteLiteral("                        ");
                __tagHelperExecutionContext = __tagHelperScopeManager.Begin("option", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "6ab234f1a48f2bc77d095fd37160252427cd48738797", async() => {
#nullable restore
#line 20 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Views\Department\Index.cshtml"
                                                          Write(item.DepartmentType);

#line default
#line hidden
#nullable disable
                }
                );
                __Microsoft_AspNetCore_Mvc_TagHelpers_OptionTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.OptionTagHelper>();
                __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_OptionTagHelper);
                BeginWriteTagHelperAttribute();
#nullable restore
#line 20 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Views\Department\Index.cshtml"
                           WriteLiteral(item.DepartmentTypeId);

#line default
#line hidden
#nullable disable
                __tagHelperStringValueBuffer = EndWriteTagHelperAttribute();
                __Microsoft_AspNetCore_Mvc_TagHelpers_OptionTagHelper.Value = __tagHelperStringValueBuffer;
                __tagHelperExecutionContext.AddTagHelperAttribute("value", __Microsoft_AspNetCore_Mvc_TagHelpers_OptionTagHelper.Value, global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
                await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
                if (!__tagHelperExecutionContext.Output.IsContentModified)
                {
                    await __tagHelperExecutionContext.SetOutputContentAsync();
                }
                Write(__tagHelperExecutionContext.Output);
                __tagHelperExecutionContext = __tagHelperScopeManager.End();
                WriteLiteral("\r\n");
#nullable restore
#line 21 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Views\Department\Index.cshtml"
                    }

#line default
#line hidden
#nullable disable
                WriteLiteral(@"                </select>
            </div>
        </div>
        <div class=""col-md-6"">
            <div class=""form-group"">
                <label for=""DepartmentAdd""><strong>Tên đơn vị</strong></label>
                <input type=""text"" class=""form-control"" name=""DepartmentAdd"" id=""DepartmentAdd"" pattern="".{1,400}"">
            </div>
        </div>
    </div>
    <div class=""row mb-3"">
        <div class=""col-md-4"">
            <div class=""form-group"">
                <label for=""StockRateAdd""><strong>Mức khoán</strong></label>
                <div class=""input-group"">
                    <input type=""number"" class=""form-control"" name=""StockRateAdd"" id=""StockRateAdd"" min=""0"" max=""100"" step=""any"" value=""0"">
                    <div class=""input-group-append"">
                        <span class=""input-group-text""><strong>%</strong></span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <button type=""submit"" class=""btn btn-success m");
                WriteLiteral("b-3\">Tạo mới</button>\r\n");
            }
            );
            __Microsoft_AspNetCore_Mvc_TagHelpers_FormTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.FormTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_FormTagHelper);
            __Microsoft_AspNetCore_Mvc_TagHelpers_RenderAtEndOfFormTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.RenderAtEndOfFormTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_RenderAtEndOfFormTagHelper);
            __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_0);
            __Microsoft_AspNetCore_Mvc_TagHelpers_FormTagHelper.Method = (string)__tagHelperAttribute_1.Value;
            __tagHelperExecutionContext.AddTagHelperAttribute(__tagHelperAttribute_1);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral(@"
<!-- DataTables Example -->
<div class=""card mb-3"">
    <div class=""card-header"">
        <i class=""fas fa-table""></i>
        Danh sách đơn vị
    </div>
    <div class=""card-body"">
        <div class=""table-responsive"">
            <table class=""table table-bordered table-hover animated fadeIn"" id=""dataTable"" width=""100%"" cellspacing=""0"">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th></th>
                        <th>Loại đơn vị</th>
                        <th>Tên đơn vị</th>
                        <th>Mức khoán</th>
                        <th>Chỉnh sửa</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>ID</th>
                        <th></th>
                        <th>Loại đơn vị</th>
                        <th>Tên đơn vị</th>
                        <th>Mức khoán</th>
                        <th>Chỉnh sửa</th>
             ");
            WriteLiteral("       </tr>\r\n                </tfoot>\r\n                <tbody id=\"dataTable-body\">\r\n                </tbody>\r\n            </table>\r\n        </div>\r\n    </div>\r\n    <div class=\"card-footer small text-muted\">Cập nhật lúc ");
#nullable restore
#line 81 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Views\Department\Index.cshtml"
                                                      Write(DateTime.Now.ToString("dd/MM/yyyy hh:mm tt"));

#line default
#line hidden
#nullable disable
            WriteLiteral(@"</div>
</div>
<div class=""modal fade"" id=""modalUpdtDepartmentForm"" role=""dialog"" aria-labelledby=""myModalLabel"" aria-hidden=""true"">
    <div class=""modal-dialog modal-lg"" role=""document"">
        <div class=""modal-content"">
            <div class=""row ml-auto mr-2 mt-2"">
                <button type=""button"" id=""myBtn"" class=""close"" data-dismiss=""modal""><i class=""fas fa-times-circle""></i></button>
            </div>
            <h3 class=""text-center mt-2"" style=""color: #00cc33"">Chỉnh sửa đơn vị</h3>
            ");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("form", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "6ab234f1a48f2bc77d095fd37160252427cd487315664", async() => {
                WriteLiteral(@"
                <input type=""hidden"" name=""DepartmentIdUpdt"" id=""DepartmentIdUpdt"">
                <div class=""row mb-2"">
                    <div class=""col-md-6"">
                        <div class=""form-group"">
                            <label for=""DepartmentTypeUpdt""><strong>Loại đơn vị</strong></label>
                            <select class=""form-control"" id=""DepartmentTypeUpdt"" name=""DepartmentTypeUpdt"">
");
#nullable restore
#line 97 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Views\Department\Index.cshtml"
                                 foreach (var item in Model)
                                {

#line default
#line hidden
#nullable disable
                WriteLiteral("                                    ");
                __tagHelperExecutionContext = __tagHelperScopeManager.Begin("option", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "6ab234f1a48f2bc77d095fd37160252427cd487316744", async() => {
#nullable restore
#line 99 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Views\Department\Index.cshtml"
                                                                      Write(item.DepartmentType);

#line default
#line hidden
#nullable disable
                }
                );
                __Microsoft_AspNetCore_Mvc_TagHelpers_OptionTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.OptionTagHelper>();
                __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_OptionTagHelper);
                BeginWriteTagHelperAttribute();
#nullable restore
#line 99 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Views\Department\Index.cshtml"
                                       WriteLiteral(item.DepartmentTypeId);

#line default
#line hidden
#nullable disable
                __tagHelperStringValueBuffer = EndWriteTagHelperAttribute();
                __Microsoft_AspNetCore_Mvc_TagHelpers_OptionTagHelper.Value = __tagHelperStringValueBuffer;
                __tagHelperExecutionContext.AddTagHelperAttribute("value", __Microsoft_AspNetCore_Mvc_TagHelpers_OptionTagHelper.Value, global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
                await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
                if (!__tagHelperExecutionContext.Output.IsContentModified)
                {
                    await __tagHelperExecutionContext.SetOutputContentAsync();
                }
                Write(__tagHelperExecutionContext.Output);
                __tagHelperExecutionContext = __tagHelperScopeManager.End();
                WriteLiteral("\r\n");
#nullable restore
#line 100 "D:\GitHub\Workplace\Projects\Quản Lý Nhuận Bút\Source code\QuanLyNhuanButDemo\QuanLyNhuanButDemo\Views\Department\Index.cshtml"
                                }

#line default
#line hidden
#nullable disable
                WriteLiteral(@"                            </select>
                        </div>
                    </div>
                    <div class=""col-md-6"">
                        <div class=""form-group"">
                            <label for=""DepartmentUpdt""><strong>Tên đơn vị</strong></label>
                            <input type=""text"" class=""form-control"" name=""DepartmentUpdt"" id=""DepartmentUpdt"" pattern="".{1,400}"">
                        </div>
                    </div>
                </div>
                <div class=""row mb-3"">
                    <div class=""col-md-4"">
                        <div class=""form-group"">
                            <label for=""StockRateUpdt""><strong>Mức khoán</strong></label>
                            <div class=""input-group"">
                                <input type=""number"" class=""form-control"" name=""StockRateUpdt"" id=""StockRateUpdt"" min=""0"" max=""100"" step=""any"" value=""0"">
                                <div class=""input-group-append"">
                      ");
                WriteLiteral(@"              <span class=""input-group-text""><strong>%</strong></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class=""text-center mb-2"">
                    <button type=""submit"" class=""btn btn-success"">Cập nhật</button>
                </div>
            ");
            }
            );
            __Microsoft_AspNetCore_Mvc_TagHelpers_FormTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.FormTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_FormTagHelper);
            __Microsoft_AspNetCore_Mvc_TagHelpers_RenderAtEndOfFormTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.RenderAtEndOfFormTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_RenderAtEndOfFormTagHelper);
            __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_2);
            __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_3);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral(@"
        </div>
    </div>
</div>
<div class=""modal fade"" id=""confirmDeleteModal"" tabindex=""-1"" role=""dialog"" aria-labelledby=""exampleModalLabel"" aria-hidden=""true"">
    <div class=""modal-dialog"" role=""document"">
        <div class=""modal-content"">
            <div class=""modal-header"">
                <h5 class=""modal-title"" id=""exampleModalLabel"">Bạn chắc chắn muốn xóa?</h5>
                <button class=""close"" type=""button"" data-dismiss=""modal"" aria-label=""Close"">
                    <span aria-hidden=""true"">×</span>
                </button>
            </div>
            <input type=""hidden"" id=""delId"" />
            <div class=""modal-body"">Nhấn ""Xóa"" ở dưới nếu đồng ý.</div>
            <div class=""modal-footer"">
                <button class=""btn btn-secondary"" type=""button"" data-dismiss=""modal"">Bỏ qua</button>
                <button class=""btn btn-primary"" id=""delDepartmentBtn"">Xóa</button>
            </div>
        </div>
    </div>
</div>
");
            DefineSection("QuanLyDonVi", async() => {
                WriteLiteral("\r\n    active\r\n");
            }
            );
            DefineSection("Scripts", async() => {
                WriteLiteral("\r\n    ");
                __tagHelperExecutionContext = __tagHelperScopeManager.Begin("script", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "6ab234f1a48f2bc77d095fd37160252427cd487322972", async() => {
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
                __tagHelperExecutionContext = __tagHelperScopeManager.Begin("script", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "6ab234f1a48f2bc77d095fd37160252427cd487324072", async() => {
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
                __tagHelperExecutionContext = __tagHelperScopeManager.Begin("script", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "6ab234f1a48f2bc77d095fd37160252427cd487325172", async() => {
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
                WriteLiteral("\r\n    ");
                __tagHelperExecutionContext = __tagHelperScopeManager.Begin("script", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "6ab234f1a48f2bc77d095fd37160252427cd487326272", async() => {
                }
                );
                __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.UrlResolutionTagHelper>();
                __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper);
                __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_7);
                await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
                if (!__tagHelperExecutionContext.Output.IsContentModified)
                {
                    await __tagHelperExecutionContext.SetOutputContentAsync();
                }
                Write(__tagHelperExecutionContext.Output);
                __tagHelperExecutionContext = __tagHelperScopeManager.End();
                WriteLiteral("\r\n    ");
                __tagHelperExecutionContext = __tagHelperScopeManager.Begin("script", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "6ab234f1a48f2bc77d095fd37160252427cd487327372", async() => {
                }
                );
                __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.UrlResolutionTagHelper>();
                __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper);
                __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_8);
                await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
                if (!__tagHelperExecutionContext.Output.IsContentModified)
                {
                    await __tagHelperExecutionContext.SetOutputContentAsync();
                }
                Write(__tagHelperExecutionContext.Output);
                __tagHelperExecutionContext = __tagHelperScopeManager.End();
                WriteLiteral("\r\n    ");
                __tagHelperExecutionContext = __tagHelperScopeManager.Begin("script", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "6ab234f1a48f2bc77d095fd37160252427cd487328472", async() => {
                }
                );
                __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.UrlResolutionTagHelper>();
                __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper);
                __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_9);
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
            WriteLiteral("\r\n");
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
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<List<DepartmentTypeDTO>> Html { get; private set; }
    }
}
#pragma warning restore 1591
