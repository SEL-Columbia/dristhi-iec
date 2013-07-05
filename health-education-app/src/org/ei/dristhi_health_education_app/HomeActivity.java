package org.ei.dristhi_health_education_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void playVideo(final View view) {
        Intent intent = new Intent(this, VideoPlayerActivity.class);
        intent.putExtra("VideoName", ((Button)view).getText());
        startActivity(intent);
    }
}
