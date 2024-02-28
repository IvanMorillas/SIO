package com.sce.dataset;

import jakarta.persistence.*;

@Entity
public class Streamings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int streamingId;

    private String streamingName;

    protected Streamings(){}

    public Streamings(String streamingName) {
        this.streamingName = streamingName;
    }

    public int getStreamingId() {
        return streamingId;
    }

    public void setStreamingId(int streamingId) {
        this.streamingId = streamingId;
    }

    public String getStreamingName() {
        return streamingName;
    }

    public void setStreamingName(String streamingName) {
        this.streamingName = streamingName;
    }

    @Override
    public String toString() {
        return "Streamings{" +
                "streamingId=" + streamingId +
                ", streamingName='" + streamingName + '\'' +
                '}';
    }
}
