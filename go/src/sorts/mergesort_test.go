package sorts

import "../testhelper"

import "testing"

func TestMergesort(t *testing.T) {
  arr := testhelper.RandomIntSlice(testhelper.ArraySize)

  sorted := Mergesort(arr)

  testhelper.AssertIsSorted(sorted, t)
}
