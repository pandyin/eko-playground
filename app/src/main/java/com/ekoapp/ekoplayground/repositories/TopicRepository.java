package com.ekoapp.ekoplayground.repositories;

import com.ekoapp.ekoplayground.room.EkoDatabase;
import com.ekoapp.ekoplayground.room.entities.Topic;

public class TopicRepository extends EkoRepository<Topic> {

    public TopicRepository() {
        super(EkoDatabase.get().getTopicDao());
    }
}
