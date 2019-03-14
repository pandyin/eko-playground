package com.ekoapp.ekoplayground.usecases;

public class TopicGetPagedListRequest implements EkoRequest {

    private String chatId;

    public TopicGetPagedListRequest(String chatId) {
        this.chatId = chatId;
    }

    public String getChatId() {
        return chatId;
    }
}
