package ru.psu.kotlin_android_2024_mobile.services

import io.nats.client.Connection
import io.nats.client.Message
import io.nats.client.Nats
import io.nats.client.Options
import java.nio.charset.StandardCharsets

class CServiceNATS(
    val onConnectionEventListener: (String) -> Unit ?,
    val onMessageReceived : (String) -> Unit ?
)
{
    private var nc : Connection? = null
    private var status : String = "Disconnected"
    fun connect() {
        val options: Options = Options.Builder().server("nats://192.168.1.4").build()
        try{
            nc = Nats.connect(options)
            status = "Connected"
            onConnectionEventListener(status)

            val d = nc?.createDispatcher { msg: Message? -> }

            d?.subscribe("mytest") { msg ->
                val newMessage = String(msg.data, StandardCharsets.UTF_8)
                onMessageReceived(newMessage)
            }
        }
        catch (exp: Exception)
        {
            status = "Connection failed"
            onConnectionEventListener(status)
        }
    }
    fun publish(topic: String, msg: String){
        nc?.publish(topic, msg.toByteArray(StandardCharsets.UTF_8))
    }

}