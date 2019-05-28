package com.zaytsevp.autoservice.api.mapper

import com.zaytsevp.autoservice.api.dto.out.AutoDto
import com.zaytsevp.autoservice.model.Auto
import org.mapstruct.Mapper
import org.mapstruct.Mapping

/**
 * Маппер для сущности "Авто"
 *
 * @author Pavel Zaytsev
 */
@Mapper
interface AutoMapper {

    @Mapping(source = "name", target = "autoName")
    fun toDto(auto: Auto): AutoDto
}