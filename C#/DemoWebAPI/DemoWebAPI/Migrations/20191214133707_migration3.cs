using Microsoft.EntityFrameworkCore.Migrations;

namespace DemoWebAPI.Migrations
{
    public partial class migration3 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_ActivityLog_AspNetUsers_DemoWebAPIUserId",
                table: "ActivityLog");

            migrationBuilder.AlterColumn<string>(
                name: "ShortDes",
                table: "ActivityLog",
                nullable: false,
                oldClrType: typeof(string),
                oldType: "nvarchar(max)",
                oldNullable: true);

            migrationBuilder.AlterColumn<string>(
                name: "DemoWebAPIUserId",
                table: "ActivityLog",
                nullable: false,
                oldClrType: typeof(string),
                oldType: "nvarchar(450)",
                oldNullable: true);

            migrationBuilder.AlterColumn<string>(
                name: "ActType",
                table: "ActivityLog",
                nullable: false,
                oldClrType: typeof(string),
                oldType: "nvarchar(max)",
                oldNullable: true);

            migrationBuilder.AddForeignKey(
                name: "FK_ActivityLog_AspNetUsers_DemoWebAPIUserId",
                table: "ActivityLog",
                column: "DemoWebAPIUserId",
                principalTable: "AspNetUsers",
                principalColumn: "Id",
                onDelete: ReferentialAction.Cascade);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_ActivityLog_AspNetUsers_DemoWebAPIUserId",
                table: "ActivityLog");

            migrationBuilder.AlterColumn<string>(
                name: "ShortDes",
                table: "ActivityLog",
                type: "nvarchar(max)",
                nullable: true,
                oldClrType: typeof(string));

            migrationBuilder.AlterColumn<string>(
                name: "DemoWebAPIUserId",
                table: "ActivityLog",
                type: "nvarchar(450)",
                nullable: true,
                oldClrType: typeof(string));

            migrationBuilder.AlterColumn<string>(
                name: "ActType",
                table: "ActivityLog",
                type: "nvarchar(max)",
                nullable: true,
                oldClrType: typeof(string));

            migrationBuilder.AddForeignKey(
                name: "FK_ActivityLog_AspNetUsers_DemoWebAPIUserId",
                table: "ActivityLog",
                column: "DemoWebAPIUserId",
                principalTable: "AspNetUsers",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);
        }
    }
}
