package com.hwc.kotlinspring

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(HelloController::class)
class HelloControllerTest {
    @Autowired
    lateinit var mvc: MockMvc

    @Test
    @DisplayName("Main")
    fun getHello() {
        val resultActions: ResultActions = mvc.perform(get("/"))
            .andDo { print(it) }

        resultActions.andExpect(status().is2xxSuccessful)
            .andExpect(content().string("Greetings!"))
            .andDo { print(it) }
    }
}
