package com.techelevator.model;

public class Completion {
    public Completion(int completionId, int completion) {
        this.completionId = completionId;
        this.completion = completion;
    }

    public Completion() {
    }

    public int getCompletionId() {
        return completionId;
    }

    public void setCompletionId(int completionId) {
        this.completionId = completionId;
    }

    private int completionId;

    public int getCompletion() {
        return completion;
    }

    public void setCompletion(int completion) {
        this.completion = completion;
    }

    private int completion;
}
