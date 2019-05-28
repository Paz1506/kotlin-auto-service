package com.zaytsevp.autoservice.api.dto.`in`

import javax.validation.constraints.NotBlank

/**
 * ДТО создания авто
 *
 * @author Pavel Zaytsev
 */
data class AutoCreateDto(@field:NotBlank val name: String)