package controller;

import model.*;

public class TrelloAPITestsMain {

    public static void main(String[] args) {

        String baseURL = "https://api.trello.com/";
        String apiKey = "d824ada9632418cc965d04fa69c10200";
        String apiToken = "ATTAf1d8af9945f26bf7298da019cc8996ec19c06df853bd9d52ddf5ebf72ef9ff3e8E3FAFB0";
        System.out.println("Trello API Testing");
        System.out.println("Personal API Key: " + apiKey);
        System.out.println("Token: " + apiToken);
        System.out.println("***************************************************************************************");

        Object organizationId;
        Object organizations;
        Object boardId;
        Object boards;
        Object listId;
        Object lists;
        Object deletedBoard;
        Object deletedOrganization;

        // Create a new organization and store its ID
        organizationId = new TrelloAPITestsImplementation().trelloCreateNewOrganization(baseURL, apiKey, apiToken);
        System.out.println("Created Organization ID: " + organizationId);

        // Get organizations and store their IDs
        organizations = new TrelloAPITestsImplementation().trelloGetOrganizations(baseURL, apiKey, apiToken);
        System.out.println("Organizations' IDs: " + organizations);

        // Create a new board and store its ID
        boardId = new TrelloAPITestsImplementation().trelloCreateBoardInsideOrganization(baseURL, apiKey, apiToken, organizationId);
        System.out.println("Created Board ID: " + boardId);

        // Create a new list and store its ID
        listId = new TrelloAPITestsImplementation().trelloCreateNewList(baseURL, apiKey, apiToken, boardId);
        System.out.println("Created List ID: " + listId);

        // Archive a list
        System.out.println("Archived List ID: " + new TrelloAPITestsImplementation()
                .trelloArchiveUnarchiveList(baseURL, apiKey, apiToken, listId, true));

        // Un-archive a list
        System.out.println("Unarchived List ID: " + new TrelloAPITestsImplementation()
                .trelloArchiveUnarchiveList(baseURL, apiKey, apiToken, listId, false));

        // Get boards' IDs and store their IDs
        boards = new TrelloAPITestsImplementation().trelloGetBoardsInsideOrganization(baseURL, apiKey, apiToken, organizationId);
        System.out.println("Boards' ID: " + boards);

        // Get lists' IDs and store their IDs
        lists = new TrelloAPITestsImplementation().trelloGetListsInsideBoard(baseURL, apiKey, apiToken, boardId);
        System.out.println("Lists' ID: " + lists);

        // Delete board
        deletedBoard = new TrelloAPITestsImplementation().trelloDeleteBoard(baseURL, apiKey, apiToken, boardId);
        System.out.println("Deleted Board ID: " + deletedBoard);

        // Delete organization
        deletedOrganization = new TrelloAPITestsImplementation().trelloDeleteOrganization(baseURL, apiKey, apiToken, organizationId);
        System.out.println("Deleted Organization ID: " + deletedOrganization);

    }
}
