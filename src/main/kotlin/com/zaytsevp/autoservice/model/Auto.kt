package com.zaytsevp.autoservice.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

/**
 * @author Pavel Zaytsev
 */
@Entity
@Table(name = "HOUSE")
data class Auto(@Column(name = "NAME") var name: String) : BaseEntity()