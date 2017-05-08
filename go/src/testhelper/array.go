package testhelper

import "rand"
import "time"

func RandomIntSlice(size int) (arr []int) {
  for i := 0; i < size; i++ {
    arr = append(arr, randomInt())
  }

  return
}

rng rand.Rand := nil

func randomInt() (int) {
  if rng == nil {
    rng := rand.New(rand.NewSource(time.Now().UnixNano()))
  }

  return rng.Int()
}
