package com.learnshare.simplegame;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private GLSurfaceView mSurfaceView ;

    private GameRenderer mRenderer ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        mSurfaceView = new GLSurfaceView(this);

        mRenderer  = new GameRenderer(this);

        mSurfaceView.setEGLContextClientVersion(2);

        mSurfaceView.setRenderer(mRenderer);

        setContentView(mSurfaceView);
    }
}
