using System;
using Microsoft.EntityFrameworkCore.Migrations;

namespace TranslatorAPI.Migrations
{
    public partial class addMainTable : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "CategoryFile",
                columns: table => new
                {
                    CategoryFileId = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    CategoryName = table.Column<string>(nullable: true),
                    Point = table.Column<double>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_CategoryFile", x => x.CategoryFileId);
                });

            migrationBuilder.CreateTable(
                name: "MethodPaid",
                columns: table => new
                {
                    MethodPaidId = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    BankNumber = table.Column<string>(nullable: true),
                    Point = table.Column<int>(nullable: true),
                    CreatedDate = table.Column<DateTime>(nullable: true),
                    Status = table.Column<string>(nullable: true),
                    Description = table.Column<string>(nullable: true),
                    UserId = table.Column<string>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_MethodPaid", x => x.MethodPaidId);
                    table.ForeignKey(
                        name: "FK_MethodPaid_AspNetUsers_UserId",
                        column: x => x.UserId,
                        principalTable: "AspNetUsers",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "TranslatorDetail",
                columns: table => new
                {
                    TranslatorDetailId = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Description = table.Column<string>(nullable: true),
                    Language = table.Column<string>(nullable: true),
                    UserId = table.Column<string>(nullable: true),
                    StandardLv = table.Column<double>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_TranslatorDetail", x => x.TranslatorDetailId);
                    table.ForeignKey(
                        name: "FK_TranslatorDetail_AspNetUsers_UserId",
                        column: x => x.UserId,
                        principalTable: "AspNetUsers",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "BankTest",
                columns: table => new
                {
                    BankTestId = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    CensorshipId = table.Column<string>(nullable: true),
                    CreatedDate = table.Column<DateTime>(nullable: true),
                    CategoryFileId = table.Column<int>(nullable: true),
                    Description = table.Column<string>(nullable: true),
                    Status = table.Column<string>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_BankTest", x => x.BankTestId);
                    table.ForeignKey(
                        name: "FK_BankTest_CategoryFile_CategoryFileId",
                        column: x => x.CategoryFileId,
                        principalTable: "CategoryFile",
                        principalColumn: "CategoryFileId",
                        onDelete: ReferentialAction.Restrict);
                    table.ForeignKey(
                        name: "FK_BankTest_AspNetUsers_CensorshipId",
                        column: x => x.CensorshipId,
                        principalTable: "AspNetUsers",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "Transaction",
                columns: table => new
                {
                    TransactionId = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    CustomerId = table.Column<string>(nullable: true),
                    TranslatorId = table.Column<string>(nullable: true),
                    Point = table.Column<int>(nullable: true),
                    CreatedDate = table.Column<DateTime>(nullable: true),
                    FinishedDate = table.Column<DateTime>(nullable: true),
                    Description = table.Column<string>(nullable: true),
                    Deadline = table.Column<DateTime>(nullable: true),
                    OriginalFile = table.Column<string>(nullable: true),
                    TranslatedFile = table.Column<string>(nullable: true),
                    Status = table.Column<string>(nullable: true),
                    CategoryFileId = table.Column<int>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Transaction", x => x.TransactionId);
                    table.ForeignKey(
                        name: "FK_Transaction_CategoryFile_CategoryFileId",
                        column: x => x.CategoryFileId,
                        principalTable: "CategoryFile",
                        principalColumn: "CategoryFileId",
                        onDelete: ReferentialAction.Restrict);
                    table.ForeignKey(
                        name: "FK_Transaction_AspNetUsers_CustomerId",
                        column: x => x.CustomerId,
                        principalTable: "AspNetUsers",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                    table.ForeignKey(
                        name: "FK_Transaction_AspNetUsers_TranslatorId",
                        column: x => x.TranslatorId,
                        principalTable: "AspNetUsers",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "TestDetail",
                columns: table => new
                {
                    TestDetailId = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    BankTestId = table.Column<int>(nullable: true),
                    InterperterId = table.Column<string>(nullable: true),
                    CensorshipId = table.Column<string>(nullable: true),
                    TestDate = table.Column<DateTime>(nullable: true),
                    Description = table.Column<string>(nullable: true),
                    Status = table.Column<string>(nullable: true),
                    Mark = table.Column<double>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_TestDetail", x => x.TestDetailId);
                    table.ForeignKey(
                        name: "FK_TestDetail_BankTest_BankTestId",
                        column: x => x.BankTestId,
                        principalTable: "BankTest",
                        principalColumn: "BankTestId",
                        onDelete: ReferentialAction.Restrict);
                    table.ForeignKey(
                        name: "FK_TestDetail_AspNetUsers_CensorshipId",
                        column: x => x.CensorshipId,
                        principalTable: "AspNetUsers",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                    table.ForeignKey(
                        name: "FK_TestDetail_AspNetUsers_InterperterId",
                        column: x => x.InterperterId,
                        principalTable: "AspNetUsers",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "TransactionFeedBack",
                columns: table => new
                {
                    TransactionFeedBackId = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Description = table.Column<string>(nullable: true),
                    Rating = table.Column<double>(nullable: true),
                    CreatedDate = table.Column<DateTime>(nullable: true),
                    TransactionId = table.Column<int>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_TransactionFeedBack", x => x.TransactionFeedBackId);
                    table.ForeignKey(
                        name: "FK_TransactionFeedBack_Transaction_TransactionId",
                        column: x => x.TransactionId,
                        principalTable: "Transaction",
                        principalColumn: "TransactionId",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "TransactionQueue",
                columns: table => new
                {
                    TransactionQueueId = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    UserId = table.Column<string>(nullable: true),
                    Datetime = table.Column<DateTime>(nullable: true),
                    Description = table.Column<string>(nullable: true),
                    TransactionId = table.Column<int>(nullable: true),
                    Status = table.Column<string>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_TransactionQueue", x => x.TransactionQueueId);
                    table.ForeignKey(
                        name: "FK_TransactionQueue_Transaction_TransactionId",
                        column: x => x.TransactionId,
                        principalTable: "Transaction",
                        principalColumn: "TransactionId",
                        onDelete: ReferentialAction.Restrict);
                    table.ForeignKey(
                        name: "FK_TransactionQueue_AspNetUsers_UserId",
                        column: x => x.UserId,
                        principalTable: "AspNetUsers",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateIndex(
                name: "IX_BankTest_CategoryFileId",
                table: "BankTest",
                column: "CategoryFileId");

            migrationBuilder.CreateIndex(
                name: "IX_BankTest_CensorshipId",
                table: "BankTest",
                column: "CensorshipId");

            migrationBuilder.CreateIndex(
                name: "IX_MethodPaid_UserId",
                table: "MethodPaid",
                column: "UserId");

            migrationBuilder.CreateIndex(
                name: "IX_TestDetail_BankTestId",
                table: "TestDetail",
                column: "BankTestId");

            migrationBuilder.CreateIndex(
                name: "IX_TestDetail_CensorshipId",
                table: "TestDetail",
                column: "CensorshipId");

            migrationBuilder.CreateIndex(
                name: "IX_TestDetail_InterperterId",
                table: "TestDetail",
                column: "InterperterId");

            migrationBuilder.CreateIndex(
                name: "IX_Transaction_CategoryFileId",
                table: "Transaction",
                column: "CategoryFileId");

            migrationBuilder.CreateIndex(
                name: "IX_Transaction_CustomerId",
                table: "Transaction",
                column: "CustomerId");

            migrationBuilder.CreateIndex(
                name: "IX_Transaction_TranslatorId",
                table: "Transaction",
                column: "TranslatorId");

            migrationBuilder.CreateIndex(
                name: "IX_TransactionFeedBack_TransactionId",
                table: "TransactionFeedBack",
                column: "TransactionId");

            migrationBuilder.CreateIndex(
                name: "IX_TransactionQueue_TransactionId",
                table: "TransactionQueue",
                column: "TransactionId");

            migrationBuilder.CreateIndex(
                name: "IX_TransactionQueue_UserId",
                table: "TransactionQueue",
                column: "UserId");

            migrationBuilder.CreateIndex(
                name: "IX_TranslatorDetail_UserId",
                table: "TranslatorDetail",
                column: "UserId");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "MethodPaid");

            migrationBuilder.DropTable(
                name: "TestDetail");

            migrationBuilder.DropTable(
                name: "TransactionFeedBack");

            migrationBuilder.DropTable(
                name: "TransactionQueue");

            migrationBuilder.DropTable(
                name: "TranslatorDetail");

            migrationBuilder.DropTable(
                name: "BankTest");

            migrationBuilder.DropTable(
                name: "Transaction");

            migrationBuilder.DropTable(
                name: "CategoryFile");
        }
    }
}
