# Lab 16: CodeFellowship Profiles

## Build an app that allows users to create their profile on CodeFellowship.

- The site should have a splash page at the root route (/) that contains basic information about the site, as well as a link to the “sign up” page.
- An ApplicationUser should have a username, password ( hashed using BCrypt), firstName, lastName, dateOfBirth, bio, and any other fields you think are useful.
- The site should allow users to create an ApplicationUser on the “sign up” page.
- Your Controller should have an @Autowired private PasswordEncoder passwordEncoder; and use that to run passwordEncoder.encode(password) before saving the password into the new user.
- The site should have a page which allows viewing the data about a single ApplicationUser, at a route like /users/{id}.
- This should include a default profile picture, which is the same for every user, and their basic information.
- Using the above cheat sheet, add the ability for users to log in to your app.
- Upon logging in, users should be taken to a /myprofile route that displays their information.
- Ensure that user registration also logs users into your app automatically.
- The site should be reasonably styled. (This can be using CSS that you did not create yourself.)
- The site should contain integration testing. At a minimum, there should be tests to ensure basic functionality for the splash page and the sign up page.

## Run the app.

- Navigate to project in the terminal
- $ gradle bootRun
- Open brower and navigate to http://localhost:8080
- Create a profile

## Routes
- /users
- /login
- /signup

## Contributions 
- Manish KC

-------------------------------------------------------

# Lab 17: CodeFellowship Profiles with Login

## Build on top off Lab 16 > Enable the user to create a post and add it to their profile

- Allow users to log in to CodeFellowship and create posts.

- Using the above cheat sheet, add the ability for users to log in to your app.
- Upon logging in, users should be taken to a /myprofile route that displays their information.
- Ensure that your homepage, login, and registration routes are accessible to non-logged in users. All other routes should be limited to logged-in users.
- Ensure that user registration also logs users into your app automatically.
- Add a Post entity to your app.
- A Post has a body and a createdAt timestamp.
- A logged-in user should be able to create a Post, and a post should belong to the user that created it.
    -hint: this is a relationship between two pieces of data
- A user’s posts should be visible on their profile page.
- When a user is logged in, the app should display the user’s username on every page (probably in the heading).

## Run the app.

- Navigate to project in the terminal
- $ gradle bootRun
- Open brower and navigate to http://localhost:8080
- Create a profile, make a post, view post on profile

## Routes (still working on getting routes... working)
- /users
- /login
- /signup
- /post/makepost

## Contributions 
- Manish KC

-------------------------------------------------------

# Lab 18: Following Users on CodeFellowship

## Build on top off Lab 16 > Enable the user to create a post and add it to their profile

- Ensure that users can’t perform SQL injection or HTML injection with their posts.
- Allow users to follow other users. Following a user means that their posts show up in the logged-in user’s feed, where they can see what all of their followed users have posted recently.
- Ensure there is some way (like a users index page) that a user can discover other users on the service.
- On a user profile page that does NOT belong to the currently logged-in user, display a “Follow” button. When a user clicks that follow button, the logged-in user is now following the viewed-profile-page user.
 -note: this will require a self-join on ApplicationUsers. 
- A user can visit a url (like /feed) to view all of the posts from the users that they follow.
- Each post should have a link to the user profile of the user who wrote the post.

## Run the app.

- Navigate to project in the terminal
- $ gradle bootRun
- Open brower and navigate to http://localhost:8080
- Create a profile, make a post, view post on profile, like posts

## Routes (still working on getting routes... working)
- /users
- /login
- /signup
- /post/makepost

## Contributions 
- Manish KC
- Chris Coulon

