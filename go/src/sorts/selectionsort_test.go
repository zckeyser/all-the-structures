package sorts

import "../testhelper"

import "testing"

func TestSelectionSort(t *testing.T) {
  arr := testhelper.RandomIntSlice(testhelper.ArraySize)

  sorted := SelectionSort(arr)

  testhelper.AssertIsSorted(sorted, t)
}
