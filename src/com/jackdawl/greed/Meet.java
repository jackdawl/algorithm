package com.jackdawl.greed;

public class Meet implements Comparable<Meet> {



    private int id;

    private int startTime;

    private int endTime;


    public Meet(int id, int startTime, int endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Meet o) {
        if (this.endTime > o.endTime) {
            return 1;
        } else {
            return -1;
        }

    }



    public String toString() {
        return "Meet [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + "]";
    }



}
