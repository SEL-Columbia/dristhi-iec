package org.ei.dristhi_health_education_app;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.HashMap;
import java.util.Map;

public class VideoPlayerActivity extends Activity {
    private Map<String, Integer> videoMap = new HashMap<String, Integer>();
    private VideoView player;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_player);
        initializeVideoMap();

        player = (VideoView) findViewById(R.id.video_player);
        initializeVideoView();
        player.start();
    }

    @Override
    public void onBackPressed() {
        player.stopPlayback();
        finish();
    }

    private void initializeVideoView() {
        String path = "android.resource://" + getPackageName() + "/" + videoMap.get(getIntent().getStringExtra("VideoName"));
        player.setVideoURI(Uri.parse(path));
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                finish();
            }
        });
        MediaController mediaController = new MediaController(this, true);
        player.setMediaController(mediaController);
        mediaController.setAnchorView(player);
    }

    private void initializeVideoMap() {
        videoMap.put("Introduction to Family Planning", R.raw.fp1_intro_to_fp);
        videoMap.put("Condom Method", R.raw.fp_method_condom);
    }
}
