import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestJsonParser {


    @Test
    public void readStringValidArgumentSuccess() {
        //given:
        String argument = "data2.json";
        String expected = "[{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\",\"country\":\"USA\",\"age\":25}," +
                "{\"id\":2,\"firstName\":\"Ivan\",\"lastName\":\"Petrov\",\"country\":\"RU\",\"age\":23}]";

        //when:
        String result = jsonParser.readString(argument);

        //then:
        Assertions.assertEquals(expected, result);

    }
}
