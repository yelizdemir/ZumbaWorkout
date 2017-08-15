package com.yelizdemir93.zumbaworkoutapp;

import android.database.Cursor;

public class Kisi
{

    public int id;
    public String name, email,uname,pass;

    public Kisi(Cursor c)
    {
        id = c.getInt(0);
        name = c.getString(1);
        email = c.getString(2);
        uname = c.getString(3);
        pass = c.getString(4);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return this.name;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public String getEmail()
    {
        return this.email;
    }
    public void setUname(String uname)
    {
        this.uname=uname;
    }
    public String getUname()
    {
        return this.uname;
    }
    public void setPass(String pass)
    {
        this.pass=pass;
    }
    public String getPass()
    {
        return this.pass;
    }
}

