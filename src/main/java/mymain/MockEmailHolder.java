package mymain;
import static org.mockito.Mockito.*;

public class MockEmailHolder {
	private WebEmailService mockmail=mock(WebEmailService.class);


public MockEmailHolder(Search shome) {
	shome.setEmailservice(mockmail);
	
}

public WebEmailService getMockmail() {
	return mockmail;
}


}