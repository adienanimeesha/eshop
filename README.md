## Module 1
<details>
  <summary>Reflection 1</summary>

### Reflection 1
To ensure clean code principle is applied, I create variable names that describes their purpose.
For example, createProductPost and deleteProduct. This way, others can immediately understand the 
function of the variable. I also maintain a consistent naming convention, by capitalizing the 
first letter of each word, such as ProductService. Other than that, the MVC pattern is used, where there are
files that contains business logic, handles HTTP request, and manages data storage. To ensure secure coding practice 
is applied, adding a "findById(id)" helps check whether a product exists before allowing users to delete or 
update. An area of improvement would be to handle products that does not exist, which is done by modifying the 
"findById(id)" code to return an error message instead of showing null. 

</details>

<details>
  <summary>Reflection 2</summary>

### Reflection 2
1. Writing the unit test made me feel more secure about my code. Unit tests are created to test whether our code can 
withstand normal and harder test cases. Which is why knowing the more difficult test cases pass with my code made me feel 
as if the code is reliable enough. However, this does not mean the code is free of bugs as there may be edge cases. 
The number of unit test varies, however it should be able to cover important aspects, such as testing the branches, the 
path, and the statement.

2. I think the cleanliness of the code of the new function test suite will not be as clean. This is because the new test suite
may have the same instance variables as the previous functional test. Other than that, there may be duplicates of the test suits, 
which makes the code repetitive and may minimize the maintainability, making the code inconsistent. This can be improved by creating
a new java class that contains the same logic, allowing each test suite to inherit from the new class instead of 
redefining it. This step also allows the test cases to be cleaner and maintainable, reducing chances of inconsistency. 

</details>


## Module 2

<details>
  <summary>Reflection</summary>

1. 
- First issue: SonarCloud suggests not hardcoding the version numbers in build.gradle.kts. This is resolved by creating a new file called gradle.properties
in the root folder and adding the plugins, dependencies, and their corresponding version numbers. Then, I edited the build.gradle.kts file so that it uses delegated properties 
to reference these versions.
- Second issue: A constant should be defined instead of duplicating the literal "redirect:/product/list" four times. This issue occurs in the ProductController.java file 
and is resolved by defining a constant (REDIRECT_PRODUCT_LIST) at the top of the controller class. The constant is then used in place of the duplicated literal, meaning 
that any future changes to the redirect URL only need to be made in one place.

2. I believe the current implementation meets the definition of CI/CD. Every time a pull request is made, automated checks such as SonarCloud analysis and tests
are run and verified before merging into the main branch, which demonstrates Continuous Integration by immediately testing new code to catch any issues. Other than that, 
Continuous Deployment is implemented as well since the project is integrated with Koyeb. Therefore every time new code is pushed, the application is automatically deployed without 
requiring any extra manual steps.


</details>


## Module 3
<details>
  <summary>Reflection</summary>

**1. The principles I applied to my project are SRP, DIP, and OCP**
- SRP
Single Responsibility Principle is when every class should have one responsibility. In the context of my project, 
```controller```, ```service```, and ```repository``` have their own responsibility, which aids in maintainability and clarity. 
The file ```CarController``` is made since its content was previously inside ```ProductController```.

- DIP
Dependency Inversion Principle is when high-level modules should not depend on low-level modules. Instead, both should depend on
abstractions, which enhances flexibility within the system. This means it will be easier to expand or modify the code without tampering
other components. In my project, this is visible in the ```CarServiceImpl``` class, where the repository is added through its interface.
```java
@Autowired 
public CarServiceImpl(CarRepositoryInterface carRepository) {
    this.carRepository = carRepository;
}
```
Because of this ```CarServiceImpl``` remains independent and does not rely on any concrete repository implementation.

- OCP
Open-Closed Principle is when classes, function, and modules should be allowed in a way that allows us to add new features without having 
to tamper the original code. In my project, this is evident in ```AbstractRepository```, more accurately the ```AbstractRepository<T?``` class.
The class provides general methods of implementation, which includes create, delete, update, findAll, and findById. Other than that, defining interfaces, 
such as ```CarRepositoryInterface``` and ```ProductRepositoryInterface```, will rely on abstractions instead of specific implementations. 


**2. The advantages of applying SOLID principles in my project are listed below:**
- Improves Flexibility and Extensibility
An example of this would be in ```AbstractRepository```, where it is used for extension rather than modification. By doing so, we can add
new entities (i.e. create a new repository) without having to edit the already working and tested code.

- Improves Maintainability
The project is easier to update and fix since common functions are kept in one place (e.g. ```AbstractRepository``` is placed in the same directory as the other repositories).
This way, we just need to change a component instead of the whole codebase when dealing with a bug or minor changes to be made.

**3. The disadvantage of not applying SOLID principles in my project are listed below:**
- Dependency between components/codes
The codes will be tightly connected to specific implementations instead of abstractions, making it harder to update or replace. 
An example would be if a service later is directly linked to a specific repository, and making changes means other layers
must be changes as well. 

- Reduce Maintainability
If different responsibilities aren't separated clearly, any updates made (large or small) must be changed in the controller, repository, and 
service. An example would be handling the logic of "update car" in controller instead of isolating it in the repository or service since any changes
will affect the other codes. 

</details>