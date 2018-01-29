package com.stsdev.patternlockapp.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by stavros on 25/1/2018.
 */

public class User implements Parcelable{


    private String actualName;
    private String email;
    private String userIcon;

    @Override
    public void writeToParcel(Parcel dest , int flags){
        dest.writeString(this.actualName);
        dest.writeString(this.email);
        dest.writeString(this.userIcon);
    }

    @Override
    public int describeContents(){
        return 0;
    }

    protected  User(Parcel in){
        this.actualName = in.readString();
        this.email = in.readString();
        this.userIcon = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>(){
      @Override
      public User createFromParcel(Parcel source){
          return new User(source);
      }

      @Override
      public User[] newArray(int size){
          return new User[size];
      }
    };

    public User() {
    }

    public void setActualName(String actualName) {

        this.actualName = actualName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getActualName() {

        return actualName;
    }

    public String getEmail() {
        return email;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public User(String actualName, String email, String userIcon) {

        this.actualName = actualName;
        this.email = email;
        this.userIcon = userIcon;
    }
}
