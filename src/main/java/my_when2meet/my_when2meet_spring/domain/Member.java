package my_when2meet.my_when2meet_spring.domain;

public class Member {

    private Long id;
    private Long password;
    private String name;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getPassword(){
        return password;
    }

    public void setPassword(Long password){
        this.password = password;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
