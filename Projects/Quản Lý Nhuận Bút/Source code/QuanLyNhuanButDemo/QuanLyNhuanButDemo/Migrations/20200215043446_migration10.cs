using Microsoft.EntityFrameworkCore.Migrations;

namespace QuanLyNhuanButDemo.Migrations
{
    public partial class migration10 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
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

            migrationBuilder.AddColumn<int>(
                name: "UnitType",
                table: "Categories",
                nullable: false,
                defaultValue: 0);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "UnitType",
                table: "Categories");

            migrationBuilder.AddColumn<string>(
                name: "UnitCategoryId",
                table: "Categories",
                type: "nvarchar(450)",
                nullable: true);

            migrationBuilder.CreateTable(
                name: "UnitCategories",
                columns: table => new
                {
                    UnitCategoryId = table.Column<string>(type: "nvarchar(450)", nullable: false),
                    UnitCategoryName = table.Column<string>(type: "nvarchar(max)", nullable: true)
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
    }
}
