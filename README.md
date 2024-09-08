Run Service Registry first.
Then User-service and Department-Service.
At the end run API-Gateway.

If both service is up it works fine.
If Department-Service is down circuit breaker does not work.

#########################.
if you have hyper-v/ Virtual Box disable their network. In my machine spring was scanning them and throwing error as "can not find localhost" .
Disabling them worked.
