REST APIs, paths & scops:

* **GET /api/question** is for viewing the survey.
* **POST /api** is for fill in the survey.
* **GET /api** is for viewing the survey result.

In this article, we protect these APIs by applying role-based access control (RBAC) to
enforce the following requirements:

* **GET /api/question** is available for each request.
* **POST /api** is available for authenticated user requests containing an access
token with the SCOPE_Survey.User scope granted.
* **GET /api** is available for authenticated admin user requests containing an access token with the SCOPE_Survey.Admin scope granted.