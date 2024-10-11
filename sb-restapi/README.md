# Controller layer

1. Add Annotation @RestController

2. Define your own RESTful API
  - Get
  - Post
  - Put
  - Patch
  - Delete

3. Three type of InputParam
  - @PathVariable -> "{endpoint}/path"
  - @RequestParam -> "{endpoint}/path?param1=xxx&param2=yyy"
  - @RequestBody  -> Input JSON, so we need to create an object in Java

```java
@Getter
@Setter
@NoArgsConstructorU
@AllArgsConstructor
@ToString
@Builder
public class UserRequest {
  private String name;
  private String email;
  private String phone;
}
```

  Postman: Body -> raw -> JSON