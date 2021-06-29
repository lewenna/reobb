package com.reofixy.reobb.model;

public enum Role {
    ADMIN, SMOD, MOD, WRITER, USER;

    public String getRoleName(){
        switch (this){
            case ADMIN:
                return "Admin";
            case SMOD:
                return "Super Moderator";
            case MOD:
                return "Moderator";
            case WRITER:
                return "Writer";
            case USER:
                return "User";
        }
        return null;
    }
}
