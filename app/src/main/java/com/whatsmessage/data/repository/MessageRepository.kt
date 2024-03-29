package com.whatsmessage.data.repository

import com.whatsmessage.framework.datasource.ILocalMessage
import com.whatsmessage.domain.Message

class MessageRepository (private val localMessage: ILocalMessage) {
    suspend fun save(message: Message): Boolean = localMessage.save(message)
    suspend fun getListMessage(state: Int): List<Message> = localMessage.getListMessage(state)
    suspend fun update(message: Message): Boolean = localMessage.update(message)
}