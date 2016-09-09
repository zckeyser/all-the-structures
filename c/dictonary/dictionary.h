#ifndef DICT_HEADER
#define DICT_HEADER

#define DICT_START_SIZE 128

struct Pair {
    int value;
    char *key;
};
typedef struct Pair Pair;

struct Dict {
    struct Pair data[DICT_START_SIZE];
    int contains[DICT_START_SIZE];
    int size;
};
typedef struct Dict Dict;

void Dict_init(Dict *dict);
void Dict_set(Dict *dict, char *key, int value);
int Dict_get(Dict *dict, char *key);

#endif
