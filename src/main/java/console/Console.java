package console;


import core.ProcessRequestService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Scanner;

public class Console {

    ProcessRequestService service = new ProcessRequestService();

    public Console() throws IOException {
    }

    public void startUI(){
    var scanner = new Scanner(System.in);
    System.out.println("Hello, please enter phone number. Please not place 00 in front of number");
    var request = scanner.next();
    var response = service.process(request);
    System.out.println(response);


}
}
