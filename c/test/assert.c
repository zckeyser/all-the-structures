#include <stdio.h>
#include <string.h>

int ASSERT_INT_EQUALS(int expected, int result, char* message) {
    if(expected != result) {
        printf("\n\n%d != %d, %s", expected, result, message);
        return 0;
    } else {
        printf(". ");
        return 1;
    }
}

int ASSERT_STR_EQUALS(char expected[], char result[], char *message) {
    if(strcmp(expected, result) != 0) {
        printf("\n\n%s != %s, %s\n\n", expected, result, message);
        return 0;
    } else {
        printf(". ");
        return 1;
    }
}

int ASSERT_ARR_EQUALS(int *expected, int *result, char *message, int len) {
    for(int i = 0; i < len; i++) {
        if(expected[i] != result[i]) {
            printf("\n\narrays not equal at index %d, %d != %d", i, expected[i], result[i]);

            return 0;
        }
    }

    return 1;
}

int ASSERT_TRUE(int result, char *message) {
    if(result != 1) {
        printf("\n\nfalse should equal true, %s\n\n", message);
        return 0;
    } else {
        printf(". ");
        return 1;
    }
}

int ASSERT_FALSE(int result, char *message) {
    if(result != 0) {
        printf("\n\ntrue should equal false, %s\n\n", message);
        return 0;
    } else {
        printf(". ");
        return 1;
    }
}
