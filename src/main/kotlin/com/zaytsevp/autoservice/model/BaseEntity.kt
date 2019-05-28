package com.zaytsevp.autoservice.model

import org.hibernate.annotations.Type
import java.io.Serializable
import java.util.*
import javax.persistence.*

/**
 * Базовый класс, от которого наследуются все сущности
 *
 * @author Pavel Zaytsev
 */
@MappedSuperclass
abstract class BaseEntity(@Id
                          @GeneratedValue(strategy = GenerationType.AUTO)
                          @Column(name = "ID", updatable = false)
                          @Type(type = "uuid-char")
                          var id: UUID? = null) : Serializable {

    /* если сущность новая (не сохраненная в БД) */
    val isNew: Boolean
        get() = id != null
}