#pragma checksum "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\About\Index.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "1dddf55587ecd196a3b716fb2b0efea15495a489"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_About_Index), @"mvc.1.0.view", @"/Views/About/Index.cshtml")]
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
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"1dddf55587ecd196a3b716fb2b0efea15495a489", @"/Views/About/Index.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"d9cb11fa8dfc4463cdadb982486cbc1eda18e7a4", @"/Views/_ViewImports.cshtml")]
    public class Views_About_Index : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<dynamic>
    {
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_0 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("asp-controller", "Home", global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_1 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("asp-action", "Index", global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
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
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
            WriteLiteral("\r\n");
#nullable restore
#line 2 "D:\Google Drive\C#\Backup\PetShop\PetShop\Views\About\Index.cshtml"
  
    ViewData["Title"] = "About";

#line default
#line hidden
#nullable disable
            WriteLiteral("<!-- Page info -->\r\n<div class=\"page-top-info\">\r\n    <div class=\"container\">\r\n        <h4>About</h4>\r\n        <div class=\"site-pagination\">\r\n            ");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("a", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "1dddf55587ecd196a3b716fb2b0efea15495a4894012", async() => {
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
            WriteLiteral(@" /
            <a href=""#"">About</a>
        </div>
    </div>
</div>
<div class=""d-flex flex-row"" style=""margin-top: 20px;margin-bottom: 10px;"">
    <div class=""col-4 text-center"">
        <div>
            <img src=""../img/about/shipping.png"" width=""30%""");
            BeginWriteAttribute("alt", " alt=\"", 512, "\"", 518, 0);
            EndWriteAttribute();
            WriteLiteral(@">
            <div>
                <h3 class=""heading"">Free Shipping</h3>
                <p>No fee for shipping products to all addresses in HCM City. Shipping outside the city will be handled by 3rd company.</p>
            </div>
        </div>
    </div>
    <div class=""col-4 text-center"">
        <div>
            <img src=""../img/about/support.png"" width=""30%""");
            BeginWriteAttribute("alt", " alt=\"", 897, "\"", 903, 0);
            EndWriteAttribute();
            WriteLiteral(@">
            <div>
                <h3 class=""heading"">Support Customer</h3>
                <p>Our customer supporters always work 24/24. Your questions will be answered in 30 minutes.</p>
            </div>
        </div>
    </div>
    <div class=""col-4 text-center"">
        <div>
            <img src=""../img/about/payment.png"" width=""30%""");
            BeginWriteAttribute("alt", " alt=\"", 1258, "\"", 1264, 0);
            EndWriteAttribute();
            WriteLiteral(@">
            <div>
                <h3 class=""heading"">Simple Payments</h3>
                <p>Cash-on-delivery transactions is the simplest payment method. No need for bank accounts or ewallets.</p>
            </div>
        </div>
    </div>
</div>
<hr style=""margin: 30px 0;"">
<div class=""d-flex align-items-center justify-content-center flex-column"">
    <div class=""text-center"" style=""color: #000; font-size: 30px; font-weight: bold; margin-bottom: 20px;"">Our <span style=""color: #81e992; font-size: 40px; font-weight: bold; font-style: italic;"">Gallery</span></div>
    <div class=""d-flex flex-row align-items-center justify-content-center flex-lg-wrap"">
        <div class=""col-4 text-center"" style=""margin-bottom: 30px;""><img class=""img-thumbnail"" src=""../img/about/g6.jpg""");
            BeginWriteAttribute("alt", " alt=\"", 2061, "\"", 2067, 0);
            EndWriteAttribute();
            WriteLiteral("></div>\r\n        <div class=\"col-4 text-center\" style=\"margin-bottom: 30px;\"><img class=\"img-thumbnail\" src=\"../img/about/g1.jpg\"");
            BeginWriteAttribute("alt", " alt=\"", 2197, "\"", 2203, 0);
            EndWriteAttribute();
            WriteLiteral("></div>\r\n        <div class=\"col-4 text-center\" style=\"margin-bottom: 30px;\"><img class=\"img-thumbnail\" src=\"../img/about/g2.jpg\"");
            BeginWriteAttribute("alt", " alt=\"", 2333, "\"", 2339, 0);
            EndWriteAttribute();
            WriteLiteral("></div>\r\n        <div class=\"col-4 text-center\" style=\"margin-bottom: 30px;\"><img class=\"img-thumbnail\" src=\"../img/about/g3.jpg\"");
            BeginWriteAttribute("alt", " alt=\"", 2469, "\"", 2475, 0);
            EndWriteAttribute();
            WriteLiteral("></div>\r\n        <div class=\"col-4 text-center\" style=\"margin-bottom: 30px;\"><img class=\"img-thumbnail\" src=\"../img/about/g4.jpg\"");
            BeginWriteAttribute("alt", " alt=\"", 2605, "\"", 2611, 0);
            EndWriteAttribute();
            WriteLiteral("></div>\r\n        <div class=\"col-4 text-center\" style=\"margin-bottom: 30px;\"><img class=\"img-thumbnail\" src=\"../img/about/g7.jpg\"");
            BeginWriteAttribute("alt", " alt=\"", 2741, "\"", 2747, 0);
            EndWriteAttribute();
            WriteLiteral("></div>\r\n        <div class=\"col-4 text-center\" style=\"margin-bottom: 30px;\"><img class=\"img-thumbnail\" src=\"../img/about/g8.jpg\"");
            BeginWriteAttribute("alt", " alt=\"", 2877, "\"", 2883, 0);
            EndWriteAttribute();
            WriteLiteral("></div>\r\n        <div class=\"col-4 text-center\" style=\"margin-bottom: 30px;\"><img class=\"img-thumbnail\" src=\"../img/about/g9.jpg\"");
            BeginWriteAttribute("alt", " alt=\"", 3013, "\"", 3019, 0);
            EndWriteAttribute();
            WriteLiteral("></div>\r\n        <div class=\"col-4 text-center\" style=\"margin-bottom: 30px;\"><img class=\"img-thumbnail\" src=\"../img/about/g10.jpg\"");
            BeginWriteAttribute("alt", " alt=\"", 3150, "\"", 3156, 0);
            EndWriteAttribute();
            WriteLiteral("></div>\r\n        <div class=\"col-4 text-center\" style=\"margin-bottom: 30px;\"><img class=\"img-thumbnail\" src=\"../img/about/g11.jpg\"");
            BeginWriteAttribute("alt", " alt=\"", 3287, "\"", 3293, 0);
            EndWriteAttribute();
            WriteLiteral("></div>\r\n        <div class=\"col-4 text-center\" style=\"margin-bottom: 30px;\"><img class=\"img-thumbnail\" src=\"../img/about/g12.jpg\"");
            BeginWriteAttribute("alt", " alt=\"", 3424, "\"", 3430, 0);
            EndWriteAttribute();
            WriteLiteral("></div>\r\n        <div class=\"col-4 text-center\" style=\"margin-bottom: 30px;\"><img class=\"img-thumbnail\" src=\"../img/about/g5.jpg\"");
            BeginWriteAttribute("alt", " alt=\"", 3560, "\"", 3566, 0);
            EndWriteAttribute();
            WriteLiteral("></div>\r\n    </div>\r\n</div>\r\n");
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
