package TestCases;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Routes.UserRoutes;
import io.restassured.response.Response;


public class Tests {
	UserRoutes userroutes;
	
	@Before
	public void setup() {
		userroutes = new UserRoutes();
	}
	
	@Test
	public void getUsers() {
		Response response = userroutes.getAllUsers();
		Assert.assertEquals(200, response.statusCode());
	}
	
	@Test
	public void insertUser() {
		String requestBody = "{\n" +
	            "  \"name\": \"ana\",\n" +
	            "  \"job\": \"estagiario\"\n}";
		
		Response response = userroutes.insertUser(requestBody);
		Assert.assertEquals(201, response.statusCode());
	}
	
	@Test
	public void updateUser() {
		String newUserRequestBody = "{\n" +
	            "  \"name\": \"ana\",\n" +
	            "  \"job\": \"estagiario\"\n}";
		
		String UpdateUserRequestBody = "{\n" +
	            "  \"name\": \"ana\",\n" +
	            "  \"job\": \"efetivado\"\n}";
		
		Response newUserResponse = userroutes.insertUser(newUserRequestBody);
		String UserId = newUserResponse.jsonPath().getString("id");
		
		
		Response updateUserResponse = userroutes.updateUser(UpdateUserRequestBody, UserId);
		
		Assert.assertEquals(200, updateUserResponse.statusCode());
	}
	
	@Test
	public void deleteUser() {
		String newUserRequestBody = "{\n" +
	            "  \"name\": \"ana\",\n" +
	            "  \"job\": \"estagiario\"\n}";
		
		Response newUserResponse = userroutes.insertUser(newUserRequestBody);
		String UserId = newUserResponse.jsonPath().getString("id");
		
		Response deletedUserResponse = userroutes.deleteUser(UserId);
		
		Assert.assertEquals(204, deletedUserResponse.statusCode());
	}
}
