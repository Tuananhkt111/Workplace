package arraylistdemo;
public class Student implements Comparable<Student>
{
    private String name;
    private int age;
    private NewEnum sex;
    Student(String name, int age, NewEnum sex)
    {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public NewEnum getSex()
    {
        return sex;
    }

    public void setSex(NewEnum sex)
    {
        this.sex = sex;
    }
    
    @Override
    public String toString()
    {
        return  name + ", age: " + age + " sex: " + sex;
    }

    @Override
    public int compareTo(Student t)
    {
        if(age > t.age)
            return 1;
        else if(age == t.age)
            return 0;
        else
            return -1;
    }
}
