package dict

import (
  "testing";
  "strconv"
)

var initialSize = 128
var size = 1000000

func BenchmarkLinearDictWrite(b *testing.B) {
  d := NewLinearDict(initialSize)

  for i := 0; i < b.N; i++ {
    for j := 0; j < size; j++ {
      d.Set(strconv.Itoa(j), j)
    }
  }
}

func BenchmarkLinearDictReadWrite(b *testing.B) {
  d := NewLinearDict(initialSize)

  for i := 0; i < b.N; i++ {
    for j := 0; j < size; j++ {
      d.Set(strconv.Itoa(j), j)
    }

    for j := 0; j < size; j++ {
      d.Get(strconv.Itoa(j))
    }
  }
}

func BenchmarkChainingDictWrite(b *testing.B) {
  d := NewChainingDict(initialSize)

  for i := 0; i < b.N; i++ {
    for j := 0; j < size; j++ {
      d.Set(strconv.Itoa(j), j)
    }
  }
}

func BenchmarkChainingDictReadWrite(b *testing.B) {
  d := NewChainingDict(initialSize)

  for i := 0; i < b.N; i++ {
    for j := 0; j < size; j++ {
      d.Set(strconv.Itoa(j), j)
    }

    for j := 0; j < size; j++ {
      d.Get(strconv.Itoa(j))
    }
  }
}
