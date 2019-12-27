import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GenericService {

    public int calculate() {
        int a = 1;
        int b = 2;

        return a + b;
    }

}
