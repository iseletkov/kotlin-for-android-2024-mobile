package ru.psu.kotlin_android_2024_mobile.ui.compose.chat

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.psu.kotlin_android_2024_mobile.repositories.CRepositoryMessages
import ru.psu.kotlin_android_2024_mobile.services.CServiceNATS

class CViewModelChat: ViewModel(){
    private val nats = CServiceNATS(
        { newStatus ->
            println(newStatus)
        },
        ::addMessage
//        { newMessage ->
//            addMessage(newMessage)
//        }
    )
    init {
        viewModelScope.launch(Dispatchers.IO) {
            nats.connect()
        }

        viewModelScope.launch {
            val newMessages = CRepositoryMessages.service.getLastMessages("mytest")
                .map { message->
                    message.text
                }
                .reversed()
            messages = messages+newMessages
        }
    }
    var message by mutableStateOf("")
        private set

    fun updateMessage(input: String) {
        message = input
    }

    var messages by mutableStateOf<List<String>>(listOf())
        private set

    private fun addMessage(input: String) {
        messages = messages+input
    }

    fun sendMessage()
    {
        viewModelScope.launch(Dispatchers.IO) {
            nats.pub("mytest", message)
            message = ""
        }
    }
}