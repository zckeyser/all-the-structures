#include <stdio.h>
#include <string.h>

int ASSERT_INT_EQUALS(int expected, int result) {
    if(expected != result) {
        printf("\n\n%d != %d", &expected, &result);
        return 0;
    } else {
        printf(". ");
        return 1;
    }
}

int ASSERT_STR_EQUALS(char expected[], char result[]) {
    if(strcmp(expected, result) != 0) {
        printf("\n\n%s != %s", &expected, &result);
        return 0;
    } else {
        printf(". ");
        return 1;
    }
}

int ASSERT_TRUE(int result, char message[]) {
    if(result != 1) {
        printf("\n\nfalse should equal true, %s\n\n", message);
        return 0;
    } else {
        printf(". ");
        return 1;
    }
}

int ASSERT_FALSE(int result, char message[]) {
    if(result != 0) {
        printf("\n\ntrue should resulte false, %s\n\n", message);
        return 0;
    } else {
        printf(". ");
        return 1;
    }
}
