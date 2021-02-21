package com.saifkhan.fingerresponsetimerrecord;

//not used

public class TrialDetails {

    static int sequenceNo=0;
    int trailSequenceNo, indexPosition;
    long time;

    public TrialDetails(int buttonIndex, long time) {
        trailSequenceNo= ++sequenceNo;
        this.indexPosition=buttonIndex;
        this.time=time;
    }
}
