# LinioTest
 - core: it contains all elements used in business modules like favorites, here you can find elements related to architectural pattern used or widget components 
 - favorites: Here I added all packages related to favorites module, I have 3 layers based on CLEAN arch:
 - **data**: usually you can put all datasources used in the app
 - **domain**: objects related to business logic and repositories for consuming in high level layers like presentation
 - **framework**: here you should implement the datasources provided from data layer because this layer is related to the android framework also here you can put your view models, adapters and others elements that contain libraries from android core or are using layers related to it. 
