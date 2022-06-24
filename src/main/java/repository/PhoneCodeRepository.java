package repository;

import core.PrepareRepositoryService;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.HashMap;

@Repository
@Data
@Component
public class PhoneCodeRepository {

    private HashMap<String, String> repository;

    public PhoneCodeRepository() throws IOException {
        repository = new PrepareRepositoryService().prepare();
    }


    public HashMap<String, String> getRepository() {
        return repository;
    }
}
