package my_when2meet.my_when2meet_spring.domain;

import java.sql.Array;
import java.util.List;

public class Schedule {

    private Long id;
    private String title;
    private List<Long> group;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public List<Long> getGroup(){
        return group;
    }
    public void addGroup(Long userid){
        group.add(userid);
    }

    public void setGroup(Array group){
        this.group = (List<Long>) group;
    }

}
