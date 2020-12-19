# Frogger Java (Chevalier Tan Ga Foo - 20209307)

Completed as coursework for COMP2042 Software Maintenance - University of Nottingham. 

Briefly, the key changes for maintenance include folder restructuring to adhere closely to MVC, generating and populating Javadocs, refactoring spaces and tabs for better readability, building the project with Maven, and using Github for version control in the project. 

The key extensions made include a main menu screen, a high score alert, an info screen, version number display, and accumulative points. 

## Maintenance

###### Versions

Version number is available in the menu screen showing the current version. Future versions may include higher quality images, soundtracks, new controls etc. Players can look up versions to see its history and developers can maintain different versions seperately for better maintanability. 

This change was made in the fxml file (MenuView.fxml)

###### Model, View, and Controller (MVC)

The project is seperated into the folders (Controller, Model, Resources, View) to adhere closely with the MVC pattern. The seperation of concerns and placing files into respective folders lead to better organization and code readability/purpose.

This change was made in the overall project.

## Extensions

###### Main Menu Screen

The main menu screen was made in an .fxml file with Scene Builder and imported by an FXMLLoader in the Main.java file. It has a controller MenuController to register and respond to events. This screen was made as a starting page for more functionality before the game.

This change was made in the fxml file (MenuView.fxml) and controller (MenuController.java)

###### Info Screen

The info screen was made in an .fxml file with Scene Builder and imported by an FXMLLoader in the Main.java file. It has a controller InfoController to register and respond to events. This screen was made to explain the game story and provide clear instructions on how to play the game. 

This change was made in the fxml file (InfoView.fxml) and controller (InfoController.java)

###### High Score

The high score alert is made and presented in code. Specifically, it uses the functionality of its own class (HighScore.java) and is called in the class (Animal.java) whenever a death occurs in the game. The current score and a list, limited to 5 scores, of previous high scores will be shown as well. 

This change was made in the class (HighScore.java)

