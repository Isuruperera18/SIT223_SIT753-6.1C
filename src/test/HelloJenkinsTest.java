import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HelloJenkinsTest {
    @Test
    public void testGetGreeting() {
        HelloJenkins helloJenkins = new HelloJenkins();
        assertEquals("Hello, Jenkins!", helloJenkins.getGreeting());
    }
}

