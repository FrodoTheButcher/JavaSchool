package project2;

import project2.LoginPage;

public class Main {
    
    public static void main(String[] args) {
        Authentication authentication = new Authentication();
        authentication.getInfo();
    LoginPage loginPage = new LoginPage(authentication.getInfo());
    }

}
