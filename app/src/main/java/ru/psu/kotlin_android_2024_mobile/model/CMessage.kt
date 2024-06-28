package ru.psu.kotlin_android_2024_mobile.model

import kotlinx.serialization.Serializable
import ru.psu.kotlin_android_2024_mobile.utils.CConverterUUID
import java.time.LocalDateTime
import java.util.UUID

@Serializable
data class CMessage(
    /****************************************************************************************************
     * Идентификатор.                                                                                   *
     ***************************************************************************************************/
    @Serializable(with = CConverterUUID::class)
    var id                                  : UUID?
                                            = null,

    var text                                : String
    = "",

    var author                              : String
    = "",

    var subject                             : String
    = "",
//    var datetime                            : LocalDateTime
//                                            = LocalDateTime.now()
)