package com.stsdev.patternlockapp.models;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by stavros on 27/1/2018.
 */

@Entity
public class Pattern {

    @Id
    private Long id;

    private boolean stealthMode ;
    private String userCode;


    public Pattern() {
    }

    public Pattern(Long id, boolean stealthMode, String userCode) {

        this.id = id;
        this.stealthMode = stealthMode;
        this.userCode = userCode;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isStealthMode() {
        return stealthMode;
    }

    public void setStealthMode(boolean stealthMode) {
        this.stealthMode = stealthMode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
