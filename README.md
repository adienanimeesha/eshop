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

1. 


</details>