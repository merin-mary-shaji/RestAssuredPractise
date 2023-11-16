Feature: Simple Book feature

  @GetStatus
  Scenario: User creates request to get Status
    Given User creates request
    When User sends HTTPS Request
    Then User receives 200 Status code
    And "status" in response body is "OK"

  @GetListOfBooks
  Scenario: User able to retrieve all Books with valid Simple Book API
    Given User creates request
    When User sends HTTPS Request to get Books
    Then User receives 200 Status code

  @GetListOfBooks_ValidBookType
  Scenario: User able to retrieve Books with valid Book type
    Given User creates request
    When User sends HTTPS Request to get books with book "type" equal to "fiction"
    Then User receives 200 Status code

  @GetListOfBooks_InValidBookType
  Scenario: User able to retrieve Books with Invalid Book type
    Given User creates request
    When User sends HTTPS Request to get books with book "type" equal to "crime"
    Then User receives 400 Status code

  @GetListOfBooks_ValidLimit
  Scenario: User able to retrieve Books using Valid Limit
    Given User creates request
    When User sends HTTPS Request to get books with book "limit" equal to "2"
    Then User receives 200 Status code

  @GetListOfBooks_InValidLimit
  Scenario: User able to retrieve Books using InValid Limit
    Given User creates request
    When User sends HTTPS Request to get books with book "limit" equal to "25"
    Then User receives 400 Status code

  @GetSingleBook_ValidBookId
  Scenario: User able to retrieve Single Books using Valid Book Id
    Given User creates request
    When User sends HTTPS Request to get books with valid bookId 
    Then User receives 200 Status code
    
     @GetSingleBook_InValidBookId
    Scenario: User able to retrieve Single Books using InValid Book Id
    Given User creates request
    When User sends HTTPS Request to get books with Invalid bookId 
    Then User receives 404 Status code
    
    @RegisterAPIClient
    Scenario: Register the API Client for Authentication
    Given User creates request
    When User sends HTTPS Request to Register the API with a body in request
    Then User receives 201 Status code

    @SubmitAnOrder
    Scenario: User able to Submit a book order
    Given User creates request
    When User sends HTTPS Request to Submit an order with a body in request
    Then User receives 201 Status code
    
    @GetAllOrders
    Scenario: User able to Get all book orders
    Given User creates request
    When User sends HTTPS Request to Get all book orders 
    Then User receives 200 Status code
    
    @GetAnOrder
    Scenario: User able to Get a book order
    Given User creates request
    When User sends HTTPS Request to Get a book orders 
    Then User receives 200 Status code
    
    @UpdateAnOrder
    Scenario: User able to Update an book order
    Given User creates request
    When User sends HTTPS Request to Update an book orders with body in request 
    Then User receives 204 Status code
    
    @DeleteAnOrder
    Scenario: User able to Delete an book order
    Given User creates request
    When User sends HTTPS Request to Delete an book orders 
    Then User receives 204 Status code
    
    
    