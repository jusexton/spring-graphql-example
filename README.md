# Spring GraphQL Example

Small CRUD application demonstrating how to build a GraphQL API with Kotlin, MongoDB and Spring Boot.

You will need a mongo instance to connect too for this application to work.

## GraphQL Dependencies
```
implementation 'com.graphql-java:graphiql-spring-boot-starter:5.0.2'
implementation 'com.graphql-java:graphql-spring-boot-starter:5.0.2'
implementation 'com.graphql-java:graphql-java-tools:5.2.4'
```

## GraphiQL

### Adding New Users
![Alt text](screenshots/mutation-screenshot.png?raw=true "Mutation Screenshot")

```
type Mutation {
    # Used to create a new user in the system
    createUser(input: UserInput!): User!
}
```

```
fun createUser(userInput: UserInput) = userRepository.save(User(userInput.username, userInput.address))
```

### Querying Users
![Alt text](screenshots/query-screenshot.png?raw=true "Query Screenshot")

```aidl
extend type Query {
    # Retrieves a user by their id
    userById(id: String!): User

    # Used to retrieve all users in the system.
    allUsers(filter: UserFilter): [User]!
}
```

```aidl
fun userById(id: String) = userService.repository.findById(id).orElseThrow { UserNotFoundException(id) }

fun allUsers(filter: UserFilter?) = userService.findAll(filter)
```

### Error Messages
![Alt text](screenshots/error-screenshot.png?raw=true "Error Screenshot")

```aidl
@Component
class ErrorHandler : GraphQLErrorHandler {
    override fun processErrors(errors: MutableList<GraphQLError>?): MutableList<GraphQLError> =
            errors?.map { getNested(it) }?.toMutableList() ?: mutableListOf()

    private fun getNested(error: GraphQLError): GraphQLError =
            if (error is ExceptionWhileDataFetching && error.exception is GraphQLError) error.exception as GraphQLError else error
}
```