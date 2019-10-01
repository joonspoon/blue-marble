# To run within Eclipse:
1. Fork, then clone this repository.
2. From Eclipse, File > Import > Existing Maven Projects.
3. Under src/main/java > hellofx, right click Launcher, and Run As > Java Application.

# To run from command line, using Maven:
```
git clone https://github.com/joonspoon/javafx-base
cd javafx-base
mvn clean javafx:run
```
# To complete this exercise:
1. Make a GUI that shows the view of the earth on a date chosen by the user.
2. If the user selects an option in the future, an exception will be thrown. Catch this exception and appropriately inform the user.
3. Add an option so that the user can choose to see the “enhanced” version of the image.
4. The database only includes enhanced images up until June 2018. Make the enhanced option inactive if the date selected is after that date.
5. Add an option to make the image black and white. 
