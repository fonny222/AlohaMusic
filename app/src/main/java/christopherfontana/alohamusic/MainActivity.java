package christopherfontana.alohamusic;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // class variables for the buttons
    Button button1,button2;

    // class variable for the media player
    MediaPlayer mpUkulele,mpDrums;

    // class variable for playing
    int playing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // instantiate the buttons
        button1 = (Button) findViewById(R.id.btnUkulele);
        button2 = (Button) findViewById(R.id.btnDrums);

        // on click listener makes the button wait for the users tap
        button1.setOnClickListener(bUkulele);
        button2.setOnClickListener(bDrums);

        // create an instance of the media player
        mpUkulele = new MediaPlayer();

        // assign first song to mpUkulele
        mpUkulele = MediaPlayer.create(this, R.raw.ukulele);

        // add instance for the second mediaPlayer variable
        mpDrums = new MediaPlayer();
        mpDrums = MediaPlayer.create(this, R.raw.drums);

        playing = 0;


    }

    Button.OnClickListener bUkulele = new Button.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch(playing){
                case 0:
                    mpUkulele.start();
                    playing = 1;
                    button1.setText("Pause Ukulele Song");
                    button2.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpUkulele.pause();
                    playing = 0;
                    button1.setText("Play Ukulele Song");
                    button2.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };



    Button.OnClickListener bDrums = new Button.OnClickListener(){

        @Override
        public void onClick(View v) {
                switch(playing){
                    case 0:
                        mpDrums.start();
                        playing = 1;
                        button2.setText("Pause Drums Song");
                        button1.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        mpDrums.pause();
                        playing = 0;
                        button2.setText("Play Drums Song");
                        button1.setVisibility(View.VISIBLE);
                }
        }

    };
}
