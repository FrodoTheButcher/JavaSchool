package project2;

import java.util.HashMap;

public class Authentication {
    private HashMap<String,String> info = new HashMap<>();

    public Authentication(){
        info.put("user1","password1");
        info.put("user2","password2");
        info.put("user3","password3");
    }

    public HashMap<String,String> getInfo()
    {
        return this.info;
    }
    public void setInfo(HashMap<String,String>info)
    {
        this.info=info;
    }
}
