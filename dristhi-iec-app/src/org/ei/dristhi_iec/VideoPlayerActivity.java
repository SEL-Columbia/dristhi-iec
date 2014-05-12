package org.ei.dristhi_iec;

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
        videoMap.put("Condom", R.raw.fp_method_condom);
        videoMap.put("OCP", R.raw.fp_method_ocp);
        videoMap.put("IUD", R.raw.fp_method_iud);
        videoMap.put("Female Sterilization", R.raw.fp_tubal_ligation);
        videoMap.put("Male Sterilization", R.raw.fp_method_vasectomy);
        videoMap.put("ANC General", R.raw.anc_general);
        videoMap.put("IFA", R.raw.anc_ifa);
        videoMap.put("Birth Plan", R.raw.anc_birth_plan);
        videoMap.put("Danger Signs", R.raw.anc_danger_signs);
        videoMap.put("Introduction to PNC", R.raw.pnc_intro_to_pnc);
        videoMap.put("Child Overview", R.raw.child_overview);
        videoMap.put("Diarrhea", R.raw.child_diarrhea);
        videoMap.put("ARI", R.raw.child_ari);
        videoMap.put("Malnutrition", R.raw.child_malnutrition);
    }
}
