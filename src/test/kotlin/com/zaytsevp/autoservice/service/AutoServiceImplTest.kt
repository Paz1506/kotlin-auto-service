package com.zaytsevp.autoservice.service

import com.zaytsevp.autoservice.model.Auto
import com.zaytsevp.autoservice.repository.AutoRepository
import com.zaytsevp.autoservice.service.argument.AutoCreateArgument
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito
import org.mockito.Mockito.*
import java.util.*
import java.util.function.Function
import javax.persistence.EntityNotFoundException


/**
 * @author Pavel Zaytsev
 */
internal class AutoServiceImplTest {

    private val autoRepository: AutoRepository = mock(AutoRepository::class.java)

    private val autoService: AutoService = AutoServiceImpl(autoRepository)

    private val name: String = "name"

    private val auto = mock(Auto::class.java)

    @Test
    fun create() {
        // Prepare
        val autoCreateArgument = AutoCreateArgument(name)

        `when`(autoRepository.save(any(Auto::class.java))).thenReturn(auto)

        // Arrange
        val actualResult: Auto = autoService.create(autoCreateArgument)

        val autoCaptor = ArgumentCaptor.forClass(Auto::class.java)

        // Assertion
        verify(autoRepository).save(autoCaptor.capture())

        Assertions.assertThat(actualResult).isSameAs(auto)

        Assertions.assertThat(autoCaptor.value)
            .extracting(Function<Auto, Any?> { it.id }, Function<Auto, Any>(Auto::name))
            .containsExactly(null, name)

    }

    @Test
    fun getAll() {
        // Prepare
        val expectedResult: List<Auto> = listOf(auto)

        `when`(autoRepository.findAll()).thenReturn(expectedResult)

        // Arrange
        val actualResult = autoService.getAll()

        // Assertion
        verify(autoRepository).findAll()
        verifyNoMoreInteractions(autoRepository)

        Assertions.assertThat(actualResult).containsOnly(auto)
    }

    @Test
    fun getById() {
        // Prepare
        val id = UUID.randomUUID()

        `when`(autoRepository.findById(any(UUID::class.java))).thenReturn(Optional.of(auto))

        // Arrange
        val actualResult = autoService.getById(id)

        // Assertion
        verify(autoRepository).findById(id)
        verifyNoMoreInteractions(autoRepository)

        Assertions.assertThat(actualResult).isSameAs(auto)
    }

    @Test
    fun `getById when auto not found`() {
        // Prepare
        val id = UUID.randomUUID()

        `when`(autoRepository.findById(any(UUID::class.java))).thenReturn(Optional.empty())

        // Actual && Assertion
        val exception = assertThrows(EntityNotFoundException::class.java) {
            autoService.getById(id)
        }

        Assertions.assertThat(exception.message).isEqualTo("Entity $id not found")

        verify(autoRepository).findById(id)
        verifyNoMoreInteractions(autoRepository)
    }
}