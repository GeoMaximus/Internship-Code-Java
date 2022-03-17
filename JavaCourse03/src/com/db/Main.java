package com.db;

public class Main {

    public static void main(String[] args) {
	    String s = new String("abc");
        String c = new String("abc");

        System.out.println(s == c); //compares the reference
        System.out.println(s.equals(c)); //compares the content

        String a = new String("abc");
        String b = "abc";

        User u1 = new User("abc", "12345", 10);
        function(u1.getAccount());
        System.out.println(u1.getAccount().value);


        }

    public static void function(Account ac){
        ac.value++;
        System.out.println(ac.value);
        }

    }



class User{
    String name;
    String password;
    private Account account;

    public User(String name, String password, int initValue) {
        this.name = name;
        this.password = password;
        this.account = new Account();
        this.account.value = initValue;
    }

    public Account getAccount() {
        return account.clone();
    }
}

class Account{
    String number;
    int value;

    public Account clone(){
        Account copy = new Account();
        copy.value = this.value;
        copy.number = this.number;
        return copy;
    }


}