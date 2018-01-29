package com.stsdev.patternlockapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;
import com.andrognito.patternlockview.utils.ResourceUtils;
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.Glide;
import com.stsdev.patternlockapp.listeners.PatternLockListener;
import com.stsdev.patternlockapp.models.User;

import java.util.List;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
private static final String  CORRECT_PATTERN = "6304258";
public  static final String TAG = MainActivity.class.getSimpleName();

private String patternTranslation;
    @BindView(R.id.pattern_lock_view)
    PatternLockView pattern;
    @BindColor(R.color.colorAccent)
    int color;

    @BindView(R.id.profileImage)
    ImageView profPic;

    @BindView(R.id.profile_name)
    TextView profName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Bundle data = getIntent().getExtras();
        User user = (User) data.getParcelable("user");

        pattern.addPatternLockListener(new PatternLockListener(pattern,this));
        Glide.with(getApplicationContext()).load(user.getUserIcon())
               .into(profPic);
        profName.setText(user.getActualName());

    }

    public void onStart(){
        super.onStart();


    }


}
