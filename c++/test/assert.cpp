#include <string>
#include <iostream>

#include "assert.h"

namespace test {
    bool assertEquals(std::string expected, std::string result, std::string message) {
        if(expected.compare(result) == 0) {
            std::cout << ". ";
            return true;
        } else {
            std::cout << message << std::endl;
            return false;
        }
    }

    bool assertEquals(int expected, int result, std::string message) {
        if(expected == result) {
            std::cout << ". ";
            return true;
        } else {
            std::cout << message << std::endl;
            return false;
        }
    }

    bool assertTrue(bool result, std::string message) {
        if(result) {
            std::cout << ". ";
            return true;
        } else {
            std::cout << message << std::endl;
            return false;
        }
    }

    bool assertFalse(bool result, std::string message) {
        if(!result) {
            std::cout << ". ";
            return true;
        } else {
            std::cout << message << std::endl;
            return false;
        }
    }
}
