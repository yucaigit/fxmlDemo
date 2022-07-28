package com.lyzd.javafx.datasource;

public class PeopleEntity {
    private Integer id;
    private String name;
    private Integer age;
    private Integer sex;
    private String job;
    public PeopleEntity() {
    }

    public PeopleEntity(Integer id, String name, Integer age, Integer sex, String job) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.job = job;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "PeopleEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", job='" + job + '\'' +
                '}';
    }
}
