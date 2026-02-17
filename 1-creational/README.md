# Worksheet on Design Patterns (Part I)

## Creational Design Patterns

In these exercises we will be examining the following design patterns:
 
+ Factory Method, 
+ Abstract Factory, 
+ Builder,
+ Singleton,
+ Prototype.

------

### Factory Method

The *Factory Method* pattern gives us a way to encapsulate the instantiations of concrete types; 
it encapsulates the functionality required to select and instantiate an appropriate class, inside a designated method 
referred to as a *factory method*.  The factory method selects an appropriate class from a class hierarchy based on the 
application context and other contributing factors and then instantiates the selected class and returns it as an instance 
of the parent class type. The advantage of this approach is that the application objects can make use of the factory method 
to gain access to the appropriate class instance. This eliminates the need for an application object to deal explicitly with 
the varying class selection criteria.

Consider a scenario, where a product company has shifted the way they used to take orders 
from their clients. The company is now looking to use an application to take orders from them. 
They receive orders, errors in orders, feedback for the previous order, and responses to the order 
in an XML format. The company has asked you to develop an application to parse the XML and 
display the result to them.

The main challenge for you is to parse an XML and display its content to the user. 
There are different XML formats depending on the different types of messages the company 
receives from its clients. For example, an order type XML has different sets of XML tags 
as compared to the response or error XML. But the core job is the same: 
to display to the user the message being carried in these XMLs.

Although the core job is the same, the object that would be used varies according to 
the kind of XML the application gets from the user. So, an application object may only know 
that it needs to access a class from within the class hierarchy (hierarchy of different parsers), 
but does not know exactly which class from among the set of subclasses of the parent 
class is to be selected.  In this case, it is better to provide a factory,
`XMLParserFactory`, so that at runtime a parser gets instantiated to do the job 
according to the kind of XML the application receives from the user. 
The *Factory Method* Pattern, suited for this situation, defines an interface 
for creating an object, but let subclasses decide which class to instantiate. 

Implement the required method in class `XMLParserFactory`
so that the test code in `TestFactoryPattern` produces the following output:

```
Parsing error XML...
error message
***********************************************
Parsing feedback XML...
feedback message
***********************************************
Parsing order XML...
order request
***********************************************
```

### Abstract Factory

The *Abstract Factory* pattern takes the concept of the Factory Method Pattern to the next level. 
An abstract factory is a class that provides an interface to produce a family of objects. 
In Java, it can be implemented using 
an interface or an abstract class. The Abstract Factory pattern is useful when a client object 
wants to create an instance of 
one of a suite of related, dependent classes without having to know which specific concrete 
class is to be instantiated. 
Different concrete factories implement the abstract factory interface.

Let's consider scenario of Factory Design Pattern, where we have created an interface 
to be called by class to get XML 
parsers but delayed the instantiation of actual XML parser object to runtime based 
on the type of XML given to system. 
The application is working fine for them. But now the clients don’t want to 
follow the company’s specifics XML rules. 
The clients want to use their own XML rules to communicate with the product company. 
This means that for every client, 
the company should have client specific XML parsers. For example, 
for the CL client there should be three specific types of 
XML parsers, i.e. `CLErrorXMLParser`, `CLFeedbackXMLParser`, and `CLOrderXMLParser`,
and three different parsers for the NY client.

The company has asked you to change the application according to the new requirement. 
To develop the parser application we have used the Factory Method Design Pattern 
in which the exact object to use is 
decided by the subclasses according to the type of parser. Now, to implement this new requirement, 
we will use a factory of  factories, i.e., an Abstract Factory. 
This time we need parsers according to client-specific XMLs, so we will create 
different factories, `NYParserFactory` and `CLParserFactory`, for different clients, 
which will provide us the client-specific XML parsers. 
We will also create an Abstract Factory `ParserFactoryProducer` to provide the factory required 
by each of the clients. 

The resulting implementation should give the following output with the `TestAbstractFactoryPattern` 
test class:

```
Parsing CL error XML...
error message
***********************************************
Parsing NY feedback XML...
feedback message
***********************************************
Parsing NY order XML...
order request
```

### Builder

The intent of the *Builder Pattern* is to separate the construction of a complex object 
from its representation, so that the same construction process can create different representations.

In general, the details of object construction, such as instantiating and initialising 
the components that make up the object, 
are kept within the object, often as part of its constructor. 
This type of design closely ties the object construction 
process with the components that make up the object. This approach is suitable 
as long as the object under construction 
is simple and the object construction process is definite and always produces 
the same representation of the object.

However, this design may not be effective when the object being created is 
complex and the series of steps constituting 
the object creation process can be implemented in different ways, 
thus producing different representations of the object. 
Because the different implementations of the construction process 
are all kept within the object, the object can become 
bulky (construction bloat) and less modular. Subsequently, 
adding a new implementation or making changes to an existing 
implementation requires changes to the existing code.
The intention of the builder pattern is to find a solution to the telescoping constructor 
anti-pattern in which 
the POJO has numerous constructors each taking a different number of parameters 
that delegate to a default constructor. 
The multiple constructors make it difficult to use the class. 
Also, it’s difficult to distinguish between parameters 
of the same type, and it’s often the case that  there isn’t a constructor 
that does the job you want, so you end up either 
adding a new constructor or using a `null` parameter.

Builder pattern suggests using a dedicated object referred to as a Director, 
which is responsible for invoking different 
builder methods required for the construction of the final object. 
Different client objects can make use of the Director 
object to create the required object. Once the object is constructed, 
the client object can directly request from the builder 
the fully constructed object. To facilitate this process, a new method `getObject` 
can be declared in the common Builder 
interface to be implemented by different concrete builders.

This design eliminates the need for a client object to deal with the methods 
constituting the object construction process 
and encapsulates the details of how the object is constructed from the client.

To illustrate the use of the Builder Pattern, let’s help a Car company which shows 
its different cars using a graphical 
model to its customers. The company has a graphical tool which displays the car on the screen. 
The requirement of the 
tool is to provide a car object to it. The car object should contain the car’s specifications. 
The graphical tool uses 
these specifications to display the car. The company 
has classified its cars into different classifications like Sedan 
or Sports Car. There is only one `Car` object, 
and our job is to create the car object according to the classification. 
For example, for a Sedan car, a car object according to the sedan specification 
should be built or, if a sports car is 
required, then a car object according to the sports car specification should be built. 
Currently, the Company wants only 
these two types of cars, but it may require other types of cars also in the future. 
We will create two different builders, `SedanCarBuilder` and `SportsCarBuilder`. 
These two builders will help us in building the car object 
according to its specification.

You should implement the required methods in the builder classes so that the `TestBuilderPattern`
test class outputs the following:

```
--------------SEDAN---------------------
 Body: External dimensions: overall length (inches): 202.9, overall width (inches): 76.2, overall height (inches): 60.7, wheelbase (inches): 112.9, front track (inches): 65.3, rear track (inches): 65.5 and curb to curb turning circle (feet): 39.5
 Power: 285 hp @ 6,500 rpm; 253 ft lb of torque @ 4,000 rpm
 Engine: 3.5L Duramax V 6 DOHC
 Breaks: Four-wheel disc brakes: two ventilated. Electronic brake distribution
 Seats: Front seat center armrest.Rear seat center armrest.Split-folding rear seats
 Windows: Laminated side windows.Fixed rear window with defroster
 Fuel Type: Gasoline 19 MPG city, 29 MPG highway, 23 MPG combined and 437 mi. range
--------------SPORTS---------------------
 Body: External dimensions: overall length (inches): 192.3, overall width (inches): 75.5, overall height (inches): 54.2, wheelbase (inches): 112.3, front track (inches): 63.7, rear track (inches): 64.1 and curb to curb turning circle (feet): 37.7
 Power: 323 hp @ 6,800 rpm; 278 ft lb of torque @ 4,800 rpm
 Engine: 3.6L V 6 DOHC and variable valve timing
 Breaks: Four-wheel disc brakes: two ventilated. Electronic brake distribution. StabiliTrak stability control
 Seats: Driver sports front seat with one power adjustments manual height, front passenger seat sports front seat with one power adjustments
 Windows: Front windows with one-touch on two windows
 Fuel Type: Gasoline 17 MPG city, 28 MPG highway, 20 MPG combined and 380 mi. range
```

### Singleton

Singleton pattern restricts the instantiation of a class  and ensures that only one instance 
of the class exist in the system. The singleton class must provide a global access 
point to get the instance of the class.

There are many objects we only need one instance of them, and if we instantiate more than one, 
we’ll run into all  sorts of problems like incorrect program behaviour, overuse of resources, 
or inconsistent results. You may require only one object of a class, for example, 
when you are a creating the context of an application, or a thread manageable pool, 
registry settings, a driver to connect to the input or output console, etc. 
More than one object of that type clearly will cause inconsistency to your program.

+ Why might you decide to *lazy-initialise* a singleton instance rather than 
initialise it in its field declaration? 
Provide code examples of both approaches to illustrate your answer.
	
+ There are many ways to break the singleton pattern. One is in a multithreaded 
environment but others include:
    	    
  + if the class is `Serializable`;
  + if it is `Cloneable`;
  + it can be broken by reflection;
  + if the class is loaded by multiple *class loaders*.	
	
Try and write a class `SingletonProtected` that addresses some (all?) of these issues.

### Prototype

The prototype pattern is a *creational* design pattern in software development 
and is used when the type of objects to create is determined by a prototypical 
instance, which is cloned to produce new objects.

Creating a heavy object could become costly, 
and if your application needs too many of that kind of objects 
(containing almost similar properties), it might create some performance issues.

Let us consider a scenario where an application requires some access control. 
The features of the applications can be used by the users according to 
the access rights provided to them. For example, some users have access 
to the reports generated by the  application, while some don’t. 
Some of them even can modify the reports, while some can only read it. 
Some users also have administrative rights to add or even remove other users.
Every `User` object has an `AccessControl` object, 
which is used to provide or restrict the controls of the application. 
This access control object is a bulky, heavy object and its creation 
is very costly since it requires data to be fetched from some external resources, 
like databases or some property files etc.

We can use the Prototype Design Pattern to resolve this problem 
by creating the `AccessControl` objects on all levels at once, 
and then provide a copy of the object to the user whenever required. 
In this case, data fetching from the external resources happens only once. 
Next time, the access control object is created by *copying* the existing one. 
The access control object is not created from scratch every time the request is sent; 
this approach will certainly reduce object creation time.

Prototype design pattern must not be confused with Flyweight design pattern. 
First of all they belong to different categories: Prototype is creational one, 
Flyweight is structural one. In Prototype, objects’ creation go through cloning, 
it eases object’s creation. By making a request for cloning we create a
new cloned object each time. In Flyweight by making a request we try to reuse 
as many objects as possible by sharing them. New required object will be created 
if we don’t find a matching one. It’s being done for resource optimization. 
While in Prototype we could clone even one object, Flyweight pattern 
makes sense to use when in the application we use big number of 
heavy and common objects so that we could replace it by single heavy object.

The concept in Prototype design pattern is to copy an existing object 
rather than to create a new instance from scratch, 
something that may include costly operations. 
The existing object acts as a prototype and contains the state of the object. 
The newly copied object may change same properties only if required. 
This approach saves costly resources and time, 
especially when the object creation is a heavy process.