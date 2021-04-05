# {JSON} Placeholder API for testing

How to install, run and write new test cases
It can be cloned with Intellij and can be added new scenarios to the feature file. If it is necessary, new steps should be created in particular StepDefs classes. Since Scenario variables are used, the same scenarios can be executed by adding new parameters under Examples:

The project was automated inside the Circle CI Tool. Once push the new code to the repository, it will be triggered automatically and the test results and the artifacts (cucumber-reports and surefire-reports) are accessible under the GitLab CI/CD Pipelines.

You can see the endpoints interactions below;

Retrieving (by searching) username "Delphine" results

REQUEST
https://jsonplaceholder.typicode.com/users?username=Delphine

RESPONSE
Retrieving a specific username by parameter

If the request succeeds, the server responds with the 200 OK
Content Type is JSON ="application/json; charset=utf-8"

``` 
Status Code: 200 OK
[
{
"id": 9,
"name": "Glenna Reichert",
"username": "Delphine",
"email": "Chaim_McDermott@dana.io",
"address": {
"street": "Dayna Park",
"suite": "Suite 449",
"city": "Bartholomebury",
"zipcode": "76495-3109",
"geo": {
"lat": "24.6463",
"lng": "-168.8889"
}
},
"phone": "(775)976-6794 x41206",
"website": "conrad.com",
"company": {
"name": "Yost and Sons",
"catchPhrase": "Switchable contextually-based project",
"bs": "aggregate real-time technologies"
}
}
]

```

Id number "9" is retrieved and used for another GET request.


REQUEST

GET https://jsonplaceholder.typicode.com/posts?userId=9

RESPONSE
If the request succeeds, the server responds with the 200 OK
Content Type is JSON ="application/json; charset=utf-8"
Total 10 Posts were retrieved after   Query by Id number and value (userId=9).
```
Status Code: 200 OK

[
    {
        "userId": 9,
        "id": 81,
        "title": "tempora rem veritatis voluptas quo dolores vero",
        "body": "facere qui nesciunt est voluptatum voluptatem nisi\nsequi eligendi necessitatibus ea at rerum itaque\nharum non ratione velit laboriosam quis consequuntur\nex officiis minima doloremque voluptas ut aut"
    },
    {
        "userId": 9,
        "id": 82,
        "title": "laudantium voluptate suscipit sunt enim enim",
        "body": "ut libero sit aut totam inventore sunt\nporro sint qui sunt molestiae\nconsequatur cupiditate qui iste ducimus adipisci\ndolor enim assumenda soluta laboriosam amet iste delectus hic"
    },
    {
        "userId": 9,
        "id": 83,
        "title": "odit et voluptates doloribus alias odio et",
        "body": "est molestiae facilis quis tempora numquam nihil qui\nvoluptate sapiente consequatur est qui\nnecessitatibus autem aut ipsa aperiam modi dolore numquam\nreprehenderit eius rem quibusdam"
    },
    {
        "userId": 9,
        "id": 84,
        "title": "optio ipsam molestias necessitatibus occaecati facilis veritatis dolores aut",
        "body": "sint molestiae magni a et quos\neaque et quasi\nut rerum debitis similique veniam\nrecusandae dignissimos dolor incidunt consequatur odio"
    },
    {
        "userId": 9,
        "id": 85,
        "title": "dolore veritatis porro provident adipisci blanditiis et sunt",
        "body": "similique sed nisi voluptas iusto omnis\nmollitia et quo\nassumenda suscipit officia magnam sint sed tempora\nenim provident pariatur praesentium atque animi amet ratione"
    },
    {
        "userId": 9,
        "id": 86,
        "title": "placeat quia et porro iste",
        "body": "quasi excepturi consequatur iste autem temporibus sed molestiae beatae\net quaerat et esse ut\nvoluptatem occaecati et vel explicabo autem\nasperiores pariatur deserunt optio"
    },
    {
        "userId": 9,
        "id": 87,
        "title": "nostrum quis quasi placeat",
        "body": "eos et molestiae\nnesciunt ut a\ndolores perspiciatis repellendus repellat aliquid\nmagnam sint rem ipsum est"
    },
    {
        "userId": 9,
        "id": 88,
        "title": "sapiente omnis fugit eos",
        "body": "consequatur omnis est praesentium\nducimus non iste\nneque hic deserunt\nvoluptatibus veniam cum et rerum sed"
    },
    {
        "userId": 9,
        "id": 89,
        "title": "sint soluta et vel magnam aut ut sed qui",
        "body": "repellat aut aperiam totam temporibus autem et\narchitecto magnam ut\nconsequatur qui cupiditate rerum quia soluta dignissimos nihil iure\ntempore quas est"
    },
    {
        "userId": 9,
        "id": 90,
        "title": "ad iusto omnis odit dolor voluptatibus",
        "body": "minus omnis soluta quia\nqui sed adipisci voluptates illum ipsam voluptatem\neligendi officia ut in\neos soluta similique molestias praesentium blanditiis"
    }
]
```

Retrieving a list of Posts

Each pos id numbers for user (In this example: 9) retrieved. By using for loop, each request for
every single post ID requests were made.

REQUEST
GET https://jsonplaceholder.typicode.com/comments?id=84



RESPONSE
If the request succeeds, the server responds with the 200 OK
Content Type is JSON ="application/json; charset=utf-8"

```
Status Code: 200 OK
[
{
"postId": 17,
"id": 84,
"name": "quia voluptatibus magnam voluptatem ",
"email": "Bernie.Bergnaum@lue.com",
"body": "ratione ut magni voluptas\nexplicabo "
}
]
```

As a next step, the user email was confirmed that it is a valid email address.


TESTS

Total 4 Test Scenarios were tested. 3 Positive Scenarios and 1 Negative scenario.


Note: First, manual tests were conducted by the help of POSTMAN with possible scenarios to find the bug.
After then automation test were performed for certain scenarios. On the scope of those scenarios , no bug detected. 