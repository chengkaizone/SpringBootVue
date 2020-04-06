import com.apple.eawt.Application;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smile.AppContext;
import com.smile.bean.Book;
import com.smile.service.HelloService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppContext.class)
public class AppTest {

    @Autowired
    HelloService helloService;

    @Autowired
    WebApplicationContext wac;
    MockMvc mockMvc;

    @Test
    public void contextLoads() {
        String hello = helloService.sayHello("gan");
        //String hello = "Hello gan!";
        Assert.assertThat(hello, Matchers.is("Hello gan!"));
    }

    @Before
    public void before() {
        System.out.println("----before----");
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testHello() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/hello")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name", "Machael"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println("testHello >>> " + mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testObject() throws Exception {
        ObjectMapper om = new ObjectMapper();
        Book book = new Book();
        book.setAuthor("罗贯中");
        book.setName("三国演义");
        book.setId(1);
        String s = om.writeValueAsString(book);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/testbook")
            .contentType(MediaType.APPLICATION_JSON)
            .content(s))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        System.out.println("textObject>>> " + mvcResult.getResponse().getContentAsString());
    }

}
