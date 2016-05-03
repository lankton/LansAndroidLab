package cn.lankton.dagger2.cn.lankton.dagger2.models;

/**
 * Created by taofangxin on 16/4/27.
 */
public class Student {
    String name;
    int number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Student(int number, String name) {
        this.number = number;
        this.name = name;

    }
}
