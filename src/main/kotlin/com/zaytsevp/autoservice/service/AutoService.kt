package com.zaytsevp.autoservice.service

import com.zaytsevp.autoservice.model.Auto
import com.zaytsevp.autoservice.service.argument.AutoCreateArgument
import java.util.*

/**
 * Сервис для работы с сущностью Авто
 *
 * @author Pavel Zaytsev
 */
interface AutoService {

    /** создать авто */
    fun create(autoCreateArgument: AutoCreateArgument): Auto

    /** получить все авто */
    fun getAll(): List<Auto>

    /** получить авто по id */
    fun getById(id: UUID): Auto
}