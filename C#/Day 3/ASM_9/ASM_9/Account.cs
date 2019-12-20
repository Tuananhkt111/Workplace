using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ASM_9
{
    class Account
    {
        private int mCode;
        private string mName;
        private int mBalance;
        public Account()
        {
            mCode = 0;
            mName = null;
            mBalance = 0;
        }

        public Account(int mCode, string mName, int mBalance)
        {
            this.mCode = mCode;
            this.mName = mName;
            this.mBalance = mBalance;
        }
        //Khai bao properties rut tien
        public int GetCash
        {
            set
            {
                //Kiem tra so tien rut voi so du tai khoan
                if (value > mBalance)
                {
                    Console.WriteLine("The value cannot be greater than the current balance.");
                }
                else
                {
                    //Cap nhat so du tai khoan
                    mBalance -= value;
                    Console.WriteLine($"Success to withdraw {value} by cash.");
                }
            }
        }
        //Khai bao property gui tien mat
        public int DepositCash
        {
            set
            {
                //Kiem tra so tien gui khong duoc <= 0
                if (value <= 0)
                {
                    Console.WriteLine("The value cannot  be smaller than 0.");
                }
                else
                {
                    //Cap nhat so du tai khoan
                    mBalance += value;
                    Console.WriteLine($"Success to deposit {value} by cash.");
                }
            }
        }
        //Khai property gui tien qua Sec
        public int DepositCheck
        {
            set
            {
                //Kiem tra so tien gui
                if (value <= 0)
                {
                    Console.WriteLine("The value cannot be smaller than 0.");
                }
                else
                {
                    //Cap nhat so du tai khoan
                    mBalance += value;
                    Console.WriteLine($"Success to deposit {value} by check.");
                }
            }
        }
        //Khai bao property lay so du tai khoan
        public int BalanceStatement
        {
            get { return mBalance; }
        }
        //Khai bao property chuyen tien
        public int Transfer
        {
            set
            {
                if (value <= 0)
                {
                    Console.WriteLine("The value cannot be smaller than 0.");
                }
                else if (value > mBalance)
                {
                    Console.WriteLine("Your account is insufficient.");
                } else
                {
                    mBalance -= value;
                    Console.WriteLine($"Success transfer {value} to receive account.");
                }
            }
        }
    }
}
