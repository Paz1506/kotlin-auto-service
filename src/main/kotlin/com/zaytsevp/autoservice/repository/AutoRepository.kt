package com.zaytsevp.autoservice.repository

import com.zaytsevp.autoservice.model.Auto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

/**
 * Репозиторий для работы с сущностью Авто
 *
 * @author Pavel Zaytsev
 */
@Repository
interface AutoRepository : JpaRepository<Auto, UUID>