package org.bedu.bedushop

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrarTest{

    @Test
    fun `empty field returns false`() {
        val result = registerValidation.validarForm(
            "",
            "sofia@gmail.com",
            "1234567891",
            "passwordisSafe"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun ` mail dont contain @ returns false`() {
        val result = registerValidation.validarForm(
            "Lucia",
            "sofia122",
            "1234567891",
            "passwordisSafe"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `phone number dont have ten numbers returns false`() {
        val result = registerValidation.validarForm(
            "Lucia",
            "sofia122@gmail.com",
            "12391",
            "passwordisSafe"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `pass have less than 8 digits returns false`() {
        val result = registerValidation.validarForm(
            "Lucia",
            "sofia122@gmail.com",
            "1234567891",
            "pass"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `pass have more than 16 digits returns false`() {
        val result = registerValidation.validarForm(
            "Lucia",
            "sofia122@gmail.com",
            "1234567891",
            "passwordisSafe1234"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `logic inputs returns true`() {
        val result = registerValidation.validarForm(
            "Lucia",
            "sofia122@gmail.com",
            "1234567891",
            "passwordisSafe"
        )
        assertThat(result).isTrue()
    }


}