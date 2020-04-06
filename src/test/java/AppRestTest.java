import com.smile.AppContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 使用TestRestTemplate
 * 测试真实的Web环境
 * DEFINED_PORT RANDOM_PORT 固定端口或者随机端口 测试真实环境
 * webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppContext.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AppRestTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void test3() {
        ResponseEntity<String> hello = restTemplate.getForEntity("/hello?name={0}", String.class, "Michael");
        System.out.println("body>>> " + hello.getBody());
    }
}
