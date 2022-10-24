# ContainerBookings

There are 2 APIs in this Spring boot webflux cassandra application application

Prerequisites
Install Apache cassandra on local to connect. This project is not dockerised/containerized. Once that is done, it will create the docker image to run.

###/api/bookings/containers/checkAvailable
Sample Input
{
“containerType” : “DRY”,
“containerSize” : 20,
“origin” : “Southampton”,
“destination” : “Singapore”,
“quantity” : 5
}

Sample output
{
“available”: true
}

###/api/bookings/containers/generateContainerOrder
Sample Input
{
“containerType” : “DRY”,
“containerSize” : 20,
“origin” : “Southampton”,
“destination” : “Singapore”,
“quantity” : 5,
“timestamp” : “2020-10-12T13:53:09Z”
}
Sample Output
{
“bookingRef” : “957000002”
}

