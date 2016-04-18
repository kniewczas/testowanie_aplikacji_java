Given a messenger
When message sending to server inf.ug.edu.pl is hello
Then messenger should return 1.

When message sending to server inf.ug.edu.pl is hello
Then connection should be 1.

When message sending to server inf.ug.edu.eu is hello
Then connection should be 1.

When message sending to server inf.ug.edu.pl is hello
Then connection should be 1.

When message sending to server inf.ug.edu.inf is he
Then connection should be 1.

When message sending to server inf.ug.edu.inf is he
Then connection should be 1.

