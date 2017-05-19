package sorts

import "../testhelper"

import "testing"

func TestRadixSort(t *testing.T) {
  arr := testhelper.RandomIntSlice(testhelper.ArraySize)

  sorted := RadixSort(arr)

  testhelper.AssertIsSorted(sorted, t)
}
