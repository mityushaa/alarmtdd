package com.example.mityushaa.alarmtdd;

import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    AlarmActivity activity;
    AlarmManagerBroadcastReceiver manager;

    @Test
    public void setOneTimeAlarmTestTrue(){
        manager = new AlarmManagerBroadcastReceiver();
        activity = new AlarmActivity();
        Assert.assertEquals(true,manager.setOnetimeTimer(activity.getApplicationContext()) );
    }
    @Test
    public void setOneTimeAlarmTestFalse(){
        manager = new AlarmManagerBroadcastReceiver();
        Assert.assertEquals(false,manager.setOnetimeTimer(activity.getApplicationContext()) );
    }
}