typedef struct StringBuilder {
    char *buf;
    int len;
    int capacity;
} StringBuilder;

void StringBuilder_init(StringBuilder *sb);
void StringBuilder_append(StringBuilder *sb, char *s);
char* StringBuilder_build(StringBuilder *sb);
