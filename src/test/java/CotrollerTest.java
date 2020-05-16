import cn.pigletter.controller.IndexController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class CotrollerTest {
    @Test
    public void testHomePage() throws Exception {
        IndexController cotrollerTest = new IndexController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(cotrollerTest).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/index")).andExpect(view().name("index"));
    }
}
