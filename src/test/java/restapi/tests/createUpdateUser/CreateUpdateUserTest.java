package restapi.tests.createUpdateUser;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import restapi.factoryRequest.FactoryRequest;
import restapi.factoryRequest.RequestInfo;
import utils.Properties;

import java.io.FileNotFoundException;
import java.util.Base64;
import java.util.Date;

import static org.hamcrest.Matchers.equalTo;

public class CreateUpdateUserTest {

    RequestInfo requestInfo = new RequestInfo();

    @Test
    public void verifyCreateUserToken() throws FileNotFoundException {
        requestInfo.setHeader("Content-Type", "application/json");

        // crear usuario
        JSONObject createUserBody = new JSONObject();
        String email = "examen" + new Date().getTime() + "@gmail.com";
        String password = "examen123";
        String fullName = "Dylan Chambi";

        createUserBody.put("Email", email);
        createUserBody.put("Password", password);
        createUserBody.put("FullName", fullName);

        requestInfo.setHost(Properties.apiHost + "/user.json").setBody(createUserBody.toString());

        Response response = FactoryRequest.make("post").send(requestInfo);
        response.then()
                .log().all()
                .statusCode(200)
                //TODO: Verificacion crear usuario
                .body("Email", equalTo(email))
                .body("FullName", equalTo(fullName));

        // crear token
        String auth = Base64.getEncoder().encodeToString((email + ":" + password).getBytes());
        requestInfo.setHost(Properties.apiHost + "/authentication/token.json").setHeader("Authorization", "Basic " + auth);
        response = FactoryRequest.make("get").send(requestInfo);
        response.then()
                .log().all()
                .statusCode(200)
                //TODO: Verificacion crear token
                .body("UserEmail", equalTo(email));

        String token = response.then().extract().path("TokenString");

        requestInfo.setHeader("Authorization", null);

        // atualizar usuario
        JSONObject updateUserBody = new JSONObject();
        String newFullName = "Dylan Chambi Updated";

        updateUserBody.put("FullName", newFullName);

        requestInfo.setHost(Properties.apiHost + "/user/0.json").setBody(updateUserBody.toString()).setHeader("Token", token);
        response = FactoryRequest.make("put").send(requestInfo);
        response.then()
                .log().all()
                .statusCode(200)
                //TODO: Verificacion actualizar usuario
                .body("FullName", equalTo(newFullName));

        // eliminar token
        requestInfo.setHost(Properties.apiHost + "/authentication/token.json").setHeader("Token", token);
        response = FactoryRequest.make("delete").send(requestInfo);
        response.then()
                .log().all()
                .statusCode(200);

        // intentar actualizar usuario
        JSONObject updateUserBodyAgain = new JSONObject();
        String anotherNewFullName = "Dylan Chambi Updated Again";

        updateUserBodyAgain.put("Name", anotherNewFullName);

        requestInfo.setHost(Properties.apiHost + "/user/0.json").setBody(updateUserBodyAgain.toString()).setHeader("Token", token);
        response = FactoryRequest.make("put").send(requestInfo);
        response.then()
                .log().all()
                .statusCode(200)
                //TODO: Verificar que ya no se puede actualizar el usuario
        .body("ErrorMessage", equalTo("Not Authenticated"))
        .body("ErrorCode", equalTo(102));

    }

}
