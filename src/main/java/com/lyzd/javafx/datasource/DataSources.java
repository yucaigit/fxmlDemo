package com.lyzd.javafx.datasource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataSources {
    private static List<PeopleEntity> peoList;
    static {
        peoList = new ArrayList<>();
        peoList.add(new PeopleEntity(1,"Jore",20,1,"教师"));
        peoList.add(new PeopleEntity(2,"Bor",24,0,"学生"));
    }

    //添加操作
    public Boolean add(PeopleEntity per){
        System.out.println("添加员工");
        if (per == null)
            return false;
        else
            peoList.add(per);
            return true;
    }
    public Boolean remove(int id){
        System.out.println("进入删除的方法--------");
        List<PeopleEntity> collect = peoList.stream().filter(x -> x.getId() != id).collect(Collectors.toList());
        peoList = collect;
        return true;
    }
    public List<PeopleEntity> getAll(){
        return peoList;
    }
}
