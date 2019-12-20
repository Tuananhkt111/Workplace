using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace PetShop.Models
{
    public partial class PetShopContext : DbContext
    {
        public PetShopContext()
        {
        }

        public PetShopContext(DbContextOptions<PetShopContext> options)
            : base(options)
        {
        }

        public virtual DbSet<Accessory> Accessory { get; set; }
        public virtual DbSet<AccessoryCategory> AccessoryCategory { get; set; }
        public virtual DbSet<AccessoryTransaction> AccessoryTransaction { get; set; }
        public virtual DbSet<AccessoryTransactionRel> AccessoryTransactionRel { get; set; }
        public virtual DbSet<Favorite> Favorite { get; set; }
        public virtual DbSet<PetCategory> PetCategory { get; set; }
        public virtual DbSet<Principal> Principal { get; set; }
        public virtual DbSet<ShoppingCart> ShoppingCart { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Accessory>(entity =>
            {
                entity.HasKey(e => e.AccId);

                entity.Property(e => e.AccId)
                    .HasColumnName("AccID")
                    .HasMaxLength(15);

                entity.Property(e => e.AccCatId)
                    .IsRequired()
                    .HasColumnName("AccCatID")
                    .HasMaxLength(15);

                entity.Property(e => e.AccName)
                    .IsRequired()
                    .HasMaxLength(50);

                entity.Property(e => e.Brand)
                    .IsRequired()
                    .HasMaxLength(50);

                entity.Property(e => e.Description)
                    .IsRequired()
                    .HasMaxLength(500);

                entity.Property(e => e.Image).HasMaxLength(500);

                entity.Property(e => e.IsDelete).HasColumnName("isDelete");

                entity.Property(e => e.StartSellingDate).HasColumnType("date");

                entity.HasOne(d => d.AccCat)
                    .WithMany(p => p.Accessory)
                    .HasForeignKey(d => d.AccCatId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_Accessory_AccessoryCategory");
            });

            modelBuilder.Entity<AccessoryCategory>(entity =>
            {
                entity.HasKey(e => e.AccCatId);

                entity.Property(e => e.AccCatId)
                    .HasColumnName("AccCatID")
                    .HasMaxLength(15);

                entity.Property(e => e.AccCatName)
                    .IsRequired()
                    .HasMaxLength(50);

                entity.Property(e => e.PetCatId)
                    .IsRequired()
                    .HasColumnName("PetCatID")
                    .HasMaxLength(15);

                entity.HasOne(d => d.PetCat)
                    .WithMany(p => p.AccessoryCategory)
                    .HasForeignKey(d => d.PetCatId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_AccessoryCategory_PetCategory");
            });

            modelBuilder.Entity<AccessoryTransaction>(entity =>
            {
                entity.HasKey(e => e.AccTranId);

                entity.Property(e => e.AccTranId)
                    .HasColumnName("AccTranID")
                    .HasMaxLength(15);

                entity.Property(e => e.DeliveryAddress)
                    .IsRequired()
                    .HasMaxLength(500);

                entity.Property(e => e.DeliveryPhone)
                    .IsRequired()
                    .HasMaxLength(50);

                entity.Property(e => e.Status)
                    .IsRequired()
                    .HasMaxLength(50);

                entity.Property(e => e.TimeFinish).HasColumnType("datetime");

                entity.Property(e => e.TimeOrder).HasColumnType("datetime");

                entity.Property(e => e.Username)
                    .IsRequired()
                    .HasMaxLength(50);

                entity.HasOne(d => d.UsernameNavigation)
                    .WithMany(p => p.AccessoryTransaction)
                    .HasForeignKey(d => d.Username)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_AccessoryTransaction_Principal");
            });

            modelBuilder.Entity<AccessoryTransactionRel>(entity =>
            {
                entity.HasKey(e => new { e.AccId, e.AccTranId });

                entity.Property(e => e.AccId)
                    .HasColumnName("AccID")
                    .HasMaxLength(15);

                entity.Property(e => e.AccTranId)
                    .HasColumnName("AccTranID")
                    .HasMaxLength(15);

                entity.Property(e => e.AccCatId)
                    .IsRequired()
                    .HasColumnName("AccCatID")
                    .HasMaxLength(15);

                entity.Property(e => e.AccName)
                    .IsRequired()
                    .HasMaxLength(50);

                entity.Property(e => e.Brand)
                    .IsRequired()
                    .HasMaxLength(50);

                entity.Property(e => e.Description)
                    .IsRequired()
                    .HasMaxLength(500);

                entity.Property(e => e.Image)
                    .IsRequired()
                    .HasMaxLength(500);

                entity.Property(e => e.StartSellingDate).HasColumnType("date");

                entity.HasOne(d => d.Acc)
                    .WithMany(p => p.AccessoryTransactionRel)
                    .HasForeignKey(d => d.AccId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_TransAccRelation_Accessory");

                entity.HasOne(d => d.AccTran)
                    .WithMany(p => p.AccessoryTransactionRel)
                    .HasForeignKey(d => d.AccTranId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_TransAccRelation_AccessoryTransaction");
            });

            modelBuilder.Entity<Favorite>(entity =>
            {
                entity.HasKey(e => new { e.Username, e.AccId });

                entity.Property(e => e.Username).HasMaxLength(50);

                entity.Property(e => e.AccId)
                    .HasColumnName("AccID")
                    .HasMaxLength(15);

                entity.HasOne(d => d.Acc)
                    .WithMany(p => p.Favorite)
                    .HasForeignKey(d => d.AccId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_Favorite_Accessory");

                entity.HasOne(d => d.UsernameNavigation)
                    .WithMany(p => p.Favorite)
                    .HasForeignKey(d => d.Username)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_Favorite_Principal");
            });

            modelBuilder.Entity<PetCategory>(entity =>
            {
                entity.HasKey(e => e.PetCatId);

                entity.Property(e => e.PetCatId)
                    .HasColumnName("PetCatID")
                    .HasMaxLength(15);

                entity.Property(e => e.PetType)
                    .IsRequired()
                    .HasMaxLength(50);
            });

            modelBuilder.Entity<Principal>(entity =>
            {
                entity.HasKey(e => e.Username);

                entity.Property(e => e.Username).HasMaxLength(50);

                entity.Property(e => e.Address)
                    .IsRequired()
                    .HasMaxLength(500);

                entity.Property(e => e.Fullname)
                    .IsRequired()
                    .HasMaxLength(50);

                entity.Property(e => e.Password)
                    .IsRequired()
                    .HasMaxLength(50);

                entity.Property(e => e.Phone)
                    .IsRequired()
                    .HasMaxLength(50);

                entity.Property(e => e.Role)
                    .IsRequired()
                    .HasMaxLength(50);
            });

            modelBuilder.Entity<ShoppingCart>(entity =>
            {
                entity.HasKey(e => new { e.Username, e.AccId });

                entity.Property(e => e.Username).HasMaxLength(50);

                entity.Property(e => e.AccId)
                    .HasColumnName("AccID")
                    .HasMaxLength(15);

                entity.HasOne(d => d.Acc)
                    .WithMany(p => p.ShoppingCart)
                    .HasForeignKey(d => d.AccId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_ShoppingCart_Accessory");

                entity.HasOne(d => d.UsernameNavigation)
                    .WithMany(p => p.ShoppingCart)
                    .HasForeignKey(d => d.Username)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_ShoppingCart_Principal");
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
