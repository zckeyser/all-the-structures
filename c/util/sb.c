#include <stdlib.h>
#include <string.h>

#include "sb.h"

void StringBuilder_init(StringBuilder *sb) {
    // initialize buf to empty string
    sb->buf = malloc(sizeof(char));
    sb->buf[0] = '\0';

    sb->len = 0;
    sb->capacity = 1;
}

void StringBuilder_append(StringBuilder *sb, char *s) {
    sb->len += strlen(s);

    // we need to expand the buffer
    if(sb->len > sb->capacity) {
        // double the size of the buffer and copy the old contents over
        sb->capacity *= 2;

        // make sure to alloc an extra bit for '\0'
        char *newBuf = malloc((sizeof(char) * sb->capacity) + 1);
        strcpy(newBuf, sb->buf);

        // free the old buffer
        free(sb->buf);

        // set the new buffer
        sb->buf = newBuf;
    }

    strcat(sb->buf, s);
}

char* StringBuilder_build(StringBuilder *sb) {
    return sb->buf;
}
