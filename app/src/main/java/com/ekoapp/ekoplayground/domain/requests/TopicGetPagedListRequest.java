package com.ekoapp.ekoplayground.domain.requests;

public class TopicGetPagedListRequest implements EkoRequest {

    private String chatId;

    public TopicGetPagedListRequest(String chatId) {
        this.chatId = chatId;
    }

    public String getChatId() {
        return chatId;
    }
}
