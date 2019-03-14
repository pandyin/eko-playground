package com.ekoapp.ekoplayground.usecases;

public class MessageGetPagedListRequest implements EkoRequest {

    private String topicId;

    public MessageGetPagedListRequest(String topicId) {
        this.topicId = topicId;
    }

    public String getTopicId() {
        return topicId;
    }
}
