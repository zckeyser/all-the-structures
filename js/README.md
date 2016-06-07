# Set-up Instructions
To run the tests in this section of the repo, you'll need to have node.js (https://nodejs.org/en/)
so you can install dependencies & so we can use the karma test runner.

After node.js is installed, you'll need to initialize some dependencies by
running the following:

```
npm i
npm i -g karma-cli
```

Once you've run those commands, you'll be able to run the tests via the command:

```
karma start
```

This command should either be invoked from the /js folder of the directory or else
be given an argument pointing to the config file at /js/karma.conf.js. For example,

```
karma start ../karma.conf.js
```

# File Structure
Modularity of the program is handled by wrapping everything in prototypes,
since the typical require() syntax doesn't play very nice with karma.

Source files are held in the src folder, with the algorithms being in
equivalent folders to their partners in the Java repo.

Test files are in the test folder, and the tests themselves are written
using jasmine (http://jasmine.github.io/)
