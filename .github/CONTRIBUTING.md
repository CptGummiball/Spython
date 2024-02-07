
# Contribution Guidelines


# Project Structure

## Pull Requests

**Functional Code Requirement:**
   - Ensure that the code submitted in a pull request is functional and has been tested successfully.

**Submit Ideas Through Issues:**
   - Before implementing new features or changes, consider submitting ideas through issues. This helps avoid unnecessary effort in case the proposed changes are not accepted or become obsolete.

**Avoid Direct Pull Requests for Ideas:**
   - Ideas and proposed changes should not be directly submitted as pull requests. Instead, create an issue first to discuss and gain feedback.

**Discussion in Issues:**
   - Use issues for discussions related to proposed changes, improvements, or new features. This allows for collaboration and ensures that the community is involved in the decision-making process.


## Code Comments

**Comments Are Essential:**
   - Add comments to your code explaining the purpose and functionality of functions, especially within complex functionality classes.

**Comment Format:**
   - Follow a consistent commenting format to enhance code readability. Include a brief description of the function's purpose and any critical details.

**Inline Comments:**
   - Use inline comments sparingly to explain specific lines of code if they might be unclear to others.

**DATA and FUNCTION** Note: _Only in DataBridge.java_
   - Methods that get data have to be marked with //DATA: <comment>
   - Methods that execute server-side actions have to be marked with //FUNCTION: <comment>
   
## DataBridge
**Avoid Complex Code in DataBridge:**
   - The `DataBridge` class (`org/cptgum/spython/GetData/DataBridge.java`) is intended for simple data retrieval functions. Please refrain from implementing complex logic directly within this class.

**Use Separate Java Files for Complex Functions:**
   - For more elaborate functionalities, create separate Java classes in the `org/cptgum/spython/GetData/` directory.

**Organize Functions by Functionality:**
   - Group related functions in the respective classes based on their functionality. This could include classes for player actions, inventory operations, etc.

**Link Functions Through DataBridge:**
   - Implement simple calls in the `DataBridge` class to invoke complex functions from other classes. The `DataBridge` class should serve as an interface for data retrieval, not as a location for intricate logic.


### Example

**Complex Function Class:**
```java
// Example for a complex function in a separate class
package org.cptgum.spython.GetData;

public class PlayerActions {

    public static void doComplexAction(String playerName) {
        // Complex code here...
    }
}
````
**Simple Interface in DataBridge:**
````java
// Example for a simple interface in DataBridge
package org.cptgum.spython.GetData;

public class DataBridge {

    // Simple call for the complex function
    public static void callComplexAction(String playerName) {
        PlayerActions.doComplexAction(playerName);
    }

    // Additional simple functions for data retrieval...
}
````

## Python Libraries

**Functionality Testing:**
   - Before adding Python libraries for specific functions, ensure their functionality is tested thoroughly.

**Installation Files and Scripts Not Required:**
   - Only the pure library is needed. Installation files and scripts are unnecessary.

**Library Location:**
   - Place Python libraries in the `src/main/resources/libaries/` directory.
