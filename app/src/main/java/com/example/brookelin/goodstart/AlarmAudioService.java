package com.example.brookelin.goodstart;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Brand on 4/21/2017.
 */

public class AlarmAudioService extends Service {

    MediaPlayer alarm_media;
    int startId;
    boolean isRunning;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("Local Service","Received start id " + startId + ":" + intent);

        // Fetch extra values
        String state = intent.getExtras().getString("extra");

        // Fetch audio choice integer values
        Integer audio_choice_id = intent.getExtras().getInt("choose_audio");

        Log.e("Ringtone extra is ", state);
        Log.e("Audio choice is ", audio_choice_id.toString());



        // This converts extra strings from intent to start IDs, values 0 or 1
        assert state != null;
        switch (state) {
            case "alarm on":
                startId = 1;
                break;
            case "alarm off":
                Log.e("Start id is ", state);
                break;
            default:
                startId = 0;
                break;
        }


        // if else statements

        // If there is no music playing and the user toggles the alarm to enabled
        // music should start playing
        if(!this.isRunning && startId == 1){
            Log.e("there is no music","you want on");

            this.isRunning = true;
            this.startId = 0;

            // Play the audio chosen by the user
            if(audio_choice_id == 0){
                // create instance of the media player
                alarm_media = MediaPlayer.create(this, R.raw.calm_wakeup);
                // Starts ringtone
                alarm_media.start();

            } else if(audio_choice_id == 1){
                // create instance of the media player
                alarm_media = MediaPlayer.create(this, R.raw.early_sunrise);
                // Starts ringtone
                alarm_media.start();

            } else if(audio_choice_id == 2){
                // create instance of the media player
                alarm_media = MediaPlayer.create(this, R.raw.flute_alarm);
                // Starts ringtone
                alarm_media.start();

            } else if(audio_choice_id == 3){
                // create instance of the media player
                alarm_media = MediaPlayer.create(this, R.raw.gentleness);
                // Starts ringtone
                alarm_media.start();

            } else if(audio_choice_id == 4) {
                // create instance of the media player
                alarm_media = MediaPlayer.create(this, R.raw.good_morning);
                // Starts ringtone
                alarm_media.start();

            } else if(audio_choice_id == 5) {
                // create instance of the media player
                alarm_media = MediaPlayer.create(this, R.raw.loving_you);
                // Starts ringtone
                alarm_media.start();

            } else if(audio_choice_id == 6) {
                // create instance of the media player
                alarm_media = MediaPlayer.create(this, R.raw.rainfall);
                // Starts ringtone
                alarm_media.start();

            } else if(audio_choice_id == 7) {
                // create instance of the media player
                alarm_media = MediaPlayer.create(this, R.raw.sunshine);
                // Starts ringtone
                alarm_media.start();

            }

        }



        /* if there is music playing and the user toggles the alarm to disabled,
        * music should stop playing */
        else if(this.isRunning && startId == 0){
            Log.e("there is music", "and you want it to end");

            // Stop the ringtone
            alarm_media.stop();
            alarm_media.reset();

            this.isRunning = false;
            this.startId = 0;
        }
        /* the next two statements are for the user pressing random buttons*/
        /* If there is no music playing and alarm toggles to off, do nothing*/
        else if(this.isRunning && startId == 0){
            Log.e("there is no music","and you want end");

            this.isRunning = false;
            this.startId = 0;

        }
        /* If there is no music playing and alarm toggles to on, do nothing*/
        else if(!this.isRunning && startId == 1) {
            Log.e("there is music","you want start");

            this.isRunning = true;
            this.startId = 1;


        }
        // Just to catch an odd event
        else {
            Log.e("else","somehow you got here");

        }

        return  START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.e("on destroy called","yay");

        super.onDestroy();
        this.isRunning = false;

    }

}
