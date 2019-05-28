package com.zaytsevp.autoservice.service.argument

import javax.validation.constraints.NotBlank

/**
 * Аргумент создания сущности Авто
 *
 * @author Pavel Zaytsev
 */
class AutoCreateArgument(@field:NotBlank val name: String)