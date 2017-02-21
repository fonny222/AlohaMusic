package christopherfontana.alohamusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // create the timer
        TimerTask task = new TimerTask(){

            @Override
            public void run(){

                finish();

                // start the next activity after the splash screen
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
            }
        };
        // set the time for the timer
        Timer opening = new Timer();
        opening.schedule(task,5000);
    }
}
