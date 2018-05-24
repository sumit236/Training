package snippet;

public class Snippet {
	public String addCustomer() {
			final String url = "http://localhost:8080/addCustomer";
			Customer customer = new Customer("Sherlock Holmes", "Bakers Street", "CASH", "1L");
			RestTemplate restTemplate = new RestTemplate();
			String resultOfOperation = restTemplate.postForObject(url, customer, String.class);
			return resultOfOperation;
		}
}

