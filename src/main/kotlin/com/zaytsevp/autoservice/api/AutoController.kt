package com.zaytsevp.autoservice.api

import com.zaytsevp.autoservice.api.dto.`in`.AutoCreateDto
import com.zaytsevp.autoservice.api.dto.out.AutoDto
import com.zaytsevp.autoservice.api.mapper.AutoMapper
import com.zaytsevp.autoservice.service.AutoService
import com.zaytsevp.autoservice.service.argument.AutoCreateArgument
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

/**
 * Контроллер для работы с Авто
 *
 * @author Pavel Zaytsev
 */
@RestController
@RequestMapping("autos")
class AutoController(val autoService: AutoService, val autoMapper: AutoMapper) {

    @GetMapping(value = ["{id}"])
    fun getById(@PathVariable(value = "id") id: UUID): AutoDto {
        return autoService.getById(id)
                .run { autoMapper.toDto(this) }
    }

    @GetMapping(value = ["list"])
    fun getAll(): List<AutoDto> {
        return autoService.getAll()
                .map { autoMapper.toDto(it) }
    }

    @PostMapping(value = ["/create"])
    fun getAll(@Validated @RequestBody autoCreateDto: AutoCreateDto): AutoDto {
        return autoService.create(AutoCreateArgument(autoCreateDto.name))
                .run { autoMapper.toDto(this) }
    }
}