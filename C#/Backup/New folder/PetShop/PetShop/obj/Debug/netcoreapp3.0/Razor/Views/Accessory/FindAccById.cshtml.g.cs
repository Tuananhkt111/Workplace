#pragma checksum "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "61b1d7bb630c76ddbee79528bde91a413b6ef2d1"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Accessory_FindAccById), @"mvc.1.0.view", @"/Views/Accessory/FindAccById.cshtml")]
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
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"61b1d7bb630c76ddbee79528bde91a413b6ef2d1", @"/Views/Accessory/FindAccById.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"d9cb11fa8dfc4463cdadb982486cbc1eda18e7a4", @"/Views/_ViewImports.cshtml")]
    public class Views_Accessory_FindAccById : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<PetShop.DTO.Accessory>
    {
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_0 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("asp-controller", "Home", global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_1 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("asp-action", "Index", global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_2 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("asp-controller", "Accessory", global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_3 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("src", new global::Microsoft.AspNetCore.Html.HtmlString("~/js/product.js"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
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
#line 2 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
  
    ViewData["Title"] = "FindAccById";

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n<!-- Page info -->\r\n<div class=\"page-top-info\">\r\n    <div class=\"container\">\r\n        <h4>Product Page</h4>\r\n        <div class=\"site-pagination\">\r\n            ");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("a", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "61b1d7bb630c76ddbee79528bde91a413b6ef2d14887", async() => {
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
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("a", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "61b1d7bb630c76ddbee79528bde91a413b6ef2d16260", async() => {
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
            WriteLiteral(@" /
            <a href=""#"">Product</a>
        </div>
    </div>
</div>
<!-- Page info end -->
<!-- product section -->
<section class=""product-section"">
    <div class=""container"">
        <div class=""row"">
            <div class=""col-lg-6"">
                <img class=""product-big-img""");
            BeginWriteAttribute("src", " src=\"", 669, "\"", 702, 2);
            WriteAttributeValue("", 675, "../img/product/", 675, 15, true);
#nullable restore
#line 23 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
WriteAttributeValue("", 690, Model.Image, 690, 12, false);

#line default
#line hidden
#nullable disable
            EndWriteAttribute();
            BeginWriteAttribute("alt", " alt=\"", 703, "\"", 709, 0);
            EndWriteAttribute();
            WriteLiteral(">\r\n            </div>\r\n            <div class=\"col-lg-6 product-details\">\r\n                <h2 class=\"p-title\">");
#nullable restore
#line 26 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
                               Write(Model.AccName);

#line default
#line hidden
#nullable disable
            WriteLiteral("</h2>\r\n                <h3 class=\"p-price\">\r\n");
#nullable restore
#line 28 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
                     if (Model.SalePercent == 0)
                    {
                        

#line default
#line hidden
#nullable disable
            WriteLiteral("$");
#nullable restore
#line 30 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
                                  Write(string.Format($"{Model.Price:0.00}"));

#line default
#line hidden
#nullable disable
#nullable restore
#line 30 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
                                                                             ;
                    }
                    else
                    {

#line default
#line hidden
#nullable disable
            WriteLiteral("                        <del style=\"color:gray\" class=\"ml-2\">$");
#nullable restore
#line 34 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
                                                          Write(string.Format($"{Model.Price:0.00}"));

#line default
#line hidden
#nullable disable
            WriteLiteral("</del>\r\n");
            WriteLiteral("$");
#nullable restore
#line 35 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
                                  Write(string.Format($"{Model.Price * (1 - Model.SalePercent):0.00}"));

#line default
#line hidden
#nullable disable
#nullable restore
#line 35 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
                                                                                                       
                    }

#line default
#line hidden
#nullable disable
            WriteLiteral("                </h3>\r\n                <h4 class=\"p-stock\">\r\n                    Available:\r\n");
#nullable restore
#line 40 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
                     if (Model.IsDelete == true)
                    {

#line default
#line hidden
#nullable disable
            WriteLiteral("                        <span style=\"color:red;\">Stop selling</span>\r\n");
#nullable restore
#line 43 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
                    }
                    else if (Model.AvailableQuantity == 0)
                    {

#line default
#line hidden
#nullable disable
            WriteLiteral("                        <span style=\"color:red\">Out of Stock</span>\r\n");
#nullable restore
#line 47 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
                    }
                    else
                    {

#line default
#line hidden
#nullable disable
            WriteLiteral("                        <span style=\"color:red\">In Stock</span>\r\n");
#nullable restore
#line 51 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
                    }

#line default
#line hidden
#nullable disable
            WriteLiteral("                </h4>\r\n                <div class=\"p-rating\">\r\n                    Favorite: <span style=\"color:#ff0066\">");
#nullable restore
#line 54 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
                                                     Write(ViewData["countFav"]);

#line default
#line hidden
#nullable disable
            WriteLiteral("</span>\r\n                </div>\r\n                <div class=\"p-rating\">\r\n                    Category: <span style=\"color:#0066ff; font-weight: bold\">");
#nullable restore
#line 57 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
                                                                        Write(ViewData["accCatName"]);

#line default
#line hidden
#nullable disable
            WriteLiteral("</span>\r\n                </div>\r\n                <div class=\"p-rating\">\r\n                    Brand: <span style=\"color:#0066ff; font-weight: bold\">");
#nullable restore
#line 60 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
                                                                     Write(Model.Brand);

#line default
#line hidden
#nullable disable
            WriteLiteral("</span>\r\n                </div>\r\n                <div class=\"quantity\">\r\n                    <p>Quantity</p>\r\n");
#nullable restore
#line 64 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
                     if (Model.IsDelete == true || Model.AvailableQuantity == 0)
                    {

#line default
#line hidden
#nullable disable
            WriteLiteral("                        <input type=\"number\" id=\"inputQuantity\" name=\"quantity\" value=\"0\" class=\"form-control quantity-acc\" disabled>\r\n");
#nullable restore
#line 67 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
                    }
                    else
                    {

#line default
#line hidden
#nullable disable
            WriteLiteral("                        <input type=\"number\" id=\"inputQuantity\" name=\"quantity\" min=\"1\"");
            BeginWriteAttribute("max", " max=\"", 2896, "\"", 2926, 1);
#nullable restore
#line 70 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
WriteAttributeValue("", 2902, Model.AvailableQuantity, 2902, 24, false);

#line default
#line hidden
#nullable disable
            EndWriteAttribute();
            WriteLiteral(" class=\"form-control quantity-acc\" value=\"1\">\r\n");
#nullable restore
#line 71 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
                    }

#line default
#line hidden
#nullable disable
            WriteLiteral("                </div>\r\n");
#nullable restore
#line 73 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
                 if (Model.IsDelete == false && Model.AvailableQuantity != 0)
                {

#line default
#line hidden
#nullable disable
            WriteLiteral("                    <div class=\"p-rating\">\r\n                        Available Quantity: <span style=\"color:#0066ff\">");
#nullable restore
#line 76 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
                                                                   Write(Model.AvailableQuantity);

#line default
#line hidden
#nullable disable
            WriteLiteral("</span>\r\n                    </div>\r\n");
#nullable restore
#line 78 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
                }

#line default
#line hidden
#nullable disable
            WriteLiteral("                <button");
            BeginWriteAttribute("onclick", " onclick=\"", 3338, "\"", 3413, 6);
            WriteAttributeValue("", 3348, "addCart(\'", 3348, 9, true);
#nullable restore
#line 79 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
WriteAttributeValue("", 3357, ViewData["accIdSearch"], 3357, 24, false);

#line default
#line hidden
#nullable disable
            WriteAttributeValue("", 3381, "\',", 3381, 2, true);
            WriteAttributeValue(" ", 3383, "\'", 3384, 2, true);
#nullable restore
#line 79 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
WriteAttributeValue("", 3385, Model.AvailableQuantity, 3385, 26, false);

#line default
#line hidden
#nullable disable
            WriteAttributeValue("", 3411, "\')", 3411, 2, true);
            EndWriteAttribute();
            WriteLiteral(@" class=""site-btn"">SHOP NOW</button>
                <div id=""accordion"" class=""accordion-area"">
                    <div class=""panel"">
                        <div class=""panel-header"" id=""headingOne"">
                            <button class=""panel-link active"" data-toggle=""collapse"" data-target=""#collapse1"" aria-expanded=""true"" aria-controls=""collapse1"">information</button>
                        </div>
                        <div id=""collapse1"" class=""collapse show"" aria-labelledby=""headingOne"" data-parent=""#accordion"">
                            <div class=""panel-body"">
                                <p>");
#nullable restore
#line 87 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
                              Write(Model.Description);

#line default
#line hidden
#nullable disable
            WriteLiteral(@"</p>
                            </div>
                        </div>
                    </div>
                    <div class=""panel"">
                        <div class=""panel-header"" id=""headingTwo"">
                            <button class=""panel-link"" data-toggle=""collapse"" data-target=""#collapse2"" aria-expanded=""false"" aria-controls=""collapse2"">care details </button>
                        </div>
                        <div id=""collapse2"" class=""collapse"" aria-labelledby=""headingTwo"" data-parent=""#accordion"">
                            <div class=""panel-body"">
                                <p>Always answer any questions from customer</p>
                            </div>
                        </div>
                    </div>
                    <div class=""panel"">
                        <div class=""panel-header"" id=""headingThree"">
                            <button class=""panel-link"" data-toggle=""collapse"" data-target=""#collapse3"" aria-expanded=""false"" aria-controls=""collap");
            WriteLiteral(@"se3"">shipping & Returns</button>
                        </div>
                        <div id=""collapse3"" class=""collapse"" aria-labelledby=""headingThree"" data-parent=""#accordion"">
                            <div class=""panel-body"">
                                <h4>7 Days Returns</h4>
                                <p>Freeship in HCM City<br>Home Delivery <span>3 - 4 days</span></p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class=""social-sharing"">
                    <a href=""https://www.google.com/""><i class=""fa fa-google-plus""></i></a>
                    <a href=""https://www.pinterest.com/""><i class=""fa fa-pinterest""></i></a>
                    <a href=""https://www.facebook.com/""><i class=""fa fa-facebook""></i></a>
                    <a href=""https://www.twitter.com/""><i class=""fa fa-twitter""></i></a>
                    <a href=""https://www.youtube.com/""><i class=""fa fa-youtube""></i></a>
 ");
            WriteLiteral(@"               </div>
            </div>
        </div>
    </div>
</section>
<!-- product section end -->
<!-- RELATED PRODUCTS section -->
<section class=""related-product-section"">
    <div class=""container"">
        <div class=""section-title"">
            <h2>RELATED PRODUCTS</h2>
        </div>
        <div id=""related-acc"" class=""row"">

        </div>
    </div>
</section>
<!-- RELATED PRODUCTS section end -->
");
            DefineSection("Scripts", async() => {
                WriteLiteral("\r\n    ");
                __tagHelperExecutionContext = __tagHelperScopeManager.Begin("script", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "61b1d7bb630c76ddbee79528bde91a413b6ef2d120440", async() => {
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
                WriteLiteral("\r\n    <script>\r\n        $(function () {\r\n            getRelatedAccessory(\'");
#nullable restore
#line 141 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
                            Write(Model.AccCatId);

#line default
#line hidden
#nullable disable
                WriteLiteral("\', \'");
#nullable restore
#line 141 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\Accessory\FindAccById.cshtml"
                                               Write(Model.AccId);

#line default
#line hidden
#nullable disable
                WriteLiteral("\');\r\n        });\r\n    </script>\r\n");
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
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<PetShop.DTO.Accessory> Html { get; private set; }
    }
}
#pragma warning restore 1591
