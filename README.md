# Banking-User-Onboarding

* Banking user onboarding System manages the onboarding process of users
* In this API the onboard process for users has to maintain sufficient balance to be add themself and create new account.
* Its a backend code written using Spring-Boot
* It consists of Different Layers like Controller, Service, Repository.
* These layers in the project increases its code maintanablity, understadability and readablity

___

# Functionality

## I. For Users
 Users can :-
- Register himself/herself in the system.
- 

## II. For User(student):
  Students can :-
- Student can add himself on portal as new student 
- Issue the book
- students have their specific departments so we can find student's department from their ID.


# Different Models / Entities / (Table in MySQL) In the Project
- Author Entity
- Student Entity
- LibraryCard Entity
- Book Entity
- Transaction Entity


# Teck-Stack Used :
- Spring-Boot
- MySQL
- Java
- Hibernate
- JPA

# Schema Design

![image](https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/3de6a49a-ce8e-45f0-9eb8-abb991bd1a22)
<br>

# Author API's

- `Add Author` <br> <br>
![image](https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/d53aa6e3-34d7-48b0-be8f-cb6ca990630f) <br>
![image](https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/6d403ead-5684-4d54-88cc-0b21fae3990d)
<br><br>

- `Get author by it's id` 
<br> <br>
![image](https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/d7a0d8c5-b5e4-4010-b519-ce4ea18656d7)


- `Update author name and penName` <br> <br>
![image](https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/222e6de4-64be-4b08-b8a9-8eb906ac24e6)


![image](https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/6d403ead-5684-4d54-88cc-0b21fae3990d)

- after updating the name and penName  <br> <br>
![image](https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/3e3732f6-af7b-40a2-8fec-b5693763dfb5)
<br> <br>


- `Delete Author by it's ID` <br> <br>
![image](https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/d6c651cd-f559-448a-b2ff-dd2fc07f62f5)
  
___

# Book API's

- `Add book` <br> <br>
- 
  ![image](https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/aaa29b01-8af2-4233-8aa2-d7240580d806)
  ![image](https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/b633a4e3-d5d3-4573-bee4-f73a5b4a1fc0)

<br> 

- `get books by it's Genre` <br> <br>
![image](https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/7d194b31-134f-495f-8790-417d623672e4)

___
# Student API's
- `Add student` <br> <br>
![image](https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/15f911ec-0126-4f56-b211-ff161d499a41)
![image](https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/11608514-796b-42e6-b16a-1f22359210ed)


  
- `Find department by Id` 
- Here i'm testing corner case by putting wrong student ID
  <br> <br>
![image](https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/a771ccdd-c853-48c2-939f-e64ad64d4de6)



- and after putting correct studentID as param :
<br> <br>
![image](https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/67c22034-3284-4d98-b1ff-200ee2815203)


___
# Card API's 

- `Add card `  <br><br>
![image](https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/a65338be-70f9-4cff-a307-a49765672c0b)
![image](https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/056d7dfb-46cd-4417-93c4-ba59729e37d3)


- `Issue to student` <br> <br>
![image](https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/a2720e90-2bad-4243-9e19-146558ba994f)


- after updating the card linking with issue to student
<br><br>
![image](https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/5a1e8e9f-bbd4-427a-a2cc-1abc4b1e1f34)

