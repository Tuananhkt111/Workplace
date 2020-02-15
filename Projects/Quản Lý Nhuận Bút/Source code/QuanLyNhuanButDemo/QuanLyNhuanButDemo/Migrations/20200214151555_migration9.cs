using Microsoft.EntityFrameworkCore.Migrations;

namespace QuanLyNhuanButDemo.Migrations
{
    public partial class migration9 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<string>(
                name: "UnitCategoryId",
                table: "Categories",
                nullable: true);

            migrationBuilder.CreateTable(
                name: "UnitCategories",
                columns: table => new
                {
                    UnitCategoryId = table.Column<string>(nullable: false),
                    UnitCategoryName = table.Column<string>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_UnitCategories", x => x.UnitCategoryId);
                });

            migrationBuilder.CreateIndex(
                name: "IX_Categories_UnitCategoryId",
                table: "Categories",
                column: "UnitCategoryId");

            migrationBuilder.AddForeignKey(
                name: "FK_Categories_UnitCategories_UnitCategoryId",
                table: "Categories",
                column: "UnitCategoryId",
                principalTable: "UnitCategories",
                principalColumn: "UnitCategoryId",
                onDelete: ReferentialAction.Restrict);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Categories_UnitCategories_UnitCategoryId",
                table: "Categories");

            migrationBuilder.DropTable(
                name: "UnitCategories");

            migrationBuilder.DropIndex(
                name: "IX_Categories_UnitCategoryId",
                table: "Categories");

            migrationBuilder.DropColumn(
                name: "UnitCategoryId",
                table: "Categories");
        }
    }
}
