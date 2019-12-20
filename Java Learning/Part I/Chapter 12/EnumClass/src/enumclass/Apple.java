package enumclass;
enum Apple
{
    Jonathan(10), GoldeDel(9), RedDel(12), Winesap(15), Cortland(8);
    private int price; //price of each apple
    //Constructor
    Apple(int p)
    {
        price = p;
    }
    int getprice()
    {
        return price;
    }
}