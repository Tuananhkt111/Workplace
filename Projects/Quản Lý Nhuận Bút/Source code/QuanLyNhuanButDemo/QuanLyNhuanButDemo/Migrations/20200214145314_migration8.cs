using Microsoft.EntityFrameworkCore.Migrations;

namespace QuanLyNhuanButDemo.Migrations
{
    public partial class migration8 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AlterColumn<float>(
                name: "MinMark",
                table: "Categories",
                nullable: false,
                oldClrType: typeof(int),
                oldType: "int");

            migrationBuilder.AlterColumn<float>(
                name: "MaxMark",
                table: "Categories",
                nullable: false,
                oldClrType: typeof(int),
                oldType: "int");

            migrationBuilder.AlterColumn<float>(
                name: "ManagerMark",
                table: "Articles",
                nullable: true,
                oldClrType: typeof(int),
                oldType: "int",
                oldNullable: true);

            migrationBuilder.AlterColumn<float>(
                name: "EditorMark",
                table: "Articles",
                nullable: false,
                oldClrType: typeof(int),
                oldType: "int");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AlterColumn<int>(
                name: "MinMark",
                table: "Categories",
                type: "int",
                nullable: false,
                oldClrType: typeof(float));

            migrationBuilder.AlterColumn<int>(
                name: "MaxMark",
                table: "Categories",
                type: "int",
                nullable: false,
                oldClrType: typeof(float));

            migrationBuilder.AlterColumn<int>(
                name: "ManagerMark",
                table: "Articles",
                type: "int",
                nullable: true,
                oldClrType: typeof(float),
                oldNullable: true);

            migrationBuilder.AlterColumn<int>(
                name: "EditorMark",
                table: "Articles",
                type: "int",
                nullable: false,
                oldClrType: typeof(float));
        }
    }
}
