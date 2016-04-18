Given a bread manager
When add bread with name jasny, price 2.23 and code 1234
When add bread with name ciemny, price 2.23 and code 5678
Then amount of breads should be 2

When remove bread with code 1234
Then amount of breads should be 1
