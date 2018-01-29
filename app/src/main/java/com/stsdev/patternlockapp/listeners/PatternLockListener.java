package com.stsdev.patternlockapp.listeners;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;
import com.stsdev.patternlockapp.ui.CustomizeActivity;

import java.util.List;

/**
 * Created by stavros on 25/1/2018.
 */

public class PatternLockListener implements PatternLockViewListener {

    private PatternLockView pattern;
    private String patternTranslation;
    private static  final String CORRECT_PATTERN = "6304258";
    private Context context;
    private boolean success =false;

    public PatternLockListener(PatternLockView pattern,Context context){

        this.pattern = pattern;
        this.context = context;
    }

    @Override
    public void onStarted() {
        Log.d(getClass().getName(), "Pattern drawing started");
    }

    @Override
    public void onProgress(List<PatternLockView.Dot> progressPattern) {
        Log.d(getClass().getName(), "Pattern progress: " +
                PatternLockUtils.patternToString(pattern, progressPattern));

    }

    @Override
    public void onComplete(List<PatternLockView.Dot> pat) {
        Log.d(getClass().getName(), "Pattern complete: " +
                PatternLockUtils.patternToString(pattern, pat));
        patternTranslation = PatternLockUtils.patternToString(pattern,pat);
        if(patternTranslation.equals(CORRECT_PATTERN)){
            Log.d("Pattern" , "Correct");
            success = true;
            Intent intent = new Intent(context,CustomizeActivity.class);
            context.startActivity(intent);


        }
        else {
            Log.d("PATTERN" , "Wrong");
            pattern.setViewMode(PatternLockView.PatternViewMode.WRONG);

        }

    }

    @Override
    public void onCleared() {
        Log.d(getClass().getName(), "Pattern has been cleared");
    }

    public boolean getSuccess(){
        return this.success;
    }
}
