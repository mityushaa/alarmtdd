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
    @Test
    public void setAlarmTestTrue(){
        manager = new AlarmManagerBroadcastReceiver();
        activity = new AlarmActivity();
        Assert.assertEquals(true,manager.SetAlarm(activity.getApplicationContext()) );
    }
    @Test
    public void setAlarmTestFalse(){
        manager = new AlarmManagerBroadcastReceiver();
        Assert.assertEquals(false,manager.SetAlarm(activity.getApplicationContext()) );
    }
    @Test
    public void cancelAlarmTestTrue(){
        manager = new AlarmManagerBroadcastReceiver();
        activity = new AlarmActivity();
        Assert.assertEquals(true,manager.CancelAlarm(activity.getApplicationContext()) );
    }
    @Test
    public void cancelAlarmTestFalse(){
        manager = new AlarmManagerBroadcastReceiver();
        Assert.assertEquals(false,manager.CancelAlarm(activity.getApplicationContext()) );
    }
}