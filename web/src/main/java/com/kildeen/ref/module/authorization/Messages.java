package com.kildeen.ref.module.authorization;

import org.apache.deltaspike.core.api.message.MessageBundle;
import org.apache.deltaspike.core.api.message.MessageContextConfig;

@MessageBundle
@MessageContextConfig(messageSource = {"messages"})
public interface Messages

{
    String entityCreated(String entity, String entityIdentifier);

    void unknownFailure(String entity);

    void optimisticLockFailure(String simpleName);

    void overviewFailure(String entity);

    void setupFailure(String entity);

    void userNotFound(String name);
}

