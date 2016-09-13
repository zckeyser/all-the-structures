#ifndef ASSERT_HEADER
#define ASSERT_HEADER

// Minimalist set of test functions to allow testing of the structures in the project
int ASSERT_INT_EQUALS(int expected, int result, char* message);
int ASSERT_STR_EQUALS(char expected[], char result[], char* message);
int ASSERT_ARR_EQUALS(int *expected, int *result, char *message, int len);
int ASSERT_TRUE(int result, char* message);
int ASSERT_FALSE(int result, char* message);

#endif
