#pragma checksum "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "c482d92e44f2b3d9e8558dc02c6a0e329a8dd49c"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Accessory_Index), @"mvc.1.0.view", @"/Views/Accessory/Index.cshtml")]
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
#line 1 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\_ViewImports.cshtml"
using PetShop;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\_ViewImports.cshtml"
using PetShop.Models;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"c482d92e44f2b3d9e8558dc02c6a0e329a8dd49c", @"/Views/Accessory/Index.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"d9cb11fa8dfc4463cdadb982486cbc1eda18e7a4", @"/Views/_ViewImports.cshtml")]
    public class Views_Accessory_Index : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<PetShop.Library.PagingList<PetShop.DTO.Accessory>>
    {
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_0 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("asp-controller", "Home", global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_1 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("asp-action", "Index", global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_2 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("asp-controller", "Accessory", global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_3 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("src", new global::Microsoft.AspNetCore.Html.HtmlString("~/js/accessories.js"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
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
        private global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.UrlResolutionTagHelper __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper;
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
#nullable restore
#line 2 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
  
    ViewData["Title"] = "Accessory";

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n<!-- Page info -->\r\n<div class=\"page-top-info\">\r\n    <div class=\"container\">\r\n        <h4>Accessories Page</h4>\r\n        <div class=\"site-pagination\">\r\n            ");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("a", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "c482d92e44f2b3d9e8558dc02c6a0e329a8dd49c4885", async() => {
                WriteLiteral("Home");
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
            WriteLiteral(" /\r\n            ");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("a", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "c482d92e44f2b3d9e8558dc02c6a0e329a8dd49c6258", async() => {
                WriteLiteral("Accessories");
            }
            );
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper);
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.Controller = (string)__tagHelperAttribute_2.Value;
            __tagHelperExecutionContext.AddTagHelperAttribute(__tagHelperAttribute_2);
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.Action = (string)__tagHelperAttribute_1.Value;
            __tagHelperExecutionContext.AddTagHelperAttribute(__tagHelperAttribute_1);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral("\r\n");
#nullable restore
#line 13 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
             if (ViewData["AccCatIDSearch"] != null)
            {
                

#line default
#line hidden
#nullable disable
            WriteLiteral("/");
            WriteLiteral(" <a href=\"#\"> Accessory Category </a>\r\n");
#nullable restore
#line 16 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
            }

#line default
#line hidden
#nullable disable
#nullable restore
#line 17 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
             if (ViewData["PetCatIDSearch"] != null)
            {
                

#line default
#line hidden
#nullable disable
            WriteLiteral("/");
            WriteLiteral("<a href=\"#\">Pet Category</a>\r\n");
#nullable restore
#line 20 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
            }

#line default
#line hidden
#nullable disable
            WriteLiteral(@"        </div>
    </div>
</div>
<!-- Page info end -->
<!-- Category section -->
<section class=""category-section spad"">
    <div class=""container"">
        <div class=""row"">
            <div class=""col-lg-3 order-2 order-lg-1"">
                <div class=""filter-widget"">
                    <img src=""../img/18395.jpg"" />
                </div>
            </div>
            <div class=""col-lg-9  order-1 order-lg-2 mb-5 mb-lg-0"">
                <div class=""row"">
");
#nullable restore
#line 36 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
                     foreach (var item in Model)
                    {

#line default
#line hidden
#nullable disable
            WriteLiteral(@"                        <div class=""col-lg-4 col-sm-6"">
                            <div class=""product-item animated fadeIn"" style=""margin: 0px 20px;"">
                                <div class=""pi-pic"">
                                    <img class=""imgSrc""");
            BeginWriteAttribute("src", " src=\"", 1521, "\"", 1663, 2);
            WriteAttributeValue("", 1527, "../img/product/", 1527, 15, true);
            WriteAttributeValue("", 1542, new Microsoft.AspNetCore.Mvc.Razor.HelperResult(async(__razor_attribute_value_writer) => {
                PushWriter(__razor_attribute_value_writer);
#nullable restore
#line 41 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
                                                                             if (item.Image == null)
                                    {

#line default
#line hidden
#nullable disable
                WriteLiteral("noimage.jpg");
#nullable restore
#line 42 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
                                                              } else {

#line default
#line hidden
#nullable disable
#nullable restore
#line 42 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
                                                                       Write(item.Image);

#line default
#line hidden
#nullable disable
#nullable restore
#line 42 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
                                                                                              }

#line default
#line hidden
#nullable disable
                PopWriter();
            }
            ), 1542, 121, false);
            EndWriteAttribute();
            WriteLiteral(" alt=\"Image not found\">\r\n                                    <div class=\"pi-links\">\r\n                                        <a class=\"add-card\" style=\"cursor: pointer;\"");
            BeginWriteAttribute("onclick", " onclick=\"", 1833, "\"", 1867, 3);
            WriteAttributeValue("", 1843, "addToCart(\'", 1843, 11, true);
#nullable restore
#line 44 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
WriteAttributeValue("", 1854, item.AccId, 1854, 11, false);

#line default
#line hidden
#nullable disable
            WriteAttributeValue("", 1865, "\')", 1865, 2, true);
            EndWriteAttribute();
            WriteLiteral("><i class=\"flaticon-bag\"></i><span>ADD TO CART</span></a>\r\n                                        <a");
            BeginWriteAttribute("id", " id=\"", 1969, "\"", 1985, 1);
#nullable restore
#line 45 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
WriteAttributeValue("", 1974, item.AccId, 1974, 11, false);

#line default
#line hidden
#nullable disable
            EndWriteAttribute();
            WriteLiteral(" class=\"wishlist-btn\" style=\"cursor: pointer;\"");
            BeginWriteAttribute("onclick", " onclick=\"", 2032, "\"", 2074, 4);
            WriteAttributeValue("", 2042, "addFavorite(\'", 2042, 13, true);
#nullable restore
#line 45 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
WriteAttributeValue("", 2055, item.AccId, 2055, 11, false);

#line default
#line hidden
#nullable disable
            WriteAttributeValue("", 2066, "\',", 2066, 2, true);
            WriteAttributeValue(" ", 2068, "this)", 2069, 6, true);
            EndWriteAttribute();
            WriteLiteral("><i class=\"flaticon-heart\"></i></a>\r\n                                    </div>\r\n                                </div>\r\n                                <div class=\"pi-text\">\r\n                                    <h6>\r\n");
#nullable restore
#line 50 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
                                         if (item.SalePercent > 0)
                                        {

#line default
#line hidden
#nullable disable
            WriteLiteral("                                            <del style=\"color: gray;\">$");
#nullable restore
#line 52 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
                                                                  Write(string.Format($"{item.Price:0.00}"));

#line default
#line hidden
#nullable disable
            WriteLiteral("</del><br>");
            WriteLiteral("$");
#nullable restore
#line 52 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
                                                                                                                              Write(String.Format($"{item.Price * (1 - item.SalePercent):0.00}"));

#line default
#line hidden
#nullable disable
#nullable restore
#line 52 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
                                                                                                                                                                                                

                                        }
                                        else
                                        {
                                            

#line default
#line hidden
#nullable disable
            WriteLiteral("$");
#nullable restore
#line 57 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
                                                     Write(string.Format($"{item.Price:0.00}"));

#line default
#line hidden
#nullable disable
#nullable restore
#line 57 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
                                                                                              
                                        }

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                                    </h6>\r\n                                    <a");
            BeginWriteAttribute("href", " href=\"", 2954, "\"", 3009, 2);
            WriteAttributeValue("", 2961, "../Accessory/FindAccById?accIdSearch=", 2961, 37, true);
#nullable restore
#line 61 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
WriteAttributeValue("", 2998, item.AccId, 2998, 11, false);

#line default
#line hidden
#nullable disable
            EndWriteAttribute();
            WriteLiteral(">");
#nullable restore
#line 61 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
                                                                                          Write(item.AccName);

#line default
#line hidden
#nullable disable
            WriteLiteral("</a>\r\n                                </div>\r\n");
#nullable restore
#line 63 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
                                 if (item.SalePercent > 0)
                                {

#line default
#line hidden
#nullable disable
            WriteLiteral("                                    <div class=\"tag-sale\" style=\"font-size: 20px;\">");
#nullable restore
#line 65 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
                                                                              Write(string.Format($"{item.SalePercent * 100:0}"));

#line default
#line hidden
#nullable disable
            WriteLiteral("%</div>\r\n");
#nullable restore
#line 66 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
                                }

#line default
#line hidden
#nullable disable
            WriteLiteral("                            </div>\r\n                        </div>\r\n");
#nullable restore
#line 69 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
                    }

#line default
#line hidden
#nullable disable
#nullable restore
#line 70 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
                      
                        var prevDisabled = !Model.HasPreviousPage ? "disabled" : "";
                        var nextDisabled = !Model.HasNextPage ? "disabled" : "";
                    

#line default
#line hidden
#nullable disable
            WriteLiteral("                    <div class=\"mt-3 btn-group\">\r\n                        ");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("a", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "c482d92e44f2b3d9e8558dc02c6a0e329a8dd49c17938", async() => {
                WriteLiteral("\r\n                            Previous\r\n                        ");
            }
            );
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper);
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.Controller = (string)__tagHelperAttribute_2.Value;
            __tagHelperExecutionContext.AddTagHelperAttribute(__tagHelperAttribute_2);
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.Action = (string)__tagHelperAttribute_1.Value;
            __tagHelperExecutionContext.AddTagHelperAttribute(__tagHelperAttribute_1);
            if (__Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.RouteValues == null)
            {
                throw new InvalidOperationException(InvalidTagHelperIndexerAssignment("asp-route-pageNumber", "Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper", "RouteValues"));
            }
            BeginWriteTagHelperAttribute();
#nullable restore
#line 76 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
                                      WriteLiteral(Model.PageIndex - 1);

#line default
#line hidden
#nullable disable
            __tagHelperStringValueBuffer = EndWriteTagHelperAttribute();
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.RouteValues["pageNumber"] = __tagHelperStringValueBuffer;
            __tagHelperExecutionContext.AddTagHelperAttribute("asp-route-pageNumber", __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.RouteValues["pageNumber"], global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
            BeginAddHtmlAttributeValues(__tagHelperExecutionContext, "class", 4, global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
            AddHtmlAttributeValue("", 3875, "btn", 3875, 3, true);
            AddHtmlAttributeValue(" ", 3878, "btn-success", 3879, 12, true);
            AddHtmlAttributeValue(" ", 3890, "btn-lg", 3891, 7, true);
#nullable restore
#line 77 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
AddHtmlAttributeValue(" ", 3897, prevDisabled, 3898, 13, false);

#line default
#line hidden
#nullable disable
            EndAddHtmlAttributeValues(__tagHelperExecutionContext);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral("\r\n                        ");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("a", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "c482d92e44f2b3d9e8558dc02c6a0e329a8dd49c21086", async() => {
                WriteLiteral("\r\n                            Next\r\n                        ");
            }
            );
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper);
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.Controller = (string)__tagHelperAttribute_2.Value;
            __tagHelperExecutionContext.AddTagHelperAttribute(__tagHelperAttribute_2);
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.Action = (string)__tagHelperAttribute_1.Value;
            __tagHelperExecutionContext.AddTagHelperAttribute(__tagHelperAttribute_1);
            if (__Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.RouteValues == null)
            {
                throw new InvalidOperationException(InvalidTagHelperIndexerAssignment("asp-route-pageNumber", "Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper", "RouteValues"));
            }
            BeginWriteTagHelperAttribute();
#nullable restore
#line 81 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
                                      WriteLiteral(Model.PageIndex + 1);

#line default
#line hidden
#nullable disable
            __tagHelperStringValueBuffer = EndWriteTagHelperAttribute();
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.RouteValues["pageNumber"] = __tagHelperStringValueBuffer;
            __tagHelperExecutionContext.AddTagHelperAttribute("asp-route-pageNumber", __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.RouteValues["pageNumber"], global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
            BeginAddHtmlAttributeValues(__tagHelperExecutionContext, "class", 4, global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
            AddHtmlAttributeValue("", 4165, "btn", 4165, 3, true);
            AddHtmlAttributeValue(" ", 4168, "btn-success", 4169, 12, true);
            AddHtmlAttributeValue(" ", 4180, "btn-lg", 4181, 7, true);
#nullable restore
#line 82 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\Index.cshtml"
AddHtmlAttributeValue(" ", 4187, nextDisabled, 4188, 13, false);

#line default
#line hidden
#nullable disable
            EndAddHtmlAttributeValues(__tagHelperExecutionContext);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral("\r\n                    </div>\r\n                </div>\r\n            </div>\r\n        </div>\r\n    </div>\r\n</section>\r\n\r\n<!-- Category section end -->\r\n");
            DefineSection("Scripts", async() => {
                WriteLiteral("\r\n    ");
                __tagHelperExecutionContext = __tagHelperScopeManager.Begin("script", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "c482d92e44f2b3d9e8558dc02c6a0e329a8dd49c24465", async() => {
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
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<PetShop.Library.PagingList<PetShop.DTO.Accessory>> Html { get; private set; }
    }
}
#pragma warning restore 1591
