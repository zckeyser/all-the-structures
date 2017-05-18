package testhelper

import "testing"
import "math/rand"
import "time"
import "fmt"

var rng = rand.New(rand.NewSource(time.Now().UnixNano()))

func RandomIntSlice(size int) (arr []int) {
  for i := 0; i < size; i++ {
    arr = append(arr, rng.Int())
  }

  return
}

func TestIsSorted(arr []int, t *testing.T) {
  if len(arr) == 0 {
    return
  }

  for i := 0; i < len(arr) - 1; i++ {
    if arr[i] > arr[i + 1] {
      t.Error(fmt.Sprintf("array is out of order at indexes %d and %d, %d > %d", i, i + 1, arr[i], arr[i + 1]))
    }
  }
}
