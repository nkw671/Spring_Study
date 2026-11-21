package com.study.demo;

public class SecretGuestBook extends GuestbookEntry{
    protected String password;
    public SecretGuestBook(String name, String message, String password) {
        super(name,message);
        this.password = password;
    }

    @Override
    public String getMessage() {
        return "비밀글입니다.";
    }

    @Override
    public String readMessage(String passwordIn) {
        if(!password.equals(passwordIn)){
            throw new IncorrectPasswordException("비밀번호가 틀립니다.");
        }
        return message;
    }
}
