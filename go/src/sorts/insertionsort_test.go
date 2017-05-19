package sorts

import "../testhelper"

import "testing"

func InsertionSortTest(t *testing.T) {
  arr := testhelper.RandomIntSlice(testhelper.ArraySize)

  sorted := InsertionSort(arr)

  testhelper.AssertIsSorted(sorted, t)
}
