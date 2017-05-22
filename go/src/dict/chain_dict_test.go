package dict

import (
  "fmt";
  "testing";
  "strconv"
)

func TestChainingDictInsertOne(t *testing.T) {
  d := NewChainingDict(512)

  key := "foo"
  value := 5

  d.Set(key, value)

  result, ok := d.Get(key)

  if ok != nil {
    t.Error(fmt.Sprintf("got error: %s", ok))
  } else if result != value {
    t.Error(fmt.Sprintf("expected %d to equal %d", result, value))
  }
}

func TestChainingDictInsertMany(t *testing.T) {
  d := NewChainingDict(128)

  for i := 0; i < 2000; i++ {
    d.Set(strconv.Itoa(i), i)
  }

  for i := 0; i < 2000; i++ {
    result, ok := d.Get(strconv.Itoa(i))

    if ok != nil {
      t.Error(fmt.Sprintf("got error: %s", ok))
    } else if result != i {
      t.Error(fmt.Sprintf("expected %d to equal %d", result, i))
    }
  }
}
