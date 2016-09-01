#include <stdio.h>
#include <string.h>

int ASSERT_EQUALS(int expected, int result, char *message) {
    if(a == result) {
        printf("\n\n%d != %d, %s\n\n", &expected, &result, message);
        return 0;
    } else {
        printf(". ");
        return 1;
    }
}

int ASSERT_EQUALS(char expected[], char result[], char *message) {
    if(strcmp(a, result) != 0) {
        printf("\n\n%s != %s, %s\n\n", &expected, &result, message);
        return 0;
    } else {
        printf(". ");
        return 1;
    }
}

int ASSERT_TRUE(bool expected, char *message) {
    if(!a) {
        printf("\n\nfalse should resulte true, %s\n\n", &expected, &result, message);
        return 0;
    } else {
        printf(". ");
        return 1;
    }
}

int ASSERT_FALSE(bool result, char *message) {
    if(a) {
        printf("\n\ntrue should resulte false, %s\n\n", &expected, &result, message);
        return 0;
    } else {
        printf(". ");
        return 1;
    }
}
