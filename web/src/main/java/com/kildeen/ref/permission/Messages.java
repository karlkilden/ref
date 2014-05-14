package com.kildeen.ref.permission;

import org.apache.deltaspike.core.api.message.MessageBundle;
import org.apache.deltaspike.core.api.message.MessageContextConfig;

@MessageBundle
@MessageContextConfig(messageSource = {"messages" })
public interface Messages

{
    String groupCreated(String groupName);

}
