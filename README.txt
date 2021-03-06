Fermat's Nearest-Miss Finder
Fermat.jar

DESCRIPTION:
  Mathematician Pierre Fermat proved that no arbitrary natural numbers x, y, and z could 
  satisfy the equation x^n+y^n=z^n where n is a natural number above 2. This program searches 
  for values of z given integers x and y greater than 10 (and less than a specified user input value k)
  that satisfy the above equation, noting misses, that is the distance from
  the true z value to the nearest integer value. In running this program, providing a bound on
  the x and y values as well as an n value, it will search for misses and output the conditions
  under which the miss was discovered every time a smaller relative miss size percentage
  is found.

INSTALLATION:
  This program uses the Java Runtime Enrivonment to run the Fermat.jar file. The user should have this installed alongside the .jar file
  on their machine. To run the program, a user needs to open their command prompt, set the directory to the location of the .jar file, 
  and enter the line "java -jar Fermat.jar". This will present a set of instrucitons and allow the user to begin their input of the
  program.
  
INSTRUCTIONS:
  This program follows searches for the nearest smallest miss between the values of x^n + y^n and z^n. Upon running the program, the user 
  will be prompted for a value for n as seen in the formula between 2 and 12 exclusive, after which the user will also be prompted for a 
  value for k, which determines all tested integers that x and y can be, which is greater than 10 and less than k, inclusive. The upper
  bound of what k can be will be determined on what the user inputs for n, so as to keep the formula for Fermat's near-misses from being 
  too bloated of values for the machine to handle. The program will run until it goes through all possible x and y values, displaying 
  the next nearest miss each time it encounters it. After this process, the program will end, and the user will need to run the program
  again to enter new values in. 
  
  The user also has the option of viewing the output of the program in the generated text file "small_output.txt" upon running entirely.
