package core;

import domain.CountryEntity;
import repository.PhoneCodeRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ProcessRequestService {

    private PhoneCodeRepository repository = new PhoneCodeRepository();

    public ProcessRequestService() throws IOException {
    }

    public String process(String request) {
        var charSet = request.toCharArray();
        var result = "";
        var listOfCountries = repository.getRepository();
        if (request.charAt(0) != '+') {
            var testString = "+";
            for (int i = 0; i < request.length(); i++) {
                testString = testString + charSet[i];

                var interimResult = find(testString, listOfCountries);
                if (interimResult != null){
                    result = interimResult;
                }
            }
        } else {
            var testString = "";
        }
        return result;
    }

    private String find(String testString, HashMap<String, String> repository) {
        var result = repository.get(testString);
        return result;
    }
}
