
package data;
public class Dog {
    private String name; //co the la chi huhu, ngao da,...
    private int yob;  //ngay sinh 
    private double weight; // can nang 
    //ta co chi tiet khuon roi, gio la luc nhan vat lieu vao, ta can 1 cai pheu
    public Dog(String name, int yob, double weight) {
        this.name = name;
        this.yob = yob;
        this.weight = weight;
    }
    //day la 1 ham rat dac biet, dung de duc ra obj bang cach dua vao vat lieu nhan vao
    //se di vao cac ngoc ngach cua khoun qua toan tu value gan value
    //ham nay trung ten 100% class, y noi duc obj cung ten
    //ham ko co gia tri tra e
    //ham chi duoc goi khi duc obj, duc tuong, moi lan goi ham la 1 obj moi
    //duoc tao ra -> LUU Y DIEU NAY
    //pheu nay/ham nay duoc goi 1 ten la HAM KHOI TAO< HAM KHOI DUNG, CONSTRUCTOR
    //obj phai co hanh dong, co the duoc xai nhieu lan cho tung ob
    //hham goi nhieu lan tren cung 1 ob, khac pheu, moi lan goi pheu
    //co ho sua nao
    public void bark() {
        System.out.println("Welcome to my home! "
                + "By the way, my name is " + name);
    }
    //name se tuy thuoc ban do vao pheu luc duc obj, ta lam dan khung
    //vi da da info vao Dog roi, ta se co the hoi lai info da do
    //qua hanh dong get()

    public String getName() {
        return name;
    }

    public int getYob() {
        return yob;
    }

    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    //doi khi ta can show() ra thong tin chi tiet cua 1 object
    //viet ham in ra chuoi dai ghep toan bo info da do vao object, muc tieu
    //kiem tra info co dung khong

    @Override //ham co san
    public String toString() {
        return "Dog{" + "name=" + name + ", yob=" + yob + ", weight=" + weight + '}';
        //ghep kieu nay khong can le nhu kieu soai ca
        
    }
    //ham co san nho tool lam giup, thich thi tu viet, thich thi viet ten ham
    //rieng cung dc, khi xai cun nguoi ta, phai xai cho chuan
    public void showDetailed() {
//        System.out.println("Here is my details");
//        System.out.println("Name: " + name);
//        System.out.println("Yob: " + yob);
//        System.out.println("Weight: " + weight);
        System.out.printf("|%-10s|%4d|%2.2f|\n", name, yob, weight);
    } //ki thuat in soai ca
}
