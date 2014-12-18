##Check list

1. All files are commented. Also all methods and functions. Comment the variable about its legal values, dimensions and units. Do not overcomment and immediately remove false/old/useless comments
2. No magic numbers. Use Constants instead that are all defined at the beginning.
3. Same for strings.
4. Do Not repeat yourself. Define everything that is used more than once in a separate function.
5. Write Readable code. Functions should be as simple and as short as possible. To write complex algorithms prefer using some functions with concise names over a long list of basic statement.
6. At the start of a function throw an error if the arguments are invalid. May be overkill for internal function and dialogs.
7. Respect Naming norms for identifiers. Avoid using shortcuts and avoid acronyms. function and methods should be named for what they do: getX, setX, xFromY, isX, etc
8. Optimize, especially in big loops. There s no need to optimize too early.
9. Declare variables at the beginning and use minimum memory.
10. Write at least 2 tests for every non trivial function. Getters and setters are trivial.
11. Do not write too much on 1 line.
12. Separate interface(print and input and calls the model) and model(here we do the math).
13. Indent.
14. 