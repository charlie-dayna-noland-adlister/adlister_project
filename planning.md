ADLISTER SKETCH:

Have to Do:

1. Login/Authenticate
2. CRUD on Two Entitiies.
3. Interact with an API.

Stories:
	Admin: 		
	    1. CRUD on Ads
		2. CRUD on Users.

	User:
		1. CRUD on themselves.
			a. Have my own profile.
		2. CRUD on Ads.
		3. Report Ads.
		4. Review Ads.
		5. Reviews are result of cumulative reviews on ads.
		6. Save ad(like a shopping cart or wishlist)
		8. Share Ads.
		9. Follow User.
	Guest User:
		1. Read on Ads.
		2. Register for an Account.
		3. R on Users.


DATABASE:
	User:
		COMPLETE 1. Id
		COMPLETE 2. Username
		COMPLETE 3. Email
		COMPLETE 4. Password
		COMPLETE 5. User Image
		COMPLETE 6. User_Review_Reputation
		COMPLETE 7.  Users_Followed
		COMPLETE 8. Times_Reported
		COMPLETE 9. Number_Ads_Reported
		COMPLETE 10. Number_Reviews
		COMPLETE 11. Wishlist
		COMPLETE 12. Zipcode
		COMPLETE 13. is_admin
	Ad:
		COMPLETE 1. Title
		COMPLETE 2. Description
		COMPLETE 3. Image
		COMPLETE 4. Id
		COMPLETE 5. User Id 
		COMPLETE 6. Price
	`	COMPLETE 7. Date Posted?
		COMPLETE 8. Review Average(Derived From Review/ Rating Points)
		COMPLETE 9. Category
		COMPLETE 10. Quantity_Reported
		COMPLETED 11. Users_Reported
		
	Review:
		COMPLETE 1. Ad_Id
		COMPLETE 2. User_Id
		COMPLETE 3. Review_Text
		COMPLETE 4. Point Rating.
		COMPLETE 5. Attached Picture
		COMPLETE 6. Id
		
	    | Field       | Type                | Null | Key | Default | Extra          |
        +-------------+---------------------+------+-----+---------+----------------+
        | id          | int(10) unsigned    | NO   | PRI | NULL    | auto_increment |
        | user_id     | int(10) unsigned    | NO   | UNI | NULL    |                |
        | review_text | varchar(250)        | NO   |     | NULL    |                |
        | rating      | tinyint(6) unsigned | NO   |     | NULL    |                |
        | image       | blob                | YES  |     | NULL    |                |
        | image_text  | longtext            | YES  |     | NULL    |                |
        | ad_id       | int(10) unsigned    | NO   | MUL | NULL    |               

DESIGN:
		Models:
			Factory:
			DAOs:
				Ads
				Users
				Reviews
			Beans:
				Ad
				User
				Review
			DB:	
				Ads
				Users
				Review		
		Views:
			partials
			profile
			ads
			register
			login
			index
			error
		Controllers:
			ad
			profile
			login
			register
			index
			error
		MYSQL INIT
		

You will notice there are still many things left to do in our project.
This is not an exhaustive list; use your imagination and talk to your instructors for guidance on feature scope.
* Ad show page Create a page that shows the information about an individual ad. This page should show all the information about that ad, as well as the information about the user that posted the ad. Your ads index page should contain links to each individual ad page. You should have one page that displays the information for any arbitrary ad. Consider passing the id of the ad as a parameter in the GET request to this page. 
* Search Implement functionality that allows users to search through the ads in your database. 
* Show user's ads on their profile page When a user visits their profile page, they should see all of the ads they have created. 
* Ensure usernames are unique Change your database schema to enforce that values in the username column of the user table are unique. Make sure a new account cannot be created with an existing username. 
* Clean up the code You'll notice there is some duplicated code in our ads DAO and our users DAO. How could you create an abstraction for this? 
* Dynamic navbar Wouldn't it be nice if our navbar showed different links depending on if a user was logged in or out? 
* Allow users to update and delete ads You will need to make some changes to the frontend so that users can discover this functionality, as well as implement the backend logic necessary to update your database. 
* Allow users to update their profile information 
* Validate data Ensure that the data we get from our users is valid before saving it to the database. Consider creating some classes related to validation. 
* Error messages Isn't it frustrating when a site won't let you submit a form but won't tell you why? Implement functionality to display error messages to users if they do something wrong, for example, if they try to register but their passwords don't match, or if they try to create a ad without a title. Consider storing error messages temporarily in the session and having a messages.jsp partial to handle this. 
* Sticky Forms When a submission is rejected because one or more of our validation constraints fails, we should still see the old values in the form for creating an ad, the users' input should not be erased. 
* Allow an Ad to have many categories Create a categories table and implement all the backend logic necessary to tie a category to an ad. This should be a many to many relationship (an ad can have many categories, and a category can have many ads associated with it). In addition, allow users to search through ads by category. 
* Intended Redirects When a user is redirected to the login page, after a successful login, they should be sent back to the page they were trying to visit, as opposed to the default, the profile page. 
