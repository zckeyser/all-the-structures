#ifndef ASSERT_HEADER
#define ASSERT_HEADER

#include <string>

namespace test {
    bool assertEquals(std::string expected, std::string result, std::string message);
    bool assertEquals(int expected, int result, std::string message);
    bool assertTrue(bool result, std::string message);
    bool assertFalse(bool result, std::string message);
}

#endif
