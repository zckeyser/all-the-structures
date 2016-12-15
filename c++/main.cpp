#include <iostream>

#include "test/assert.h"

int main() {
    if(test::assertTrue(true, "foo")) {
        std::cout << "we did it!";
    }

	return 1;
}
