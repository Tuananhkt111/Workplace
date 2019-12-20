using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ASM_1
{
    class Program
    {
        static void Main(string[] args)
        {
            SinhVien[] danhSach = new SinhVien[50];
            int count = 0;
            while (true)
            {
                string input;
                int numberInput;
                Console.WriteLine("***QUAN LY SINH VIEN***");
                Console.WriteLine("1. Xem danh sach sinh vien");
                Console.WriteLine("2. Them sinh vien");
                Console.WriteLine("3. Tim sinh vien");
                Console.WriteLine("4. Cap nhat thong tin sinh vien");
                Console.WriteLine("5. Thoat");
                do
                {
                    Console.Write("Nhap lua chon (1-5): ");
                    input = Console.ReadLine();
                    if (int.TryParse(input, out numberInput))
                    {
                        switch (numberInput)
                        {
                            case 1:
                                Console.WriteLine("***Xem danh sach sinh vien***");
                                if (count == 0)
                                {
                                    Console.WriteLine("Khong co sinh vien nao trong danh sach");
                                }
                                else
                                {
                                    Console.WriteLine("Ma Sv           Ho Ten               Ngay Sinh       Dia Chi                        Dien Thoai");
                                    foreach (var sinhVien in danhSach)
                                    {
                                        sinhVien?.XemThongTin();
                                    }
                                }
                                Console.WriteLine();
                                break;
                            case 2:
                                Console.WriteLine("***Them sinh vien***");
                                bool isDuplicated, hasDate;
                                string mMaSV, hoTen, diaChi, dienThoai;
                                DateTime ngaySinh;
                                do
                                {
                                    isDuplicated = false;
                                    Console.Write("Nhap ma SV: ");
                                    mMaSV = Console.ReadLine();
                                    foreach (var sinhVien in danhSach)
                                    {
                                        if (sinhVien?.MaSV.Equals(mMaSV) ?? false)
                                        {
                                            isDuplicated = true;
                                            Console.WriteLine("Ma SV bi trung lap. Vui long nhap ma khac.");
                                            break;
                                        }
                                    }
                                } while (isDuplicated);
                                Console.Write("Nhap ho ten: ");
                                hoTen = Console.ReadLine();
                                do
                                {
                                    hasDate = false;
                                    Console.Write("Nhap ngay sinh (dd/mm/yyyy): ");
                                    string inputDate = Console.ReadLine();
                                    if (DateTime.TryParse(inputDate, out ngaySinh))
                                    {
                                        hasDate = true;
                                    }
                                    else
                                    {
                                        Console.WriteLine("Vui long nhap ngay dung format");
                                    }
                                } while (!hasDate);
                                Console.Write("Nhap dia chi: ");
                                diaChi = Console.ReadLine();
                                Console.Write("Nhap dien thoai: ");
                                dienThoai = Console.ReadLine();
                                danhSach[count] = new SinhVien(mMaSV, hoTen, diaChi, dienThoai, ngaySinh);
                                count++;
                                Console.WriteLine("Ban da them sinh vien thanh cong!\n");
                                break;
                            case 3:
                                Console.WriteLine("***Tim sinh vien***");
                                Console.Write("Nhap ma SV can tim: ");
                                input = Console.ReadLine();
                                bool isFound = false;
                                foreach (var sinhVien in danhSach)
                                {
                                    if (sinhVien?.MaSV.Equals(input) ?? false)
                                    {
                                        Console.WriteLine("Ma Sv           Ho Ten               Ngay Sinh       Dia Chi                        Dien Thoai");
                                        sinhVien?.XemThongTin();
                                        Console.WriteLine();
                                        isFound = true;
                                        break;
                                    }
                                }
                                if (!isFound)
                                    Console.WriteLine($"Khong tim thay sinh vien co ma {input}\n");
                                break;
                            case 4:
                                Console.WriteLine("***Cap nhat thong tin sinh vien***");
                                Console.Write("Nhap ma SV ban muon cap nhat: ");
                                string maSV = Console.ReadLine();
                                bool isFound2 = false;
                                for (int i = 0; i < danhSach.Length; i++)
                                {
                                    if (danhSach[i]?.MaSV.Equals(maSV) ?? false)
                                    {
                                        Console.Write("Nhap ho ten: ");
                                        hoTen = Console.ReadLine();
                                        do
                                        {
                                            hasDate = false;
                                            Console.Write("Nhap ngay sinh (dd/mm/yyyy): ");
                                            string inputDate = Console.ReadLine();
                                            if (DateTime.TryParse(inputDate, out ngaySinh))
                                            {
                                                hasDate = true;
                                            }
                                            else
                                            {
                                                Console.WriteLine("Vui long nhap ngay dung format");
                                            }
                                        } while (!hasDate);
                                        Console.Write("Nhap dia chi: ");
                                        diaChi = Console.ReadLine();
                                        Console.Write("Nhap dien thoai: ");
                                        dienThoai = Console.ReadLine();
                                        danhSach[i] = new SinhVien(maSV, hoTen, diaChi, dienThoai, ngaySinh);
                                        Console.WriteLine("Ban da cap nhat sinh vien thanh cong!\n");
                                        isFound2 = true;
                                        break;
                                    }
                                }
                                if (!isFound2)
                                    Console.WriteLine($"Khong tim thay sinh vien co ma {maSV}\n");
                                break;
                            case 5:
                                Console.WriteLine("***Cam on da su dung app cua toi***");
                                return;
                            default:
                                Console.WriteLine($"{numberInput} khong trong khoang tu 1 den 5.");
                                break;
                        }
                    }
                    else
                    {
                        Console.WriteLine($"{input} khong phai la so.");
                    }
                } while (numberInput < 1 || numberInput > 5);
            }
        }
    }
}
