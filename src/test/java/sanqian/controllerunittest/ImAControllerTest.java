package sanqian.controllerunittest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author yzhuang
 */

public class ImAControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new ImAController()).build();
    }

    @Test
    public void testHello() throws Exception {
        this.mockMvc.perform(get("/hello?n=yy"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testReceiveGiftFail() throws Exception {
        final MockHttpServletRequestBuilder mockHttpServletRequestBuilder = post("/gift");
        this.mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(status().is4xxClientError())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testReceiveGiftSuccess() throws Exception {
        final MockHttpServletRequestBuilder mockHttpServletRequestBuilder = post("/gift")
                .param("g", "Mooncake")
                .param("v", "118");
        this.mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

}