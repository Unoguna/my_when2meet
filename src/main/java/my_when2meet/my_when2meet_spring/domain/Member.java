package my_when2meet.my_when2meet_spring.domain;

import java.util.ArrayList;

public class Member {

    private Long userid;

    private String id;
    private String password;
    private String name;

    private ArrayList<Long> scheduleIdx = new ArrayList<>();

    public Long getUserid(){
        return userid;
    }

    public void setUserid(Long userid){
        this.userid = userid;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void addSchedule(Long idx){
        scheduleIdx.add(idx);
    }

    public ArrayList<Long> getScheduleIdx(){
        return scheduleIdx;
    }
}
