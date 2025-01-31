package my_when2meet.my_when2meet_spring.domain;

public class Member {

    private Long userid;

    private String id;
    private String password;
    private String name;

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
}
