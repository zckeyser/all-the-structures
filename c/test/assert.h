// Minimalist set of test functions to allow testing of the structures in the project
int ASSERT_EQUALS(int expected, int result);
int ASSERT_EQUALS(char expected[], char result[]);
int ASSERT_TRUE(bool result);
int ASSERT_FALSE(bool result);

typedef struct TestResult {
    int passed;
    int total;
};
