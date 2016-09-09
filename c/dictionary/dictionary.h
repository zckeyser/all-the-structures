#ifndef DICT_HEADER
#define DICT_HEADER

#define DICT_SIZE 256

struct Pair {
    int value;
    char *key;
    struct Pair* next;
};
typedef struct Pair Pair;

struct Dict {
    struct Pair data[DICT_SIZE];
    int contains[DICT_SIZE];
    int size;
};
typedef struct Dict Dict;

void Dict_init(Dict *dict);
void Dict_set(Dict *dict, char *key, int value);
int Dict_get(Dict *dict, char *key);

#endif
