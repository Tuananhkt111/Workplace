using System;
using Microsoft.EntityFrameworkCore.Migrations;

namespace QuanLyNhuanButDemo.Migrations
{
    public partial class migration1 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Categories",
                columns: table => new
                {
                    CategoryId = table.Column<string>(nullable: false),
                    CategoryName = table.Column<string>(nullable: true),
                    MinMark = table.Column<int>(nullable: false),
                    MaxMark = table.Column<int>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Categories", x => x.CategoryId);
                });

            migrationBuilder.CreateTable(
                name: "Articles",
                columns: table => new
                {
                    ArticleId = table.Column<string>(nullable: false),
                    Content = table.Column<string>(nullable: true),
                    CategoryId = table.Column<string>(nullable: true),
                    EditorMark = table.Column<int>(nullable: false),
                    ManagerMark = table.Column<int>(nullable: false),
                    Status = table.Column<int>(nullable: false),
                    Executor = table.Column<string>(nullable: true),
                    TimeBroadcast = table.Column<DateTime>(nullable: false),
                    Marker = table.Column<string>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Articles", x => x.ArticleId);
                    table.ForeignKey(
                        name: "FK_Articles_Categories_CategoryId",
                        column: x => x.CategoryId,
                        principalTable: "Categories",
                        principalColumn: "CategoryId",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateIndex(
                name: "IX_Articles_CategoryId",
                table: "Articles",
                column: "CategoryId");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Articles");

            migrationBuilder.DropTable(
                name: "Categories");
        }
    }
}
