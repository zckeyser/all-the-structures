package sorts

import "../testhelper"

import "testing"

func TestIntMergesort(t *testing.T) {
  arr := testhelper.RandomIntSlice(100)

  sorted := Mergesort(arr)

  for i := 0; i < 99; i++ {
    if sorted[i] > sorted[i + 1] {
      t.Error("out of order at indexes ", i, " and ", i + 1, " ", sorted[i], " > ", sorted[i + 1])
    }
  }
}

func TestInterfaceMergesort(t *testing.T) {

}
