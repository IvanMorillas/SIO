package com.sce.dataset;

import jakarta.persistence.*;

@Entity
public class TitlesStreamings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int streamingTitleId;
    private String titleId;

    private int streamingId;

    protected TitlesStreamings(){}

    public TitlesStreamings(String titleId, int streamingId){
        this.titleId = titleId;
        this.streamingId = streamingId;
    }


    public int getStreamingTitleId() {
        return streamingTitleId;
    }

    public void setStreamingTitleId(int streamingTitleId) {
        this.streamingTitleId = streamingTitleId;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public int getStreamingId() {
        return streamingId;
    }

    public void setStreamingId(int streamingId) {
        this.streamingId = streamingId;
    }

    @Override
    public String toString() {
        return "TitlesStreamings{" +
                "streamingTitleId=" + streamingTitleId +
                ", titleId='" + titleId + '\'' +
                ", streamingId=" + streamingId +
                '}';
    }
}
