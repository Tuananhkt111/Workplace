#pragma checksum "D:\Google Drive\Pet Shop - C# Project - Nhom 9\Source Code\PetShop\PetShop\Views\Admin\Category.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "176489fe701591517e28873eb49a21dbb115aa5f"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Admin_Category), @"mvc.1.0.view", @"/Views/Admin/Category.cshtml")]
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
#line 1 "D:\Google Drive\Pet Shop - C# Project - Nhom 9\Source Code\PetShop\PetShop\Views\_ViewImports.cshtml"
using PetShop;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "D:\Google Drive\Pet Shop - C# Project - Nhom 9\Source Code\PetShop\PetShop\Views\_ViewImports.cshtml"
using PetShop.Models;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"176489fe701591517e28873eb49a21dbb115aa5f", @"/Views/Admin/Category.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"d9cb11fa8dfc4463cdadb982486cbc1eda18e7a4", @"/Views/_ViewImports.cshtml")]
    public class Views_Admin_Category : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<dynamic>
    {
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_0 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("asp-controller", "Admin", global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_1 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("asp-action", "Index", global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_2 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("class", new global::Microsoft.AspNetCore.Html.HtmlString("modal-body"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_3 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("id", new global::Microsoft.AspNetCore.Html.HtmlString("form-pet-cat-ins"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_4 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("class", new global::Microsoft.AspNetCore.Html.HtmlString("d-flex flex-column mt-2 align-items-start "), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_5 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("id", new global::Microsoft.AspNetCore.Html.HtmlString("form-pet-cat-search"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_6 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("id", new global::Microsoft.AspNetCore.Html.HtmlString("form-pet-cat-updt"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_7 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("id", new global::Microsoft.AspNetCore.Html.HtmlString("form-acc-cat-ins"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_8 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("id", new global::Microsoft.AspNetCore.Html.HtmlString("form-acc-cat-search"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_9 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("id", new global::Microsoft.AspNetCore.Html.HtmlString("form-acc-cat-updt"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_10 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("src", new global::Microsoft.AspNetCore.Html.HtmlString("~/js/categoryAdmin.js"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
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
        private global::Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper;
        private global::Microsoft.AspNetCore.Mvc.TagHelpers.FormTagHelper __Microsoft_AspNetCore_Mvc_TagHelpers_FormTagHelper;
        private global::Microsoft.AspNetCore.Mvc.TagHelpers.RenderAtEndOfFormTagHelper __Microsoft_AspNetCore_Mvc_TagHelpers_RenderAtEndOfFormTagHelper;
        private global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.UrlResolutionTagHelper __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper;
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
            WriteLiteral("\r\n");
#nullable restore
#line 2 "D:\Google Drive\Pet Shop - C# Project - Nhom 9\Source Code\PetShop\PetShop\Views\Admin\Category.cshtml"
  
    ViewData["Title"] = "Category";
    Layout = "~/Views/Shared/AdminLayout.cshtml";

#line default
#line hidden
#nullable disable
            WriteLiteral("<div class=\"page-top-info\">\r\n    <div class=\"container\">\r\n        <h4>Category Management</h4>\r\n        <div class=\"site-pagination\">\r\n            ");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("a", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "176489fe701591517e28873eb49a21dbb115aa5f7867", async() => {
                WriteLiteral("Admin");
            }
            );
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper);
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.Controller = (string)__tagHelperAttribute_0.Value;
            __tagHelperExecutionContext.AddTagHelperAttribute(__tagHelperAttribute_0);
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.Action = (string)__tagHelperAttribute_1.Value;
            __tagHelperExecutionContext.AddTagHelperAttribute(__tagHelperAttribute_1);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral(@" /
            <a href=""#"">Category</a>
        </div>
    </div>
</div>
<div class=""d-flex flex-row mb-5"">
    <div class=""col-6 mt-4"" id=""pet-cat-body"">
        <h2 class=""text-center mb-4"">Pet Category</h2>
        <a href=""#"" data-toggle=""modal"" data-target=""#modalInsPetCatForm"" style=""cursor:pointer;"" onclick=""generatePetCatID()"">Insert new pet category</a>
        <div class=""modal fade"" id=""modalInsPetCatForm"" role=""dialog"" aria-labelledby=""myModalLabel"" aria-hidden=""true"">
            <div class=""modal-dialog"" role=""document"">
                <div class=""modal-content"">
                    <h3 class=""text-center mt-2"" style=""color: #00cc33"">Insert Pet Category</h3>
                    ");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("form", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "176489fe701591517e28873eb49a21dbb115aa5f9979", async() => {
                WriteLiteral(@"
                        <div class=""md-form form-sm mb-3"">
                            <i class=""fa fa-id-card""></i>
                            <label for=""petCatIDIns"">PetCatID</label>
                            <div class=""d-flex flex-row align-items-center"">
                                <input type=""text"" name=""petCatIDIns"" id=""petCatIDIns"" class=""form-control form-control-sm mr-2"" disabled>
                                <input type=""button"" class=""btn btn-primary"" onclick=""generatePetCatID()"" value=""Generate"" />
                            </div>
                        </div>
                        <div class=""md-form form-sm mb-3"">
                            <i class=""fa fa-pencil""></i>
                            <label for=""petTypeIns"">Pet Type</label>
                            <input type=""text"" name=""petTypeIns"" id=""petTypeIns"" class=""form-control form-control-sm"" pattern="".{1,40}"">
                        </div>
                        <div class=""text-center mt-2"">
     ");
                WriteLiteral("                       <input type=\"submit\" class=\"btn btn-success\" value=\"Insert\" />\r\n                        </div>\r\n                    ");
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
            WriteLiteral("\r\n                </div>\r\n            </div>\r\n        </div>\r\n        ");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("form", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "176489fe701591517e28873eb49a21dbb115aa5f12697", async() => {
                WriteLiteral(@"
            <input type=""text"" name=""petCatSearch"" id=""petCatSearch"" class=""form-control form-control-sm mt-2"" placeholder=""Enter pet type"">
            <input type=""button"" class=""btn btn-success mt-2 mb-2"" value=""Search"" onclick=""searchPetCatByLikeType()"" />
        ");
            }
            );
            __Microsoft_AspNetCore_Mvc_TagHelpers_FormTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.FormTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_FormTagHelper);
            __Microsoft_AspNetCore_Mvc_TagHelpers_RenderAtEndOfFormTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.RenderAtEndOfFormTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_RenderAtEndOfFormTagHelper);
            __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_4);
            __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_5);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral(@"
        <div class=""mt-2"">
            <h4 id=""petCatSearch-not-found"" style=""display: none; color: #0062cc"">No pet category found</h4>
            <table border=""1"" class=""table table-hover table-striped table-dark animated fadeIn"" style=""display: none;"" id=""petCatTable"">
                <thead>
                    <tr>
                        <th>PetCatID</th>
                        <th>PetType</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody id=""tbodypetCatSearch"">
                </tbody>
            </table>
            <div class=""modal fade"" id=""modalUpdtPetCatForm"" role=""dialog"" aria-labelledby=""myModalLabel"" aria-hidden=""true"">
                <div class=""modal-dialog"" role=""document"">
                    <div class=""modal-content"">
                        <h3 class=""text-center mt-2"" style=""color: #00cc33"">Update Pet Category</h3>
                        ");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("form", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "176489fe701591517e28873eb49a21dbb115aa5f15422", async() => {
                WriteLiteral(@"
                            <div class=""md-form form-sm mb-3"">
                                <i class=""fa fa-id-card""></i>
                                <label for=""petCatIDUpdt"">PetCatID</label>
                                <input type=""text"" name=""petCatIDUpdt"" id=""petCatIDUpdt"" class=""form-control form-control-sm mr-2"" disabled>
                            </div>
                            <div class=""md-form form-sm mb-3"">
                                <i class=""fa fa-pencil""></i>
                                <label for=""petTypeUpdt"">Pet Type</label>
                                <input type=""text"" name=""petTypeUpdt"" id=""petTypeUpdt"" class=""form-control form-control-sm"" pattern="".{1,40}"">
                            </div>
                            <div class=""text-center mt-2"">
                                <input type=""submit"" class=""btn btn-success"" value=""Update"" />
                            </div>
                        ");
            }
            );
            __Microsoft_AspNetCore_Mvc_TagHelpers_FormTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.FormTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_FormTagHelper);
            __Microsoft_AspNetCore_Mvc_TagHelpers_RenderAtEndOfFormTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.RenderAtEndOfFormTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_RenderAtEndOfFormTagHelper);
            __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_2);
            __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_6);
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
        </div>
    </div>
    <div class=""col-6 mt-4"" id=""acc-cat-body"">
        <h2 class=""text-center mb-4"">Accessory Category</h2>
        <a href=""#"" data-toggle=""modal"" data-target=""#modalInsAccCatForm"" style=""cursor:pointer;"" onclick=""generateAccCatID(); loadCbPetAccessory('petCatIDInsFr');"">Insert new accessory category</a>
        <div class=""modal fade"" id=""modalInsAccCatForm"" role=""dialog"" aria-labelledby=""myModalLabel"" aria-hidden=""true"">
            <div class=""modal-dialog"" role=""document"">
                <div class=""modal-content"">
                    <h3 class=""text-center mt-2"" style=""color: #00cc33"">Insert Accessory Category</h3>
                    ");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("form", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "176489fe701591517e28873eb49a21dbb115aa5f18627", async() => {
                WriteLiteral(@"
                        <div class=""md-form form-sm mb-3"">
                            <i class=""fa fa-id-card""></i>
                            <label for=""petCatIDIns"">AccCatID</label>
                            <div class=""d-flex flex-row align-items-center"">
                                <input type=""text"" name=""accCatIDIns"" id=""accCatIDIns"" class=""form-control form-control-sm mr-2"" disabled>
                                <input type=""button"" class=""btn btn-primary"" onclick=""generateAccCatID()"" value=""Generate"" />
                            </div>
                        </div>
                        <div class=""md-form form-sm mb-3"">
                            <i class=""fa fa-pencil""></i>
                            <label for=""accCatNameIns"">Accessory Category Name</label>
                            <input type=""text"" name=""accCatNameIns"" id=""accCatNameIns"" class=""form-control form-control-sm"" pattern="".{1,40}"">
                        </div>
                        <div class=""m");
                WriteLiteral(@"d-form form-sm mb-3"">
                            <i class=""fa fa-pencil""></i>
                            <label for=""petCatIDInsFr"">Pet Type</label>
                            <select name=""petCatIDInsFr"" id=""petCatIDInsFr"" class=""form-control form-control-sm"">
                            </select>
                        </div>
                        <div class=""text-center mt-2"">
                            <input type=""submit"" class=""btn btn-success"" value=""Insert"" />
                        </div>
                    ");
            }
            );
            __Microsoft_AspNetCore_Mvc_TagHelpers_FormTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.FormTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_FormTagHelper);
            __Microsoft_AspNetCore_Mvc_TagHelpers_RenderAtEndOfFormTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.RenderAtEndOfFormTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_RenderAtEndOfFormTagHelper);
            __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_2);
            __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_7);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral("\r\n                </div>\r\n            </div>\r\n        </div>\r\n        ");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("form", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "176489fe701591517e28873eb49a21dbb115aa5f21756", async() => {
                WriteLiteral(@"
            <input type=""text"" name=""accCatSearch"" id=""accCatSearch"" class=""form-control form-control-sm mt-2"" placeholder=""Enter accessory category name"">
            <input type=""button"" class=""btn btn-success mt-2 mb-2"" value=""Search"" onclick=""searchAccCatByLikeName()"" />
        ");
            }
            );
            __Microsoft_AspNetCore_Mvc_TagHelpers_FormTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.FormTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_FormTagHelper);
            __Microsoft_AspNetCore_Mvc_TagHelpers_RenderAtEndOfFormTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.RenderAtEndOfFormTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_RenderAtEndOfFormTagHelper);
            __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_4);
            __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_8);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral(@"
        <div class=""mt-2"">
            <h4 id=""accCatSearch-not-found"" style=""display: none; color: #0062cc"">No accessory category found</h4>
            <table border=""1"" class=""table table-hover table-striped table-dark animated fadeIn"" style=""display: none;"" id=""accCatTable"">
                <thead>
                    <tr>
                        <th>AccCatID</th>
                        <th>AccCatName</th>
                        <th>PetType</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody id=""tbodyaccCatSearch"">
                </tbody>
            </table>
            <div class=""modal fade"" id=""modalUpdtAccCatForm"" role=""dialog"" aria-labelledby=""myModalLabel"" aria-hidden=""true"">
                <div class=""modal-dialog"" role=""document"">
                    <div class=""modal-content"">
                        <h3 class=""text-center mt-2"" style=""color: #00cc33"">Update Accessory ");
            WriteLiteral("Category</h3>\r\n                        ");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("form", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "176489fe701591517e28873eb49a21dbb115aa5f24586", async() => {
                WriteLiteral(@"
                            <div class=""md-form form-sm mb-3"">
                                <i class=""fa fa-id-card""></i>
                                <label for=""accCatIDUpdt"">AccCatID</label>
                                <input type=""text"" name=""accCatIDUpdt"" id=""accCatIDUpdt"" class=""form-control form-control-sm mr-2"" disabled>
                            </div>
                            <div class=""md-form form-sm mb-3"">
                                <i class=""fa fa-pencil""></i>
                                <label for=""accCatNameUpdt"">Accessory Category Name</label>
                                <input type=""text"" name=""accCatNameUpdt"" id=""accCatNameUpdt"" class=""form-control form-control-sm"" pattern="".{1,40}"">
                            </div>
                            <div class=""md-form form-sm mb-3"">
                                <i class=""fa fa-pencil""></i>
                                <label for=""petCatIDUpdtFr"">Pet Type</label>
                                ");
                WriteLiteral(@"<select name=""petCatIDUpdtFr"" id=""petCatIDUpdtFr"" class=""form-control form-control-sm"">
                                </select>
                            </div>
                            <div class=""text-center mt-2"">
                                <input type=""submit"" class=""btn btn-success"" value=""Update"" />
                            </div>
                        ");
            }
            );
            __Microsoft_AspNetCore_Mvc_TagHelpers_FormTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.FormTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_FormTagHelper);
            __Microsoft_AspNetCore_Mvc_TagHelpers_RenderAtEndOfFormTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.RenderAtEndOfFormTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_RenderAtEndOfFormTagHelper);
            __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_2);
            __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_9);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral("\r\n                    </div>\r\n                </div>\r\n            </div>\r\n        </div>\r\n    </div>\r\n</div>\r\n");
            DefineSection("Scripts", async() => {
                WriteLiteral("\r\n    ");
                __tagHelperExecutionContext = __tagHelperScopeManager.Begin("script", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "176489fe701591517e28873eb49a21dbb115aa5f27693", async() => {
                }
                );
                __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.UrlResolutionTagHelper>();
                __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper);
                __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_10);
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
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<dynamic> Html { get; private set; }
    }
}
#pragma warning restore 1591
