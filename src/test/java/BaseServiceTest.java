import com.app.service.UrlConfigurationService;
import javax.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BaseServiceTest {
    @Mock
    protected HttpServletRequest httpServletRequest;
    @Mock
    protected UrlConfigurationService urlConfigurationService;
}
