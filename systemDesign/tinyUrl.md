Problem: https://www.interviewbit.com/problems/tiny-url/

Design a tiny url service.

Minimum Features:
Able to provide tiny url as quickly as possible.
Created tiny url should redirect to the url provided by the user.
Created tiny url should be short enough so that user can type quickly.
Every tiny url should be unique.
Https urls create https tiny urls.

Other Features:
Provide a way for the user to login in the system to create tiny url so that he can check metrics related to the created url.
Provide functionality to check how many times the url has been clicked.

Features I missed:
Custom urls: Users can define a custom url.

Estimation:

How many queries would be there in the system.

1. How many request would be there for creating of the tiny url.
2. How many request would be there for the redirect of the url which are created.

The queries per second are called as QPS of the system.
How much data will the system handle in the request.

Lets say there are 100 queries per second for creation of the tiny url.
Lets say there are 1000 request per second for the redirection.

Assume 100 million urls are added per month.
100/30 -> allmost 3 million per day
which is almost 34 per second, i was taking 100 per second







