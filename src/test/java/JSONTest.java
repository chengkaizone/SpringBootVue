import com.smile.AppContext;
import com.smile.bean.Book;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = AppContext.class)
//这里不能使用@SpringBootTest否则报错：Configuration error: found multiple declarations of @BootstrapWith for test class [AppContext]
@ContextConfiguration(classes = AppContext.class)
@JsonTest
public class JSONTest {

    @Autowired
    JacksonTester<Book> jacksonTester;

    @Test
    public void testSerialize() throws IOException {
        Book book = new Book();
        book.setId(1);
        book.setName("三国演义");
        book.setAuthor("罗贯中");
        Assertions.assertThat(jacksonTester.write(book))
                .isEqualToJson("book.json");
        Assertions.assertThat(jacksonTester.write(book))
                .hasJsonPathStringValue("@.name");
        Assertions.assertThat(jacksonTester.write(book))
                .extractingJsonPathStringValue("@.name")
                .isEqualTo("三国演义");
    }

    @Test
    public void testDeserialize() throws Exception {
        String content = "{\"id\":1,\"name\":\"三国演义\",\"author\":\"罗贯中\"}";
        Assertions.assertThat(jacksonTester.parseObject(content).getName())
                .isEqualTo("三国演义");
    }

}
