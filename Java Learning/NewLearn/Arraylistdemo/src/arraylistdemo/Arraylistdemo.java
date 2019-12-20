package arraylistdemo;
import java.io.*;
import java.util.*;
public class Arraylistdemo 
{
    public static void main(String[] args)
    {
        try
        {
            FileOutputStream fin = new FileOutputStream("a1.dat");
        } catch (FileNotFoundException ex)
        {
        }
        Scanner rc = new Scanner(System.in);
        boolean keeptrying = true;
        String n;
        int a;
        String s, c;
        NewEnum en;
        //Create an array list
        ArrayList<Student> a1 = new ArrayList<>();
        do
        {
            System.out.println("Nhap ho ten:");
            n = rc.nextLine();
            System.out.println("Nhap tuoi:");
            a = rc.nextInt();
            System.out.println("Nhap gioi tinh:");
            s = rc.next();
            en = NewEnum.valueOf(s);
            a1.add(new Student(n, a, en));
            System.out.println("Ban co muon nhap nua khong:");
            if(rc.next().compareTo("N") == 0)
                keeptrying = false;
            c=rc.nextLine();
             } while(keeptrying);
        System.out.println("Initial size of a1: " + a1.size());
        //Add elements to the array list
        a1.add(new Student("Hoang Tuan Anh", 18, NewEnum.MALE));
        a1.add(new Student("Le Nguyen Viet Hung", 19, NewEnum.MALE));
        a1.add(new Student("Cu Ba", 18, NewEnum.FEMALE));
        a1.add(new Student("Nguyen Quang Huy", 20, NewEnum.MALE));
        a1.add(new Student("Hoang Tuan Anh", 21, NewEnum.MALE));
        a1.add(new Student("Hoang Tuan Anh", 18, NewEnum.MALE));
        a1.add(new Student("Hoang Tuan Anh", 18, NewEnum.MALE));
        System.out.println("Size of a1 after additions: " + a1.size());
        //Display the array list
        Collections.sort(a1);
        System.out.println("Contents of a1: ");
        ListIterator<Student> itr = a1.listIterator();
        while(itr.hasNext())
        {
            System.out.print(itr.next() +" ");
        }
    }    
}
