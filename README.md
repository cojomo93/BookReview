
Features of the application:

When app opens, it takes you to a sign in screen.
The credentials can be found in "UserList", however I normally use:
Username: samspade
Password: password   
Once authenticated, you are taken to the main page where you can either exit the application or click on "See Book Review" 
Once you click on "See Book Review" all the reviews that have been posted will display.
If you would like to add a review you can click on "Add review" which will take you to a new window
once you fill in the blanks along with the rating (which I added for this deliverable) and click "save."
Once you click save, you are taken to the reviews page where you can see at the bottom, your new review.
I updated the main panel that shows all the reviews with a searching feature.
You can search by:
    -Title
    -Author
    -ISBN
    -Star rating
Once you start typing in the search bar, the table refreshes to show the users which reviews come closest to what you search for.

*There is a bug where you can only add one review before restarting the application*
*If you delete the app.ser file, the program will throw a bunch of errors and will not work*

How to test:
-sign in
-see book reviews
-add new book review with added category of ratings (1-5)
-refreshes book reviews and adds your new review
-added a ReviewSet class to turn the arraylist into a hashSet(easier to tell if something exists witin the set when compared to maps)
    -To test you can just look at the class
-Search for the book you just added and the display will (hopefully) put your new review at the top of the table


Class Structure:

Model classes: User, UserList, Review, ReviewList

View classes: AddReviewUI.fxml, LoginUI.fxml, ReviewListUI.fxml, NavigationUI.fxml

Controller classes: AddReviewCntl, AddReviewUICntl, NavigationCntl, NavigationUICntl, PersistentDataCntl, ReviewListCntl, ReviewListUICntl, UserCntl, LoginCntl


How control is passed between classes:

When you start the application: BookReviewApp calls LoginUI.fxml and LoginCntl, To authenticate the userlist is matched up with users in userList
Once authenticated, loginCntl calls NativagationCntl, NavigationCntl calls NavigvationUI.fxml and displays the main page. 
On the main page there are two buttons: the get reviewList and exit button which are actionlistners contained in NavigationUICntl
If you click on get review list you are taken to the review list page where the reviewListCntl is in charge and calls the ReviewListUI.fxml
Once initialized, the ReviewListUICntl takes control and displays the observable list and also handles the action listeners.
When you search for something, the controller takes the input from the searching window and matches it up with data from the filtered list of the reviews.
Once the reviews are filtered, the controller calls the viewer to update the window to match what the search results should be.
You can then click on "add a review" and addReviewCntl is called and takes control and then calls on AddReviewUI.fxml to display the needed blanks for the review
Once this happens, control is passed to the AddReviewUICntl which is in charge of taking all the information typed into the blanks and handling the action listeners
These lines of code in AddReviewUICntl show how the information is then added to the arrayList:
        
        AddReviewCntl.getAddReviewCntl(stage).addReviewsAdded(review);
        NavigationCntl.getNavigationCntl(stage).getReviewListCntl(stage);
        listOfReviews = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getReviewList().getReviewData();
        reviewTable.setItems(listOfReviews);

The add review window is then closed and the review list page after getting a request from controller to refresh is then updates to show the added review.
