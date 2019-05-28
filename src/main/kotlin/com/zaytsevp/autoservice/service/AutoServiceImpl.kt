package com.zaytsevp.autoservice.service

import com.zaytsevp.autoservice.model.Auto
import com.zaytsevp.autoservice.repository.AutoRepository
import com.zaytsevp.autoservice.service.argument.AutoCreateArgument
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*
import javax.persistence.EntityNotFoundException

@Service
class AutoServiceImpl(val autoRepository: AutoRepository) : AutoService {

    @Transactional
    override fun create(autoCreateArgument: AutoCreateArgument): Auto {
        return autoRepository.save(Auto(autoCreateArgument.name))
    }

    @Transactional(readOnly = true)
    override fun getAll(): List<Auto> {
        return autoRepository.findAll()
    }

    @Transactional(readOnly = true)
    override fun getById(id: UUID): Auto {
        return autoRepository.findById(id).orElseThrow { EntityNotFoundException("Entity $id not found") }
    }
}