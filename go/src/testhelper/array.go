package testhelper

import "math/rand"
import "time"

var rng = rand.New(rand.NewSource(time.Now().UnixNano()))

func RandomIntSlice(size int) (arr []int) {
  for i := 0; i < size; i++ {
    arr = append(arr, rng.Int())
  }

  return
}
