package com.saifkhan.fingerresponsetimerrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class RespondRecordWindow extends AppCompatActivity {
    boolean isSecondPhase;
    static int count = 1;
    int ind, prevButtonIndex, noOfTrials=93, ampliCounter, r,radius[]={100,300,500}, radCount[]={0,0,0},amps[]={0,1,2,0,2,1,1,0,2,0,2,1,0,2,1,0,2,1,2,0,1,0,2,1,1,2,0,0,2,1,2,1,0,0,2,1,0,1,0,2,2,1,1,0,0,2,2,1,0,0,1,2,2,1,0,0,1,2,2,1,1,0,0,2,2,1,0,1,0,2,2,1,0,2,0,1,2,1,2,0,0,1,2,1,0,0,2,1,2,1,0,0,2,1,2,1,2,0,0,1,2,1,0,2,0,1,2,1,1,2,0,0,2,1,2,1,0,0,2,1,1,0,2,0,2,1,0,1,2,0,2,1,2,0,1,0,2,1,0,2,1,0,2,1,0,1,2,2,0,1,1,0,2,2,0,1,0,2,1,2,0,1,2,0,1,2,0,1,1,2,0,2,0,1,2,1,0,2,0,1,0,1,2,2,0,1,1,0,2,2,0,1,0,2,1,2,0,1,2,0,1,2,0,1,1,2,0,2,0,1,2,1,0,2,0,1,0,2,2,1,0,1,2,0,2,1,0,1,0,2,2,1,0,1,2,0,2,1,0,1,2,2,0,1,0,1,2,2,0,1,0,1,1,2,2,0,0,1,2,1,2,0,0,1,1,2,2,0,0,1,2,1,2,0,0,1,2,2,1,0,0,1,2,2,1,0,0,1,0,1,0,2,2,1,1,0,0,2,2,1,0,0,1,2,2,1,0,0,1,2,2,1,1,0,0,2,2,1,0,1,0,2,2,1,0,1,2,0,2,1,1,0,2,0,2,1,0,2,1,0,2,1,2,0,1,0,2,1,1,2,0,0,2,1,2,1,0,0,2,1,0,0,2,1,2,1,0,0,2,1,2,1,0,2,0,1,2,1,2,0,0,1,2,1,0,2,0,1,2,1,2,0,0,1,2,1,1,0,2,0,2,1,0,1,2,0,2,1,1,2,0,0,2,1,2,1,0,0,2,1,0,2,1,0,2,1,2,0,1,0,2,1,0,2,0,2,1,1,2,0,0,2,1,1,0,0,2,2,1,1,0,0,2,2,1,1,2,0,0,2,1,1,0,2,0,2,1,1,0,2,2,0,1,1,2,0,2,0,1,1,0,2,2,0,1,1,2,0,2,0,1,1,2,2,0,0,1,1,2,2,0,0,1,1,0,0,2,2,1,1,0,0,2,2,1,1,0,2,0,2,1,1,2,0,0,2,1,1,0,2,0,2,1,1,2,0,0,2,1,1,2,0,2,0,1,1,0,2,2,0,1,1,2,2,0,0,1,1,2,2,0,0,1,1,0,2,2,0,1,1,2,0,2,0,1,1,1,2,0,2,0,1,2,1,0,2,0,1,1,0,2,2,0,1,0,1,2,2,0,1,2,0,1,2,0,1,0,2,1,2,0,1,1,2,2,0,0,1,2,1,2,0,0,1,1,2,2,0,0,1,2,1,2,0,0,1,2,2,1,0,0,1,2,2,1,0,0,1,1,0,2,2,0,1,0,1,2,2,0,1,1,2,0,2,0,1,2,1,0,2,0,1,0,2,1,2,0,1,2,0,1,2,0,1,2,0,2,1,0,1,0,2,2,1,0,1,2,2,0,1,0,1,2,2,0,1,0,1,0,2,2,1,0,1,2,0,2,1,0,1,0,1,2,0,1,2,1,0,2,0,1,2,0,2,1,0,1,2,2,0,1,0,1,2,1,2,0,0,1,2,2,1,0,0,1,2,0,1,0,2,1,2,1,0,0,2,1,2,0,0,1,2,1,2,0,0,1,2,1,2,1,0,0,2,1,2,0,1,0,2,1,2,0,2,0,1,1,2,2,0,0,1,1,2,0,0,2,1,1,2,0,0,2,1,1,2,2,0,0,1,1,2,0,2,0,1,1,2,1,2,0,0,1,2,2,1,0,0,1,2,1,0,2,0,1,2,0,1,2,0,1,2,2,0,1,0,1,2,0,2,1,0,1,2,0,1,2,1,0,2,1,0,2,1,0,2,0,2,1,1,0,2,2,0,1,1,0,2,1,2,0,1,0,2,2,1,0,1,0,2,0,1,1,2,0,2,1,0,1,2,0,2,0,1,1,2,0,2,1,0,1,2,0,2,1,1,0,2,0,2,1,1,0,2,0,2,0,2,1,1,0,2,2,0,1,1,0,2,0,1,2,1,0,2,1,0,2,1,0,2,2,1,0,1,0,2,1,2,0,1,0,2,1,2,1,0,0,2,2,1,1,0,0,2,1,1,2,0,0,2,1,1,2,0,0,2,2,1,1,0,0,2,1,2,1,0,0,2,0,1,0,1,2,2,1,0,0,1,2,2,0,0,1,1,2,2,0,0,1,1,2,2,1,0,0,1,2,2,0,1,0,1,2,2,0,1,1,0,2,2,1,0,1,0,2,2,0,1,1,0,2,2,1,0,1,0,2,2,1,1,0,0,2,2,1,1,0,0,2,2,0,0,1,1,2,2,0,0,1,1,2,2,0,1,0,1,2,2,1,0,0,1,2,2,0,1,0,1,2,2,1,0,0,1,2,2,1,0,1,0,2,2,0,1,1,0,2,2,1,1,0,0,2,2,1,1,0,0,2,2,0,1,1,0,2,2,1,0,1,0,2,2,0,2,0,1,1,2,2,0,0,1,1,2,0,0,2,1,1,2,0,0,2,1,1,2,2,0,0,1,1,2,0,2,0,1,1,2,0,2,1,0,1,2,2,0,1,0,1,2,0,1,2,0,1,2,1,0,2,0,1,2,2,1,0,0,1,2,1,2,0,0,1,2,0,0,1,2,1,2,0,0,1,2,1,2,0,1,0,2,1,2,1,0,0,2,1,2,0,1,0,2,1,2,1,0,0,2,1,2,2,0,1,0,1,2,0,2,1,0,1,2,2,1,0,0,1,2,1,2,0,0,1,2,0,1,2,0,1,2,1,0,2,0,1,2,1,2,0,1,0,2,2,1,0,1,0,2,1,0,2,1,0,2,0,1,2,1,0,2,2,0,1,1,0,2,0,2,1,1,0,2,1,2,1,0,0,2,2,1,1,0,0,2,1,1,2,0,0,2,1,1,2,0,0,2,2,1,1,0,0,2,1,2,1,0,0,2,1,0,1,2,0,2,0,1,1,2,0,2,1,1,0,2,0,2,1,1,0,2,0,2,0,1,1,2,0,2,1,0,1,2,0,2,2,0,1,1,0,2,0,2,1,1,0,2,2,1,0,1,0,2,1,2,0,1,0,2,0,1,2,1,0,2,1,0,2,1,0,2,0,1,2,2,1,0,1,0,2,2,1,0,0,2,1,2,1,0,2,0,1,2,1,0,1,2,0,2,1,0,2,1,0,2,1,0,0,1,2,2,1,0,1,0,2,2,1,0,0,2,1,2,1,0,2,0,1,2,1,0,1,2,0,2,1,0,2,1,0,2,1,0,0,2,2,1,1,0,2,0,2,1,1,0,0,2,2,1,1,0,2,0,2,1,1,0,2,2,0,1,1,0,2,2,0,1,1,0,1,2,2,0,1,0,2,1,2,0,1,0,1,2,2,0,1,0,2,1,2,0,1,0,2,2,1,0,1,0,2,2,1,0,1,0,0,1,2,1,2,0,1,0,2,1,2,0,0,2,1,1,2,0,2,0,1,1,2,0,1,2,0,1,2,0,2,1,0,1,2,0,0,1,1,2,2,0,1,0,1,2,2,0,0,1,1,2,2,0,1,0,1,2,2,0,1,1,0,2,2,0,1,1,0,2,2,0,0,2,1,1,2,0,2,0,1,1,2,0,0,1,2,1,2,0,1,0,2,1,2,0,2,1,0,1,2,0,1,2,0,1,2,0,1,2,1,0,2,0,2,1,1,0,2,0,1,1,2,0,2,0,1,1,2,0,2,0,2,1,1,0,2,0,1,2,1,0,2,0,0,1,2,1,2,0,1,0,2,1,2,0,0,2,1,1,2,0,2,0,1,1,2,0,1,2,0,1,2,0,2,1,0,1,2,0,0,1,1,2,2,0,1,0,1,2,2,0,0,1,1,2,2,0,1,0,1,2,2,0,1,1,0,2,2,0,1,1,0,2,2,0,0,2,1,1,2,0,2,0,1,1,2,0,0,1,2,1,2,0,1,0,2,1,2,0,2,1,0,1,2,0,1,2,0,1,2,0,1,2,1,0,2,0,2,1,1,0,2,0,1,1,2,0,2,0,1,1,2,0,2,0,2,1,1,0,2,0,1,2,1,0,2,0,0,2,2,1,1,0,2,0,2,1,1,0,0,2,2,1,1,0,2,0,2,1,1,0,2,2,0,1,1,0,2,2,0,1,1,0,0,2,1,2,1,0,2,0,1,2,1,0,0,1,2,2,1,0,1,0,2,2,1,0,2,1,0,2,1,0,1,2,0,2,1,0,0,2,1,2,1,0,2,0,1,2,1,0,0,1,2,2,1,0,1,0,2,2,1,0,2,1,0,2,1,0,1,2,0,2,1,0,2,2,1,0,1,0,2,2,1,0,1,0,2,1,2,0,1,0,1,2,2,0,1,0,2,1,2,0,1,0,1,2,2,0,1,0,1,2,2,1,0,0,2,1,2,1,0,0,1,2,2,1,0,0,2,1,2,1,0,0,2,2,1,1,0,0,2,2,1,1,0,0,1,2,1,2,0,0,2,1,1,2,0,0,1,1,2,2,0,0,1,1,2,2,0,0,2,1,1,2,0,0,1,2,1,2,0,0,1,2,1,2,0,0,2,1,1,2,0,0,1,1,2,2,0,0,1,1,2,2,0,0,2,1,1,2,0,0,1,2,1,2,0,0,2,2,1,1,0,0,2,2,1,1,0,0,2,1,2,1,0,0,1,2,2,1,0,0,2,1,2,1,0,0,1,2,2,1,0,0,0,1,0,2,1,2,1,0,0,2,1,2,0,0,1,2,1,2,0,0,1,2,1,2,1,0,0,2,1,2,0,1,0,2,1,2,0,1,2,0,1,2,1,0,2,0,1,2,0,2,1,0,1,2,2,0,1,0,1,2,1,2,0,0,1,2,2,1,0,0,1,2,0,0,2,1,1,2,0,0,2,1,1,2,0,2,0,1,1,2,2,0,0,1,1,2,0,2,0,1,1,2,2,0,0,1,1,2,1,0,2,0,1,2,0,1,2,0,1,2,1,2,0,0,1,2,2,1,0,0,1,2,0,2,1,0,1,2,2,0,1,0,1,2,0,1,0,1,2,2,1,0,0,1,2,2,0,0,1,1,2,2,0,0,1,1,2,2,1,0,0,1,2,2,0,1,0,1,2,2,0,1,1,0,2,2,1,0,1,0,2,2,0,1,1,0,2,2,1,0,1,0,2,2,1,1,0,0,2,2,1,1,0,0,2,2,0,0,1,1,2,2,0,0,1,1,2,2,0,1,0,1,2,2,1,0,0,1,2,2,0,1,0,1,2,2,1,0,0,1,2,2,1,0,1,0,2,2,0,1,1,0,2,2,1,1,0,0,2,2,1,1,0,0,2,2,0,1,1,0,2,2,1,0,1,0,2,2,0,1,2,1,0,2,1,0,2,1,0,2,0,2,1,1,0,2,2,0,1,1,0,2,1,2,0,1,0,2,2,1,0,1,0,2,0,1,1,2,0,2,1,0,1,2,0,2,0,1,1,2,0,2,1,0,1,2,0,2,1,1,0,2,0,2,1,1,0,2,0,2,0,2,1,1,0,2,2,0,1,1,0,2,0,1,2,1,0,2,1,0,2,1,0,2,2,1,0,1,0,2,1,2,0,1,0,2,1,2,1,0,0,2,2,1,1,0,0,2,1,1,2,0,0,2,1,1,2,0,0,2,2,1,1,0,0,2,1,2,1,0,0,2,0,0,2,1,1,2,0,0,2,1,1,2,0,2,0,1,1,2,2,0,0,1,1,2,0,2,0,1,1,2,2,0,0,1,1,2,0,0,1,2,1,2,0,0,1,2,1,2,0,1,0,2,1,2,1,0,0,2,1,2,0,1,0,2,1,2,1,0,0,2,1,2,0,2,1,0,1,2,2,0,1,0,1,2,0,1,2,0,1,2,1,0,2,0,1,2,2,1,0,0,1,2,1,2,0,0,1,2,0,2,1,0,1,2,2,0,1,0,1,2,0,1,2,0,1,2,1,0,2,0,1,2,2,1,0,0,1,2,1,2,0,0,1,2,1,0,2,1,0,2,0,1,2,1,0,2,1,2,0,1,0,2,2,1,0,1,0,2,0,2,1,1,0,2,2,0,1,1,0,2,1,0,1,2,0,2,0,1,1,2,0,2,1,1,0,2,0,2,1,1,0,2,0,2,0,1,1,2,0,2,1,0,1,2,0,2,1,2,1,0,0,2,2,1,1,0,0,2,1,1,2,0,0,2,1,1,2,0,0,2,2,1,1,0,0,2,1,2,1,0,0,2,0,2,1,1,0,2,2,0,1,1,0,2,0,1,2,1,0,2,1,0,2,1,0,2,2,1,0,1,0,2,1,2,0,1,0,2,0,2,0,2,1,1,2,0,0,2,1,1,0,0,2,2,1,1,0,0,2,2,1,1,2,0,0,2,1,1,0,2,0,2,1,1,0,2,2,0,1,1,2,0,2,0,1,1,0,2,2,0,1,1,2,0,2,0,1,1,2,2,0,0,1,1,2,2,0,0,1,1,0,0,2,2,1,1,0,0,2,2,1,1,0,2,0,2,1,1,2,0,0,2,1,1,0,2,0,2,1,1,2,0,0,2,1,1,2,0,2,0,1,1,0,2,2,0,1,1,2,2,0,0,1,1,2,2,0,0,1,1,0,2,2,0,1,1,2,0,2,0,1,1,0,2,0,1,2,1,2,0,0,1,2,1,0,0,2,1,2,1,0,0,2,1,2,1,2,0,0,1,2,1,0,2,0,1,2,1,0,2,1,0,2,1,2,0,1,0,2,1,0,1,2,0,2,1,1,0,2,0,2,1,2,1,0,0,2,1,1,2,0,0,2,1,0,0,1,2,2,1,0,0,1,2,2,1,0,1,0,2,2,1,1,0,0,2,2,1,0,1,0,2,2,1,1,0,0,2,2,1,2,0,1,0,2,1,0,2,1,0,2,1,2,1,0,0,2,1,1,2,0,0,2,1,0,1,2,0,2,1,1,0,2,0,2,1,0,2,2,1,0,1,2,0,2,1,0,1,0,2,2,1,0,1,2,0,2,1,0,1,2,2,0,1,0,1,2,2,0,1,0,1,0,2,1,2,0,1,2,0,1,2,0,1,0,1,2,2,0,1,1,0,2,2,0,1,2,1,0,2,0,1,1,2,0,2,0,1,0,2,1,2,0,1,2,0,1,2,0,1,0,1,2,2,0,1,1,0,2,2,0,1,2,1,0,2,0,1,1,2,0,2,0,1,2,2,1,0,0,1,2,2,1,0,0,1,2,1,2,0,0,1,1,2,2,0,0,1,2,1,2,0,0,1,1,2,2,0,0,1,0,0,2,1,2,1,0,0,2,1,2,1,0,2,0,1,2,1,2,0,0,1,2,1,0,2,0,1,2,1,2,0,0,1,2,1,0,0,1,2,2,1,0,0,1,2,2,1,0,1,0,2,2,1,1,0,0,2,2,1,0,1,0,2,2,1,1,0,0,2,2,1,0,2,1,0,2,1,2,0,1,0,2,1,0,1,2,0,2,1,1,0,2,0,2,1,2,1,0,0,2,1,1,2,0,0,2,1,0,2,1,0,2,1,2,0,1,0,2,1,0,1,2,0,2,1,1,0,2,0,2,1,2,1,0,0,2,1,1,2,0,0,2,1,2,0,2,1,0,1,0,2,2,1,0,1,2,2,0,1,0,1,2,2,0,1,0,1,0,2,2,1,0,1,2,0,2,1,0,1,2,0,1,2,0,1,0,2,1,2,0,1,2,1,0,2,0,1,1,2,0,2,0,1,0,1,2,2,0,1,1,0,2,2,0,1,2,2,1,0,0,1,2,2,1,0,0,1,2,1,2,0,0,1,1,2,2,0,0,1,2,1,2,0,0,1,1,2,2,0,0,1,0,2,1,2,0,1,2,0,1,2,0,1,0,1,2,2,0,1,1,0,2,2,0,1,2,1,0,2,0,1,1,2,0,2,0,1,1,2,0,2,1,0,2,1,0,2,1,0,1,0,2,2,1,0,0,1,2,2,1,0,2,0,1,2,1,0,0,2,1,2,1,0,1,2,2,0,1,0,2,1,2,0,1,0,1,2,2,0,1,0,2,1,2,0,1,0,2,2,1,0,1,0,2,2,1,0,1,0,1,0,2,2,1,0,0,1,2,2,1,0,1,2,0,2,1,0,2,1,0,2,1,0,0,2,1,2,1,0,2,0,1,2,1,0,2,0,2,1,1,0,0,2,2,1,1,0,2,2,0,1,1,0,2,2,0,1,1,0,0,2,2,1,1,0,2,0,2,1,1,0,1,2,0,1,2,0,2,1,0,1,2,0,1,0,2,1,2,0,0,1,2,1,2,0,2,0,1,1,2,0,0,2,1,1,2,0,1,2,1,0,2,0,2,1,1,0,2,0,1,1,2,0,2,0,1,1,2,0,2,0,2,1,1,0,2,0,1,2,1,0,2,0,1,0,1,2,2,0,0,1,1,2,2,0,1,1,0,2,2,0,1,1,0,2,2,0,0,1,1,2,2,0,1,0,1,2,2,0,2,0,1,1,2,0,0,2,1,1,2,0,2,1,0,1,2,0,1,2,0,1,2,0,0,1,2,1,2,0,1,0,2,1,2,0,1,2,2,1,0,0,2,1,2,1,0,0,1,2,2,1,0,0,2,1,2,1,0,0,2,2,1,1,0,0,2,2,1,1,0,0,1,2,1,2,0,0,2,1,1,2,0,0,1,1,2,2,0,0,1,1,2,2,0,0,2,1,1,2,0,0,1,2,1,2,0,0,1,2,1,2,0,0,2,1,1,2,0,0,1,1,2,2,0,0,1,1,2,2,0,0,2,1,1,2,0,0,1,2,1,2,0,0,2,2,1,1,0,0,2,2,1,1,0,0,2,1,2,1,0,0,1,2,2,1,0,0,2,1,2,1,0,0,1,2,2,1,0,0,1,0,2,1,2,0,0,1,2,1,2,0,1,2,0,1,2,0,2,1,0,1,2,0,0,2,1,1,2,0,2,0,1,1,2,0,1,0,1,2,2,0,0,1,1,2,2,0,1,1,0,2,2,0,1,1,0,2,2,0,0,1,1,2,2,0,1,0,1,2,2,0,1,2,1,0,2,0,2,1,1,0,2,0,1,1,2,0,2,0,1,1,2,0,2,0,2,1,1,0,2,0,1,2,1,0,2,0,0,2,1,1,2,0,2,0,1,1,2,0,0,1,2,1,2,0,1,0,2,1,2,0,2,1,0,1,2,0,1,2,0,1,2,0,2,0,2,1,1,0,0,2,2,1,1,0,2,2,0,1,1,0,2,2,0,1,1,0,0,2,2,1,1,0,2,0,2,1,1,0,2,0,1,2,1,0,0,2,1,2,1,0,2,1,0,2,1,0,1,2,0,2,1,0,0,1,2,2,1,0,1,0,2,2,1,0,2,2,1,0,1,0,2,2,1,0,1,0,2,1,2,0,1,0,1,2,2,0,1,0,2,1,2,0,1,0,1,2,2,0,1,0,0,2,1,2,1,0,2,0,1,2,1,0,0,1,2,2,1,0,1,0,2,2,1,0,2,1,0,2,1,0,1,2,0,2,1,0,};
    Button prevButton, exitButton, strtButton, buttons[];
    TextView bannerText, bannerTextFinger;
    String age = null, gender = null;
    static List timeList, timeList2, trialList,xCordinate, yCordinate, amplist;
    static long previousTime, currentTime, timeDuretion;
    Random rand = new Random();

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("DATA");


    private void initialization() {
        count = 1;
        isSecondPhase = false;
        ampliCounter=rand.nextInt(100)*6;
        buttons = new Button[5];
        buttons[0] = findViewById(R.id.buttonSmall);
        buttons[1] = findViewById(R.id.buttonMedium);
        buttons[2] = findViewById(R.id.buttonLarge);
        exitButton=findViewById(R.id.buttonExit);
        strtButton = findViewById(R.id.buttonStrt);
        bannerText=findViewById(R.id.bannerText);
        bannerTextFinger= findViewById(R.id.bannerTextFinger);
        timeList = new ArrayList<String>();
        timeList2 = new ArrayList<String>();
        trialList = new ArrayList<Integer>();
        xCordinate = new ArrayList<Integer>();
        yCordinate = new ArrayList<Integer>();
        amplist= new ArrayList<Integer>(); amplist.add(-1);
    }

    public void lastClick() {

        System.out.println("Amplitudes " + amplist + "  " + amplist.size());
        System.out.println("Button  : "+ trialList + "  " + amplist.size());
        System.out.println("First  Time: "+ timeList + "  " + amplist.size());
        System.out.println("Second Time: "+ timeList2 + "  " + amplist.size());

        // Get age and gender from previous activity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            age = extras.getString("age").toString();
            gender = extras.getString("gender");
        }

        //creating an unique user id
        String userid = String.valueOf(System.currentTimeMillis());
        RespondData savedata = new RespondData(age,gender,timeList,timeList2, trialList, amplist);
        DatabaseReference myRef = database.getReference("DATA");
        Toast.makeText(getApplicationContext(),"Age:"+age+"; Gender:"+gender, Toast.LENGTH_SHORT).show();
        myRef.child(userid).setValue(savedata);


        exitButton.setVisibility(View.VISIBLE);
        bannerText.setText("Data of the experiment is saved.");
        bannerText.setVisibility(View.VISIBLE);
        bannerTextFinger.setText("Thank you for your Help!");
        bannerTextFinger.setVisibility(View.VISIBLE);
    }

    public void onButtonClick(View view) {

        currentTime = System.currentTimeMillis();
        timeDuretion = currentTime - previousTime;

        trialList.add(prevButtonIndex);
        //TrialDetails temp=new TrialDetails(prevButtonIndex, timeDuretion);
        //trialList.add(temp);

        previousTime = System.currentTimeMillis();
        prevButton.setVisibility(View.INVISIBLE);

        if (count >= 2*noOfTrials) {
            System.out.println("count >= 2*noOfTrials");
            timeList2.add(timeDuretion);
            lastClick();
            return;
        }else if(count==noOfTrials && isSecondPhase) {
            System.out.println("RADCOUNT "+ radCount[0] + " " + radCount[1] + " "+ radCount[2]);
            timeList.add(timeDuretion);

            bannerTextFinger.setText("Thumb Finger"); //Change here for counter balalnce
            bannerTextFinger.setVisibility(View.VISIBLE);
            strtButton.setVisibility(View.VISIBLE);
            bannerText.setVisibility(View.VISIBLE);
            return;
        } else if(count>noOfTrials) {
            ind= (int) trialList.get(count-noOfTrials);
            buttons[ind].setX((int) xCordinate.get(count-noOfTrials));
            buttons[ind].setY((int) yCordinate.get(count-noOfTrials));
            System.out.println("count: " + count + "  position: " + ind);
            timeList2.add(timeDuretion);
        }
        else{
            System.out.println("COUNITING PANIC "+ count);

            ind = count / 31;

            System.out.println("count: " + count + "  random ind: " + ind);

            int angles[]={0, 30, 45, 60, 90, 120, 150, 180, 210, 240, 270, 300, 330, 360};
            float distance, O=angles[rand.nextInt(angles.length)], x, y;

            if(count%31==0) {
                r = radius[rand.nextInt(3)];
                System.out.println("RADCOUNT " + radCount[0] + " " + radCount[1] + " " + radCount[2]);
            }
            else{
                r = radius[amps[ampliCounter]];
                radCount[amps[ampliCounter]]++;
                ampliCounter++;
            }

            do{
                O=angles[rand.nextInt(angles.length)];
                x= (float) (r * Math.sin(O)) + prevButton.getX();
                y= (float) (r * Math.cos(O)) + prevButton.getY();
                distance= (float) Math.sqrt(Math.pow(prevButton.getX()-x,2) + Math.pow(prevButton.getY()-y,2));
                System.out.println("x "+ x + " y "+ y + " dis "+ distance + " r "+ r);
            }while(x<100 || x>1050 || y<100 || y > 1600);


            buttons[ind].setX(x);
            buttons[ind].setY(y);

            xCordinate.add((int) x);
            yCordinate.add((int) y);
            amplist.add(r);
            timeList.add(timeDuretion);
        }

        buttons[ind].setVisibility(View.VISIBLE);

        count++;
        prevButtonIndex = ind;
        prevButton = buttons[ind];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        initialization();

        strtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                strtButton.setVisibility(View.INVISIBLE);
                bannerText.setVisibility(View.INVISIBLE);
                bannerTextFinger.setVisibility(View.INVISIBLE);

                previousTime = System.currentTimeMillis();

                if (isSecondPhase){
                    ind = (int) trialList.get(count - noOfTrials);
                    buttons[ind].setX((int) xCordinate.get(count - noOfTrials));
                    buttons[ind].setY((int) yCordinate.get(count - noOfTrials));

                    buttons[ind].setVisibility(View.VISIBLE);

                    count++;
                    prevButtonIndex = ind;
                    prevButton = buttons[ind];
                    return;
                }
                else{
                    ind = 0;
                    int width = rand.nextInt(1000) + 50;
                    buttons[ind].setX(width);
                    int height = rand.nextInt(1200) + 50;
                    buttons[ind].setY(height);
                    xCordinate.add(width);
                    yCordinate.add(height);

                    buttons[ind].setVisibility(View.VISIBLE);
                    isSecondPhase = true;
                    prevButton = buttons[ind];
                    prevButtonIndex = ind;
                }
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RespondRecordWindow.this.finish();
                System.exit(0);
            }
        });
    }
}