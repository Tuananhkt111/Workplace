package ex2;
public class Student implements Comparable<Student>
{
    private String name;
    private String address;
    private String phonenumber;
    private String id;
    private String birth;
    private int mark;
    private SexEnum sex;
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public String getPhonenumber()
    {
        return phonenumber;
    }
    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public String getBirth()
    {
        return birth;
    }
    public void setBirth(String birth)
    {
        this.birth = birth;
    }
    public int getMark()
    {
        return mark;
    }
    public void setMark(int mark)
    {
        this.mark = mark;
    }
    public SexEnum getSex()
    {
        return sex;
    }
    public void setSex(SexEnum sex)
    {
        this.sex = sex;
    }  
    @Override
    public String toString()
    {
        return id + ", " + name + ", " + sex + ", " + birth + ", " + address + ", " + phonenumber + ", " + mark + "\n";
    }
    @Override
    public int compareTo(Student t)
    {
        if(mark > t.mark)
            return 1;
        else if(mark == t.mark)
            return 0;
        else
            return -1;
    }
}