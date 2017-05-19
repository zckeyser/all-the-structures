package sorts

import "../testhelper"

import "testing"

func TestQuicksort(t *testing.T) {
  arr := testhelper.RandomIntSlice(testhelper.ArraySize)

  sorted := Quicksort(arr)

  testhelper.AssertIsSorted(sorted, t)
}
