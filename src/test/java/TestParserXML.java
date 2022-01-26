import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestParserXML {

    @Test
    public void testParseXMLValidArgumentSuccess() throws ParserConfigurationException, IOException, SAXException {
        //given:
        List<Employee> employeeList = new ArrayList<>();
        Employee employee = new Employee(1, "John", "Smith", "USA", 25);
        Employee employee1 = new Employee(2, "Ivan", "Petrov", "RU", 23);
        employeeList.add(employee);
        employeeList.add(employee1);
        String argument = "data.xml";
        List<Employee> expected = employeeList;

        // when:
        List<Employee> result = ParserXML.parseXML(argument);

        // then:
        Assertions.assertEquals(expected,result);
    }

}
