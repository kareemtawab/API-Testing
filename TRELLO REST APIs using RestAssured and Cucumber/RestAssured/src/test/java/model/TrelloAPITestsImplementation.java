package model;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TrelloAPITestsImplementation {


    public Object trelloCreateNewOrganization(String baseURL, String apiKey, String apiToken) {

        //////////////////////////////////////////////////////////////
        // Create a new organization
        //////////////////////////////////////////////////////////////

        String requestURL = "1/organizations/";
        RequestSpecification createNewOrganization = RestAssured.given();
        createNewOrganization
                .baseUri(baseURL)
                .basePath(requestURL)
                .queryParam("displayName", "kareemOrganization")
                .queryParam("key", apiKey)
                .queryParam("token", apiToken)
                .body("")
                .header("Accept", "application/json");
        Response createNewOrganizationResponse = createNewOrganization.post();
        //createNewOrganizationResponse.prettyPrint();
        if (createNewOrganizationResponse.getStatusCode() == 200) {
            return createNewOrganizationResponse.getBody().jsonPath().get("id");
        } else {
            return null;
        }
    }

    public Object trelloGetOrganizations(String baseURL, String apiKey, String apiToken) {

        //////////////////////////////////////////////////////////////
        // Get organizations for a member
        //////////////////////////////////////////////////////////////

        String requestURL = "1/members/me";
        RequestSpecification getOrganizations = RestAssured.given();
        getOrganizations
                .baseUri(baseURL)
                .basePath(requestURL)
                .queryParam("key", apiKey)
                .queryParam("token", apiToken);
        Response getOrganizationsResponse = getOrganizations.get();
        //getOrganizationsResponse.prettyPrint();
        if (getOrganizationsResponse.getStatusCode() == 200) {
            return getOrganizationsResponse.getBody().jsonPath().getList("idOrganizations");
        } else {
            return null;
        }
    }

    public Object trelloCreateBoardInsideOrganization(String baseURL, String apiKey, String apiToken, Object organizationId) {

        //////////////////////////////////////////////////////////////
        // Create a board inside an organization
        //////////////////////////////////////////////////////////////

        String requestURL = "1/boards/";
        RequestSpecification createBoard = RestAssured.given();
        createBoard
                .baseUri(baseURL)
                .basePath(requestURL)
                .queryParam("name", "kareemBoard")
                .queryParam("idOrganization", organizationId)
                .queryParam("key", apiKey)
                .queryParam("token", apiToken)
                .body("")
                .header("Accept", "application/json");
        Response createBoardResponse = createBoard.post();
        //createBoardResponse.prettyPrint();
        if (createBoardResponse.getStatusCode() == 200) {
            return createBoardResponse.getBody().jsonPath().get("id");
        } else {
            return null;
        }
    }

    public Object trelloCreateNewList(String baseURL, String apiKey, String apiToken, Object boardId) {

        //////////////////////////////////////////////////////////////
        // Create a new list
        //////////////////////////////////////////////////////////////

        String requestURL = "1/lists/";
        RequestSpecification createNewList = RestAssured.given();
        createNewList
                .baseUri(baseURL)
                .basePath(requestURL)
                .queryParam("name", "kareemList")
                .queryParam("idBoard", boardId)
                .queryParam("key", apiKey)
                .queryParam("token", apiToken)
                .body("")
                .header("Accept", "application/json");
        Response createNewListResponse = createNewList.post();
        //createNewListResponse.prettyPrint();
        if (createNewListResponse.getStatusCode() == 200) {
            return createNewListResponse.getBody().jsonPath().get("id");
        } else {
            return null;
        }
    }

    public Object trelloGetBoardsInsideOrganization(String baseURL, String apiKey, String apiToken, Object organizationId) {

        //////////////////////////////////////////////////////////////
        // Get boards in an organization
        //////////////////////////////////////////////////////////////

        String requestURL = "1/organizations/" + organizationId + "/boards/";
        RequestSpecification getBoards = RestAssured.given();
        getBoards
                .baseUri(baseURL)
                .basePath(requestURL)
                .queryParam("key", apiKey)
                .queryParam("token", apiToken);
        Response getBoardsResponse = getBoards.get();
        //getOrganizationsResponse.prettyPrint();
        if (getBoardsResponse.getStatusCode() == 200) {
            return getBoardsResponse.getBody().jsonPath().getList("id");
        } else {
            return null;
        }
    }

    public Object trelloGetListsInsideBoard(String baseURL, String apiKey, String apiToken, Object boardId) {

        //////////////////////////////////////////////////////////////
        // Get lists in a board
        //////////////////////////////////////////////////////////////

        String requestURL = "1/boards/" + boardId + "/lists/";
        RequestSpecification getLists = RestAssured.given();
        getLists
                .baseUri(baseURL)
                .basePath(requestURL)
                .queryParam("key", apiKey)
                .queryParam("token", apiToken);
        Response getListsResponse = getLists.get();
        //getOrganizationsResponse.prettyPrint();
        if (getListsResponse.getStatusCode() == 200) {
            return getListsResponse.getBody().jsonPath().getList("id");
        } else {
            return null;
        }
    }

    public Object trelloDeleteBoard(String baseURL, String apiKey, String apiToken, Object boardId) {

        //////////////////////////////////////////////////////////////
        // Delete a board
        //////////////////////////////////////////////////////////////

        String requestURL = "1/boards/" + boardId + "/";
        RequestSpecification deleteBoard = RestAssured.given();
        deleteBoard
                .baseUri(baseURL)
                .basePath(requestURL)
                .queryParam("key", apiKey)
                .queryParam("token", apiToken);
        Response deleteBoardResponse = deleteBoard.delete();
        //getOrganizationsResponse.prettyPrint();
        if (deleteBoardResponse.getStatusCode() == 200) {
            return boardId;
        } else {
            return null;
        }
    }

    public Object trelloDeleteOrganization(String baseURL, String apiKey, String apiToken, Object organizationId) {

        //////////////////////////////////////////////////////////////
        // Delete an organization
        //////////////////////////////////////////////////////////////

        String requestURL = "1/organizations/" + organizationId + "/";
        RequestSpecification deleteOrganization = RestAssured.given();
        deleteOrganization
                .baseUri(baseURL)
                .basePath(requestURL)
                .queryParam("key", apiKey)
                .queryParam("token", apiToken);
        Response deleteOrganizationResponse = deleteOrganization.delete();
        //getOrganizationsResponse.prettyPrint();
        if (deleteOrganizationResponse.getStatusCode() == 200) {
            return organizationId;
        } else {
            return null;
        }
    }

    public Object trelloArchiveUnarchiveList(String baseURL, String apiKey, String apiToken, Object listId, boolean status) {

        //////////////////////////////////////////////////////////////
        // Archive or un-archive a list
        //////////////////////////////////////////////////////////////

        String requestURL = "1/lists/" + listId + "/";
        RequestSpecification archiveUnarchiveList = RestAssured.given();
        archiveUnarchiveList
                .baseUri(baseURL)
                .basePath(requestURL)
                .queryParam("value", ((status) ? "true" : "false"))
                .queryParam("key", apiKey)
                .queryParam("token", apiToken);
        Response archiveUnarchiveListResponse = archiveUnarchiveList.put();
        //archiveUnarchiveListResponse.prettyPrint();
        if (archiveUnarchiveListResponse.getStatusCode() == 200) {
            return listId;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {

    }
}
