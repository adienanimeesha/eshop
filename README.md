# Reflection 1 
To ensure clean code principle is applied, I create variable names that describes their purpose.
For example, createProductPost and deleteProduct. This way, others can immediately understand the 
function of the variable. I also maintain a consistent naming convention, by capitalizing the 
first letter of each word, such as ProductService. Other than that, the MVC pattern is used, where there are
files that contains business logic, handles HTTP request, and manages data storage. To ensure secure coding practice 
is applied, adding a "findById(id)" helps check whether a product exists before allowing users to delete or 
update. An area of improvement would be to handle products that does not exist, which is done by modifying the 
"findById(id)" code to return an error message instead of showing null. 
