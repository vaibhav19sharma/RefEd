package com.example.vaibh.refed;

import android.content.Intent;
import android.gesture.Gesture;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private TextView txtMessage;
    private GestureDetectorCompat GD;    //must instantiate the gesture detector

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GD = new GestureDetectorCompat(this, this);   //Context, Listener as per Constructor Doc.
        GD.setOnDoubleTapListener(this);   //DoubleTaps implemented a bit differently, must be bound like this.

        txtMessage = (TextView)findViewById(R.id.txtMessage);
    }

    //////////////////////////////////////////////////////////////////////////
    //very important step, otherwise we won't be able to capture our touches//
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.GD.onTouchEvent(event);               //Our GD will not automatically receive Android Framework Touch notifications.
        // Insert this line to consume the touch event locally by our GD,
        // IF YOU DON'T insert this before the return, our GD will not receive the event, and therefore won't do anything.
        return super.onTouchEvent(event);          // Do this last, why?
    }
    //////////////////////////////////////////////////////////////////////////


    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }


    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        txtMessage.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        txtMessage.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

        txtMessage.setText("onScroll");
//
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        txtMessage.setText("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        txtMessage.setText("onFling");
        Intent i = new Intent(getApplicationContext(),Login.class);
        startActivity(i);
        return true;
    }
}
