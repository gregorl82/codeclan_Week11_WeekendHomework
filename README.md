<h1>Java Airline Modelling</h1>
<h2>Brief</h2>
<p>The task is to model a system for the world renowned online travel booking agent TravelJava.</p>
<h4>Assumptions</h4>
<ul>
<li>Each passenger bag weighs the same</li>
<li>Planes reserve half of their total weight for passenger bags</li>
<li>The weight of bag per person is the weight reserved for passenger bags divided by the capacity</li>
<li>Passengers exist for a single flight only</li>
</ul>
<h2>MVP</h2>
<p>Create a Passenger class which has:</p>
<ul>
<li>a name</li>
<li>a number of bags</li>
</ul>
<p>Create a Plane class which has:</p>
<ul>
<li>an enum PlaneType (e.g. BOEING747) which stores capacity and total weight</li>
<li>an empty list of booked Passengers</li>
</ul>
<p>Create a Flight class which has:</p>
<ul>
<li>a Plane</li>
<li>flight number (i.e. “FR756”)</li>
<li>destination (i.e. GLA, EDI)</li>
<li>departure airport (i.e. GLA, EDI)</li>
<li>departure time (use a String)</li>
</ul>
<p>The Flight class should have methods to:</p>
<li>return the number of available seats</li>
<li>book a passenger (if there are remaining seats)</li>
<h2>Extensions</h2>
<p>Create a FlightManager class which has methods to:</p>
<ul>
<li>calculate how much baggage weight should be reserved for each passenger for a flight</li>
<li>calculate how much baggage weight is booked by passengers of a flight</li>
<li>calculate how much overall weight reserved for baggage remains for a flight</li>
</ul>
<h2>More Extensions</h2>
<ul>
<li>Refactor the Flight’s departure time to use the Date class</li>
<li>Add a ‘flight’ property to the Passenger class which is assigned when a passenger is added to a flight</li>
<li>Add a ‘seat number’ property to the Passenger class as an integer. Set it to a random number which is assigned when a Passenger is booked on a flight</li>
<li>Make sure the flight doesn’t double book the same seat number to more than one passenger</li>
</ul>
<h2>Further Extensions</h2>
<ul>
<li>Write a method in FlightManager to sort the passengers of a Flight by seat number by implementing a Bubble Sort</li>
<li>Write a method in FlightManager that uses a Binary Search to find a Passenger by seat number.</li>
</ul>
