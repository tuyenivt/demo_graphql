# Demo GraphQL with Java
#### Run project
<code>mvn spring-boot:run</code>
#### Testing query
<p>Open browser and access to http://localhost:8080/graphiql</p>
<p>Create new data:</p>
<pre>
mutation {
  createStudent(name: "NAME_1", address: "ADDRESS_1", dateOfBirth: "2000-01-01") {
    id
  }
}
</pre>
<p>Query data:</p>
<pre>
{
  students(limit: 10) {
    id
    name
    address
    dateOfBirth
  }
}
</pre>
<pre>
{
  student(id: 1) {
    id
    name
    address
    dateOfBirth
  }
}
</pre>
