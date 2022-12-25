package Routes;
import Utils.RestApiMethods;
import io.restassured.response.Response;


public class UserRoutes extends RestApiMethods{
	public String baseURL = "https://reqres.in/api/users";
	
	public Response getAllUsers() {
		return getALL(baseURL);
	}
	
	public Response insertUser(String requestBody) {
		return insert(baseURL, requestBody);
	}
	
	public Response updateUser(String requestBody, String userID) {
		String baseURLWithUserId = baseURL + '/' + userID;
		return update(baseURLWithUserId, requestBody);
	}
	
	public Response deleteUser(String userID) {
		String baseURLWithUserId = baseURL + '/' + userID;
		return delete(baseURLWithUserId);
	}
}
