package com.techelevator.model;

public class WorkoutRequests {
    private int totalTime;
    private int[] selectedBodyGroups;

    public WorkoutRequests()
    {}

    public WorkoutRequests(int totalTime, int[] selectedBodyGroups) {
        this.totalTime = totalTime;
        this.selectedBodyGroups = selectedBodyGroups;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public int[] getSelectedBodyGroups() {
        return selectedBodyGroups;
    }

    public void setSelectedBodyGroups(int[] selectedBodyGroups) {
        this.selectedBodyGroups = selectedBodyGroups;
    }
}
